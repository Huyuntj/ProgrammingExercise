package com.javatpoint;

public class Bike {
int speedlimit = 90;
public static void main(String[] args){
	Bike bike = new SubBike();
	SubBike subBike = new SubBike();
	System.out.println(bike.speedlimit);
	System.out.println(subBike.speedlimit);
}
}

class SubBike extends Bike{
	int speedlimit = 120;
	
}


