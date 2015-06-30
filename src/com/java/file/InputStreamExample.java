package com.java.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamExample {

	public static void main(String[] args) {
		FileInputStream in = null;
		try {
			in = new FileInputStream(new File("C:\\Users\\I069194\\workspace\\SelfLearningExecise\\bin\\com\\java\\file\\test.txt"));
			byte[] b = new byte[20];
			int i = 0;
			while(  (i = in.read(b)) != -1){
			
				System.out.print(new String(b));
				 b = new byte[in.available()];
				
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

		}

	}

}
