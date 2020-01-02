package com.deloitte.library.services;

import java.util.ArrayList;

import com.deloitte.library.model.Books;

public interface libraryInterface {
public void addbook(String bookname,String bookauthor,String bookprice);
public ArrayList<Books> displaybook(ArrayList<Books> list);
}
