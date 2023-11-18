package com.Academy.library.Service;

import com.Academy.library.Model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    List<Book> bookList;

    public BookService(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> addBook(Book book){
        this.bookList.add(book);
        return this.bookList;
    }
    public List<Book> getAllBook(){
        return this.bookList;
    }

    public List<Book> getAllBookByYear(int year){
        return bookList.stream().filter(b->b.getPublicationYear()==year).collect(Collectors.toList());
    }
}
