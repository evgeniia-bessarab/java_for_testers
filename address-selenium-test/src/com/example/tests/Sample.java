package com.example.tests;

public class Sample {
	public static void main(String[] args) {
		String a = new String("test");
		String a2 = new String("test");
		String b = a;
		System.out.println(a == b);
		System.out.println(a.equals(b));
		System.out.println(a == a2);
		System.out.println(a.equals(a2));
		//содержит
		System.out.println(b.contains(a));
		//индекс элемента
		a="test";
		b="testtest";
		System.out.println(b.indexOf(a));
		a="ttest";
		b="testtest";
		System.out.println(b.indexOf(a));
		a="ttttttest";
		b="testtest";
		System.out.println(b.indexOf(a));
		//разделить
		b="test test test";
		String[] list = b.split(" ");
		System.out.println(list.length);
		System.out.println(list[0]);
		System.out.println(list[1]);
		System.out.println(list[2]);
		
		b="test     test test";
		list = b.split("\\s+");
		
		System.out.println(list.length);
		System.out.println(list[0]);
		System.out.println(list[1]);
		System.out.println(list[2]);
		
		
		b = "+7 (916) 123-45-67";
		System.out.println(b.matches("\\+\\d+\\s*\\(\\d+\\)\\s*[\\d\\-]+"));
		
		b = b.replaceAll("[ ()\\-]", "");
		System.out.println(b);
		System.out.println(b.matches("\\+\\d+"));
		
		b = "    +7 (916)               123-45-67    ";
		b = b.trim();
		System.out.println(b);		
		
		
		b="testlklklkl-476655464 testlklklkl-1136386185:\rH: testlklklkl12485391\rBirthday: 10. February 1952";
		list = b.split("\\r+");
		
		System.out.println(list.length);
		System.out.println(list[0]);
		System.out.println(list[1]);
		System.out.println(list[2]);
		
	}

}
