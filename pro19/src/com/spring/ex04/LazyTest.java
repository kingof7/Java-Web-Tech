package com.spring.ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class LazyTest {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("lazy.xml");
		System.out.println("SecondBean 얻기");
		context.getBean("secondBean"); // 호출해야 그제서야 메모리에 bean객체가 생성되서 올라감
	}

}
