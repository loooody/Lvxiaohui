package org.lv;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

public class TestIterator {
	@Test
	//ʹ����ǿforѭ��ʵ������ı���
	public void testFor1() {
		System.out.println();
		String[] str = new String[] {"AA","BB","CC"};
		for(String i : str)
			System.out.println(i);
	}
	
	//ʹ����ǿforѭ����ʵ�ּ��ϵı���
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
		
		System.out.println("��ǿforѭ����");
		Iterator i = coll.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
