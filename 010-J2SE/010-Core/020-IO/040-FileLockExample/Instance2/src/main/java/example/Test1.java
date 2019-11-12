package example;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Test1 {
    public static void main(String[] args) throws IOException {
        File file = new File("../tmp/test.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileChannel newChannel = (randomAccessFile).getChannel();
        FileLock fileLock = newChannel.lock();
        fileLock.release();
        newChannel.close();
        System.out.println("File locked");
        boolean result = file.renameTo(new File("../tmp/test2.txt"));
        System.out.println("rename result " + result);
        while(true){}
    }
}
