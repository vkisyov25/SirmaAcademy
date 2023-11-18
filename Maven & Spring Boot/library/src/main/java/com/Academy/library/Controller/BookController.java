package com.Academy.library.Controller;

import com.Academy.library.Model.Book;
import com.Academy.library.Service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping("/addBook")
    public void addBook (@RequestBody Book book){
        bookService.addBook(book);
    }
    @GetMapping("/allBooks")
    public List<Book> getAllBook(){
        return  bookService.getAllBook();
    }

    @GetMapping("/year/{year}")
    public List<Book> getBookByYear(@PathVariable int year){
        return  bookService.getAllBookByYear(year);
    }


}
