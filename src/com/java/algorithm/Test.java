package com.java.algorithm;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class Test  {//implements Cloneable{

	private int field1;
	private Object object;
	
	@SuppressWarnings("finally")
	public int test(){
		try {
			System.out.println("try");
			throw new Exception();
			
		} catch (Exception e) {
			System.out.println("catch");
			return 1;
		}finally{
			System.out.println("finally");
//			return 2;
//			
		}
		
	}
	
	public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
		// TODO Auto-generated method stub
//		System.out.println('z' + 1);
//		char[] a = {'a','b'} ;
////		System.out.println(Arrays.toString(a));
//		Test test = new Test();
//		Test test2 = (Test) test.clone();
//		System.out.println(test2.getClass() == test.getClass());

//		String a = "agagadfdag";
//		byte[] arr = Base64.getDecoder().decode(a);
////		System.out.println(arr);
////		System.out.println(Base64.getEncoder().encodeToString(arr));
////		System.out.println((char)20013);
//		String s = "abc#3#ab#2##2##3#";
//		
//		List<String>  list = Arrays.asList(s.split("\\#\\d\\#"));
//		List<String>  list2 = Arrays.asList(s.split("#"));
//		System.out.println(list);
//		System.out.println(list2);
	SimpleDateFormat sdf = new SimpleDateFormat();
	sdf.applyPattern("yyyy/MM/DD HH:mm:ss");
//	System.out.println(sdf.format(new Date()));
	
	
	String regex = "(\\d)*";
	Pattern pattern = Pattern.compile(regex);
	System.out.println(pattern.matcher("1abc112").matches());
	System.out.println(pattern.matcher("123a").matches());
	Test test = new Test();
	Integer integer = new Integer(3);
	
	System.out.println(integer == 3);
	Date date = new Date();
	System.out.println(date.getTime());
	Thread.currentThread().sleep(1000);
	date = new Date();
	
	System.out.println(System.currentTimeMillis());
	System.out.println(date.getTime());
	}
}
