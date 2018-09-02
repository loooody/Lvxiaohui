package org.lv;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestList {
	@Test
	public void testList2() {
		List list = new ArrayList();
		list.add(123);
		list.add(456);
		list.add(new String("AA"));
		list.add(new String("BB"));
		list.add(456);
		
		System.out.println(list.indexOf(456));
		System.out.println(list.lastIndexOf(456));
		
		List list1 = list.subList(0, 3);
		System.out.println(list1);
	}

	/**
	 * List���÷���������add��Object obj����ɾ��remove�� �ģ�set�����飨get������
	 */
	@Test
	//ArrayList��List����Ҫʵ����
	public void testList() {
		List list = new ArrayList();
		list.add(123);
		list.add(456);
		list.add(new String("AA"));
		list.add(new String("BB"));
		System.out.println(list);
		
		list.add(0,555);
		System.out.println(list);
		Object obj = list.get(1);
		System.out.println(obj);
		list.remove(0);
		System.out.println(list.get(0));
		
	}
}
