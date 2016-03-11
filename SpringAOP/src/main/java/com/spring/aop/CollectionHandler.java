package com.spring.aop;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CollectionHandler {

	public void addElementsInArrayList() {
		System.out.println("Inside addElementsInArrayList()");
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<1000;i++) {
			list.add(i);
		}
		throw new ArithmeticException();
	}
	public void addElementsInVector() {
		System.out.println("Inside addElementsInVector()");
		List<Integer> list = new Vector<Integer>();
		for(int i=0;i<1000;i++) {
			list.add(i);
		}
	}
}
