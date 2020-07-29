package io;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    private static final int BSIZZE =1024;
    public static void main(String[] args) throws Exception{
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("some texxt".getBytes()));
        fc.close();
    }
}
