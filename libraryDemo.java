package com.deloitte.main;
import java.util.*;

import com.deloitte.library.model.Books;
import com.deloitte.library.services.libimpl;
public class libraryDemo {
public static void main(String args[]) {
	Scanner sc=new Scanner(System.in);
	ArrayList<Books> list=new ArrayList<Books>();
	while(true) {
	System.out.println("option1 to add a book"+"option2 to display a book"+"option3 to exit");
	String option=sc.next();
	libimpl mainClassRoomObj=new libimpl();
	switch(option) {
	case "1":
		System.out.println("enter book name");
		String bookname=sc.next();
		System.out.println("enter book author");
		String bookauthor=sc.next();
		System.out.println("enter book price");
		String bookprice=sc.next();
	    mainClassRoomObj.addbook(bookname,bookauthor,bookprice);
	    break;
	case "2":
		for(Books liobj:list)
			System.out.println(liobj);
		break;
	case "3":
		System.exit(0);
	}	
	}
}
}
