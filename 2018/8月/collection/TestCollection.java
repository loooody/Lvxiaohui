package org.lv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;



public class TestCollection {
	@Test
	public void testCollection3() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("aA");
		coll.add(new Date());
		coll.add("bb");
		
		Collection coll1 = new ArrayList();
		coll1.add(123);
		coll1.add("aA");
		coll1.add(45);
		
		//10.removeAll(Collection coll);
		coll.removeAll(coll1);
		System.err.println(coll);
		//11.equals(Objection o_)
		System.out.println(coll.equals(coll1));
		//12.hashCode();
		System.out.println(coll.hashCode());
		System.out.println();
		//13.������ת��Ϊ����
		Object[] obj = coll.toArray();
		for(int i = 0; i<coll.size(); i++) {
			System.out.println(obj[i]);
		}
		
		//14.itator����
		Iterator iterator = coll.iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());
	}
	@Test
	public void testCollection2() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("aA");
		coll.add(new Date());
		coll.add("bb");
		//6.contains(Object obj)
		boolean b1 = coll.contains(123);
		System.out.println();
		System.out.println(b1);
		Collection coll1 = new ArrayList();
		coll1.add(123);
		coll1.add("aA");
		coll1.add(45);
		boolean b2 = coll.containsAll(coll1);
		System.out.println("#" + b2);;
		//8�������������������е�Ԫ��
		coll.retainAll(coll1);
		System.out.println(coll);
		//9.remove(Object o);
		boolean b3 = coll.remove("BB");
		System.out.println(b2);
		
	}
	
	
	@Test
	public void testCollection1() {
		Collection coll = new ArrayList();
		//1��size()�����ؼ�����Ԫ�صĸ���
		System.out.println(coll.size());
		//2��add(Object object)
		coll.add(123);
		coll.add("aA");
		coll.add(new Date());
		coll.add("bb");
		System.out.println(coll.size());
		//3.addALL(Collection coll)
		Collection coll1 = Arrays.asList(1,2,3);
		coll.addAll(coll1);
		System.out.println(coll.size());
		//�鿴�����е�Ԫ��
		System.out.println(coll);
		//4.isEmpty()
		System.out.println(coll.isEmpty());
		//5.CLEAR()����ռ���Ԫ��
		coll.clear();
		System.out.println(coll.size());
		
	}
}
