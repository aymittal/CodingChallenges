package com.ayush.skillenza;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.TreeMap;

public class SomethingToWatch {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int n = 0; n < testCases; n++) {
			Map<Time, ArrayList> showTimes = new HashMap<>();
			int no_of_shows = sc.nextInt();
			while (no_of_shows > 0) {
				String a = sc.next();
				String b = sc.next();
				addValues(Time.valueOf(a), Time.valueOf(b), showTimes);
				no_of_shows--;
			}
			TreeMap<Time, ArrayList> sorted = new TreeMap<>();
			sorted.putAll(showTimes);
			System.out.println(sorted);
			long count = 0;
			List<Time> endTimes = new ArrayList<Time>();
			Iterator it = sorted.keySet().iterator();
			ArrayList<Time> tempList = null;
			while (it.hasNext()) {
				Time key = (Time) it.next();
				tempList = sorted.get(key);
				if (tempList != null) {
					for (Time value : tempList) {
						if (endTimes.size() == 0) {
							count = Math.abs(value.getTime() - key.getTime());
							if(value.equals("00:00:00")) {
								count  = 86400000 - key.getTime();
							}
							endTimes.add(value);
						}else {
							ListIterator<Time> ite = endTimes.listIterator();
							Time endTime = ite.next();
							if (endTime.after(key) && endTime.before(value)) {
								count += Math.abs(value.getTime() - endTime.getTime());
								ite.remove();
								if(value.equals("00:00:00")) {
									count  += 86400000 - key.getTime();
								}
								endTimes.add(value);
							}else {
								if(endTime.before(value)) {
								count += Math.abs(value.getTime() - key.getTime());
								ite.remove();
								if(value.equals("00:00:00")) {
									count  += 86400000 - key.getTime();
								}
								endTimes.add(value);}
							}
						}
					}
				}

			}
			Time ts = new Time(count);
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
			if(sdf.format(ts).equals("00:00:00"))
				System.out.println("24:00:00");
			else
				System.out.println(sdf.format(ts));
		}
	}

	private static void addValues(Time key, Time value, Map<Time, ArrayList> hashMap) {
		ArrayList tempList = null;
		if (hashMap.containsKey(key)) {
			tempList = hashMap.get(key);
			if (tempList == null)
				tempList = new ArrayList();
			tempList.add(value);
		} else {
			tempList = new ArrayList();
			tempList.add(value);
		}
		hashMap.put(key, tempList);
	}
}