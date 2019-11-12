package example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Test2 {
    public static void main(String[] args) throws Exception {
        File file = new File("../tmp/test.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rws");
        FileChannel newChannel = (randomAccessFile).getChannel();
        FileLock fileLock = newChannel.lock();
        System.out.println("File locked");
        boolean result = file.delete();
        System.out.println("delete result " + result);
    }
}
