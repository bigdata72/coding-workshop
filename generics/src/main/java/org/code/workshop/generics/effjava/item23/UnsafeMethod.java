package org.code.workshop.generics.effjava.item23;

import java.util.ArrayList;
import java.util.List;

public class UnsafeMethod {
	public static void main (String[] args) {
		List<String> strList = new ArrayList<>();
		//unsafeAdd(strList, new Integer(10));
		System.out.println(strList.get(0));
		System.out.println("unreachable code");
	}
	
	public static void unsafeAdd (List<Object> list, Object obj){
		list.add(obj);
	}
}
