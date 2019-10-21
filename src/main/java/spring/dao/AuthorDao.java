package spring.dao;

import spring.entity.Author;

import java.util.List;

public interface AuthorDao {

    Author add(Author author);

    List<Author> listAuthors();

}
