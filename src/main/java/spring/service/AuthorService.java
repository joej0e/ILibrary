package spring.service;


import spring.entity.Author;

import java.util.List;

public interface AuthorService {
    Author add(Author author);

    List<Author> listAuthors();
}

