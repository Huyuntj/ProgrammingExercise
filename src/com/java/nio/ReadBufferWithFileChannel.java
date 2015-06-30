package com.java.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadBufferWithFileChannel {

	public static void main(String[] args) {
		try {
			RandomAccessFile  file = new RandomAccessFile ("C:\\Users\\I069194\\workspace\\SelfLearningExecise\\src\\com\\java\\file\\test","rw");
			FileChannel fileChannel = file.getChannel();
			ByteBuffer buffer =  ByteBuffer.allocate(1);
			int byteRead = fileChannel.read(buffer);
			while(byteRead != -1){
				//System.out.println("Read: " + byteRead);
				buffer.flip();
				while(buffer.hasRemaining()){
					System.out.print((char)buffer.get());
				}
				buffer.clear();
				byteRead = fileChannel.read(buffer);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
