package com.jasper.JasperReport.domain;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	int personId; 
	String name; 
	int age; 
	String city;
	
	public Person(){
		
	}
	
	public Person(int personId, String name, int age, String city) {
		super();
		this.personId = personId;
		this.name = name;
		this.age = age;
		this.city = city;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public static List<Person> createPersonList(){
		Person p1 = new Person(1, "Ram", 21, "Akola");
	/*	Person p2 = new Person(2, "Shyam", 31, "Pune");
		Person p3 = new Person(3, "Abhi", 11, "Mumbai");
		Person p4 = new Person(4, "Tabhi", 27, "Kholpaur");*/
		
		List<Person> personList = new ArrayList<>();
		personList.add(p1);
		/*personList.add(p2);
		personList.add(p3);
		personList.add(p4);*/
		
		return personList;
		
	}
	
}
