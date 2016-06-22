package com.qcloud.project.macaovehicle.web.controller.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		List<Integer> list2 = new ArrayList<Integer>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list2.add(1);
		list2.add(2);
		list2.add(3);
		Iterator<String> i = list.iterator();
		Iterator<Integer> it = list2.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		// for(String s : list) {
		// System.out.println("==========" + s);
		// }
	}
}
