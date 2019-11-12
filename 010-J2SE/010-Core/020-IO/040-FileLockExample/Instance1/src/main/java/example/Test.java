package example;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class Test {

	public static void main(String[] args) throws Exception {
		File file = new File("../tmp/test.txt");
		FileChannel fileChannel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE);
		FileLock fileLock = fileChannel.lock();
		System.out.println("file locked");
		boolean result = file.renameTo(new File("../tmp/test2.txt"));
		System.out.println("rename result " + result);
		fileLock.release();
		fileChannel.close();
		while(true){}
	}
}
