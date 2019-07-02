package com.ayush.skillenza;

import java.util.Scanner;

public class VenotoiseCatch {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no_of_catchers = sc.nextInt();
		int location_of_venotoise = sc.nextInt();
		int distance_from_venotoise[] = new int[no_of_catchers];
		int speed_of_catchers[] = new int[no_of_catchers];
		int time_to_catch[] = new int[no_of_catchers];
		int fastestTime = Integer.MAX_VALUE, count = 0, catcher = 0;
		for(int i = 0; i < no_of_catchers; i++) {
			distance_from_venotoise[i] = Math.abs(sc.nextInt() - location_of_venotoise);
		}
		for(int i = 0; i < no_of_catchers; i++) {
			speed_of_catchers[i] = sc.nextInt();
		}
		for(int i = 0; i < no_of_catchers; i++) {
			time_to_catch[i] = distance_from_venotoise[i] / speed_of_catchers[i];
			if(fastestTime >= time_to_catch[i]) {
				fastestTime = time_to_catch[i];
			}
		}
		for(int i = 0; i < no_of_catchers; i++) {
			if(fastestTime == time_to_catch[i]) {
				catcher = i;
				count++;
			}
		}
		if(count == 1)
			System.out.println(catcher);
		else
			System.out.println("-1");
	}
}
