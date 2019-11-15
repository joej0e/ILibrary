/*
package spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.entity.Book;
import spring.service.BookService;
import spring.service.LibraryService;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private LibraryService libraryService;

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public String getAllBooks(ModelMap model) {
        List<Book> books = bookService.listBooks();
        model.put("books", books);
        return "booksAll";
    }

    @GetMapping("/info/{book_title}")
    public String bookGetByTitle(@PathVariable("book_title") String title, Model model) {
        List<Book> books = bookService.findByTitle(title);
        if (books.isEmpty()) {
            model.addAttribute("message", "Book not found");
            return "index";
        }
        model.addAttribute("books", books);
        return "bookGetByTitle";
    }
}

 */

