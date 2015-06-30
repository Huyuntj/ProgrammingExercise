package com.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SocketChannelExample {

	public static void main(String[] args) throws IOException {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

		serverSocketChannel.socket().bind(new InetSocketAddress(8088));

//		serverSocketChannel.configureBlocking(false);

		while(true){

		    SocketChannel socketChannel =
		    serverSocketChannel.accept();

		    if(socketChannel == null){

		        System.out.println("wating.....");

		    }

		}

		
//		try {
//			SocketChannel sc = SocketChannel.open();
//			sc.connect(new InetSocketAddress("localhost",8080));
//			while(!sc.finishConnect()){
//				System.out.print("connecting...");
//			}
//			
//			ByteBuffer buf = ByteBuffer.allocate(48);				
//			int bytesRead = sc.read(buf);
//			while(bytesRead != -1){
//				buf.flip();
//				char c = (char)buf.get();
//				if(c == 'E') break;
//				System.out.print(c);
//					
//				
//			}
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
	}

}
