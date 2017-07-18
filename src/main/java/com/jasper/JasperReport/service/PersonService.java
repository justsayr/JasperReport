package com.jasper.JasperReport.service;

import java.util.ArrayList;
import java.util.List;

import com.jasper.JasperReport.domain.Person;

public class PersonService {
	
	public static List<Person> createPersonList(){
		Person p1 = new Person(1, "Ram", 21, "Akola");
		Person p2 = new Person(2, "Shyam", 31, "Pune");
		Person p3 = new Person(3, "Abhi", 11, "Mumbai");
		Person p4 = new Person(4, "Tabhi", 27, "Kholpaur");
		
		List<Person> personList = new ArrayList<>();
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
	
		
		return personList;
		
	}
	
	public static List<Person> createIdAndPersonList(){
		Person p = new Person();
		p.setName("Ram");
		p.setPersonId(1);
		
		List<Person> pList = new ArrayList<>();
		pList.add(p);
		return pList;
	}

}
