package com.EX;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class SampleTest {

	public static void main(String[] args) {

		// // 1D table WithOut Header
		// System.out.println("1D table WithOut Header");
		// List<String> l = new ArrayList<String>();
		//
		// l.add("mark1=10");
		// l.add("mark2=20");
		// l.add("mark3=30");
		//
		// System.out.println(l.get(0));
		//
		// // 1D Table With Header
		// System.out.println("1D Table With Header");
		// Map<String, String> m = new LinkedHashMap<String, String>();
		//
		// m.put("Student1", "mark1=10");
		// m.put("Student2", "mark2=20");
		// m.put("Student3", "mark3=30");
		// System.out.println(m.get("Student2"));
		// System.out.println("2D Table Without Header");
		// // 2D Table Without Header
		// List<List<String>> li = new LinkedList<>();

		List<String> l1 = new LinkedList<>();

		l1.add("mark1=10");
		l1.add("mark2=20");
		l1.add("mark3=30");

		ListIterator<String> iterator = l1.listIterator();

		while (iterator.hasPrevious()) {

			System.out.println(iterator.previous());

		}
		
		// List<String> l2 = new LinkedList<String>();
		//
		// l2.add("mark1=40");
		// l2.add("mark2=50");
		// l2.add("mark3=60");
		//
		// li.add(l1);
		// li.add(l2);
		// List<String> list = li.get(0);
		// String string = list.get(1);
		// System.out.println(string);
		//
		// System.out.println("2D Table With Header");
		// // 2D Table With Header
		//
		// List<Map<String, String>> lis = new ArrayList<>();
		//
		// Map<String, String> m1 = new HashMap<String, String>();
		//
		// m1.put("Student1", "mark1=10");
		// m1.put("Student2", "mark2=20");
		// m1.put("Student3", "mark3=30");
		//
		// Map<String, String> m2 = new HashMap<>();
		// m2.put("Student1", "mark1=40");
		// m2.put("Student2", "mark2=50");
		// m2.put("Student3", "mark3=60");
		//
		// lis.add(m1);
		// lis.add(m2);
		//
		// Map<String, String> map = lis.get(1);
		// String string2 = map.get("Student1");
		// System.out.println(string2);

	}

}
