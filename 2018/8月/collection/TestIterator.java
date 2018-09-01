package org.lv;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

public class TestIterator {
	@Test
	//使用增强for循环实现数组的遍历
	public void testFor1() {
		System.out.println();
		String[] str = new String[] {"AA","BB","CC"};
		for(String i : str)
			System.out.println(i);
	}
	
	//使用增强for循环来实现集合的遍历
	@Test
	public void testFor() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("aA");
		coll.add(new Date());
		coll.add("bb");
		
		for(Object i : coll)
			System.out.println(i);
	}
	
	@Test
	public void Test1() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("aA");
		coll.add(new Date());
		coll.add("bb");
		
		System.out.println("增强for循环：");
		Iterator i = coll.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
