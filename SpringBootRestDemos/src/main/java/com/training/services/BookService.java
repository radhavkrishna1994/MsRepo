package com.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.classes.Book;
import com.training.classes.data.BookData;
import com.training.services.interfaces.BookServiceInterface;

@Service
public class BookService implements BookServiceInterface {

	@Autowired
	private BookData bookData;
	
	@Override
	public Book getBook(String isbn) {
		
		return bookData.getBook(isbn);
	}

	@Override
	public Book addBook(Book book) {
		
		return bookData.addBook(book);
	}

	@Override
	public Book deleteBook(String isbn) {
		// TODO Auto-generated method stub
		return bookData.deleteBook(isbn);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookData.getAllBooks();
	}

}
