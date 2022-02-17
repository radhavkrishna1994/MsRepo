package com.training.classes.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.training.classes.Book;

@Repository
public class BookData {

	private List<Book> books;

	public BookData()
	{
		books = new ArrayList<>();
		books.add(new Book("1234", "C", 150.26, 100));
		books.add(new Book("3456", "CPlus", 250.26, 100));
	}

	public Book getBook(String isbn)
	{
		for(Book book:books)
		{
			if(book.getIsbn().equalsIgnoreCase(isbn))
				return book;
		}
		return null;
	}

	public Book addBook(Book newBook)
	{
		for(Book book:books)
		{
			if(book.getIsbn().equalsIgnoreCase(newBook.getIsbn()))
				return null;
		}
		books.add(newBook);return newBook;
	}

	public Book deleteBook(String isbn)
	{
		for(Book book:books)
		{
			if(book.getIsbn().equalsIgnoreCase(isbn))
			{
				books.remove(book); return book;
			}
		}
		return null;
	}
	
	public List<Book> getAllBooks()
	{
		return books;
	}

}


