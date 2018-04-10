package com.techoffice.example;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FileWatchDog extends Thread{

	private Path path;
	private WatchService watcher;
	private static final long delay = 10000;
	
	public FileWatchDog(Path path) throws IOException{
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
