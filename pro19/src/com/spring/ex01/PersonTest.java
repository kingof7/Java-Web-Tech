package com.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

//ctrl+shift+o --> 자동 import
public class PersonTest {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml")); // xml읽어서 bean 생성
		PersonService person = (PersonService) factory.getBean("personService"); //id가 personService인 빈을 가져옴
		// PersonService person = new PersonService();  더이상 자바 코드에서 객체를 직접 생성하지 않아도 됨
		person.sayHello();

	}

}
