package com.techoffice.example;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.*;

public class FileWatchDog extends Thread{

	private Path path;
	private WatchService watcher;
	private static final long delay = 1000;
	
	public FileWatchDog(Path path) throws IOException{
        System.out.println("Start Watch Dog on " + path.toFile().getAbsolutePath());
        this.path = path;
		this.watcher = FileSystems.getDefault().newWatchService();
		this.path.register(this.watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
	}
	
	@Override
	public void run(){
		boolean interrupted = false;
		while(!interrupted ){
			try {
				WatchKey watchKey = this.watcher.take();
	            for (WatchEvent<?> event: watchKey.pollEvents()) {
	            	if (event instanceof WatchEvent){
	            		WatchEvent<?> ev = (WatchEvent<?>)event;
	            		if (ev.context() instanceof Path){
	            			Path filename = (Path) ev.context();
							Path filePath = new File(this.path.toFile(), filename.toString()).toPath();
							try{
								FileChannel fileChannel = FileChannel.open(filePath, StandardOpenOption.READ);
                                FileLock lock = fileChannel.lock(0, Long.MAX_VALUE, true);
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                            System.out.println(filename + "Updated");
	            		}
	            	}
	            }
	            watchKey.reset();
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				interrupted = true;
			}
		}
	}
}
