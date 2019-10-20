package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.AppConfig;
import spring.entity.Author;
import spring.entity.Book;
import spring.entity.User;
import spring.service.AuthorService;
import spring.service.BookService;
import spring.service.LibraryService;
import spring.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        BookService bookService = context.getBean(BookService.class);
        AuthorService authorService = context.getBean(AuthorService.class);
        LibraryService libraryService = context.getBean(LibraryService.class);

        User john = userService.add(new User("John", "Smith"));
        User lyly = userService.add(new User("Lyly", "Allen"));
        User kevin = userService.add(new User("Kevin", "Right"));
        User paul = userService.add(new User("Paul", "Pitt"));

        userService.listUsers();

        Author jerome_salinger = authorService.add(new Author(
                "Jerome David", "Salinger"));
        Author ray_bradbury = authorService.add(new Author(
                "Ray", "Bradbury"));
        Author chuck_palahniuk = authorService.add(new Author(
                "Chuck", " Palahniuk"));

        authorService.listAuthors();

        Book catcher_in_the_rye = bookService.add(new Book(
                "The Catcher in the Rye", 1951, 30., 12));
        Book dandelion_wine = bookService.add(new Book(
                "Dandelion Wine", 1957, 45., 45));
        Book fahrenheit_451 = bookService.add(new Book(
                "Fahrenheit 451", 1953, 60., 52));
        Book fight_club = bookService.add(new Book(
                "Fight Club", 1996, 37., 10));

        bookService.listBooks();

        libraryService.setBookAuthor(catcher_in_the_rye, jerome_salinger);
        libraryService.setBookAuthor(dandelion_wine, ray_bradbury);
        libraryService.setBookAuthor(fahrenheit_451, ray_bradbury);
        libraryService.setBookAuthor(fight_club, chuck_palahniuk);

        libraryService.rentBook(lyly, catcher_in_the_rye);
        libraryService.rentBook(john, fahrenheit_451);
        libraryService.rentBook(kevin, fahrenheit_451);

        libraryService.returnBook(lyly, catcher_in_the_rye);
        libraryService.returnBook(john, fahrenheit_451);
        libraryService.returnBook(kevin, fahrenheit_451);

        libraryService.getBooksRentByUser(lyly);

        List<Book> books = libraryService.findBooksByAuthor("Jerome David", "Salinger");

        List<Book> books1 = libraryService.findBooksByAuthor("Bradbury");

        context.close();
    }
}

