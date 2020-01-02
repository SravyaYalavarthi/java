package com.deloitte.library.services;

import java.util.ArrayList;
import com.deloitte.library.dao.BooksDAO;
import com.deloitte.library.model.Books;

public class libimpl implements libraryInterface{

	@Override
	public void addbook(String bookname,String bookauthor, String bookprice) {
		// TODO Auto-generated method stub
		Books book=new Books();
		book.setBookid(Books.getCounter());
		book.setBookname(bookname);
		book.setBookauthor(bookauthor);
		book.setBookprice(Integer.parseInt(bookprice));
		BooksDAO.addbook(book);
	}

	@Override
	public ArrayList<Books> displaybook(ArrayList<Books> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
