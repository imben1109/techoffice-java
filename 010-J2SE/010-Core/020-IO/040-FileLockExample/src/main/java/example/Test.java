package example;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class Test {

	public static void main(String[] args) throws Exception {
		File file = new File("tmp/test.txt");
		FileChannel fileChannel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE);
		fileChannel.lock(0L, Long.MAX_VALUE, false);
		file.renameTo(new File("tmp/test2.txt"));
		while(true){}
	}
}
