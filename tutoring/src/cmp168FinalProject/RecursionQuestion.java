package cmp168FinalProject;

import java.util.Arrays;
import java.util.Scanner;

public class RecursionQuestion {
	
	public static void main(String[]args) {
		excute();

	}

	private static void excute() {

		Car [] cars = new Car[10];
		int [][] seatConfigurations = {new int[]{2,2}, new int[]{2,3},
				new int[]{2,2,3}, new int[]{2,3,3}, new int[]{2,3,4}, new int[]{2,4,3},
				new int[]{2,3,5}, new int[]{2,4,4}, new int[]{2,4,5}, new int[]{3,4,5}};
		for(int i=0; i<cars.length; i++){
			cars[i] = new Car(2, 4, seatConfigurations[i]);
		}
		Scanner kb = new Scanner(System.in);
// 		System.out.print("enter seat info");
		String [] input = kb.nextLine().split(" ");
		int [] rowSeats = new int[input.length];
		for(int i=0; i<input.length; i++){
			rowSeats[i] = Integer.parseInt(input[i]);
		}




	}

	public static int binarySearch(Car[] cars, Car c) {
		
		Arrays.sort(cars);
		
		System.out.print("Looking for Car: " + c.toString());
		int s=0;
		int e= cars.length-1;
		
		if(s<=e) {
			int mid= (s+e)/2;
			
			if(c.equals(cars[mid])) {
				return mid;
			}
			else if(c.compareTo(cars[mid])< 0) {//left
				return betterBS(cars, c, s, mid-1);
			}
			else if(c.compareTo(cars[mid])>0) {
				return betterBS(cars, c, mid+1, e);
			}
		}
		return -1;
	}
	
	private static int betterBS(Car[] cars, Car c, int s, int e) {
		if(s<=e) {
			int mid= (s+e)/2;
			System.out.println("s=" + s + ", e=" + e + ", mid=" + mid);
			
			if(c.equals(cars[mid])) {
				return mid;
			}
			else if(c.compareTo(cars[mid])< 0) {//left
				System.out.println("go left");
				return betterBS(cars, c, s, mid-1);
			}
			else if(c.compareTo(cars[mid])>0) {
				System.out.println("go right");
				return betterBS(cars, c, mid+1, e);
			}
		}
		return -1;
	}
}
