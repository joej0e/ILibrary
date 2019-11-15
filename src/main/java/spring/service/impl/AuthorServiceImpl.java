package spring.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.AuthorRepository;
import spring.entity.Author;
import spring.service.AuthorService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    @Override
    public Author add(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    @Override
    public List<Author> listAuthors() {
        return (ArrayList) authorRepository.findAll();
    }

}

