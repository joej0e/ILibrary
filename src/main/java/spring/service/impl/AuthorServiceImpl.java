package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.AuthorDao;
import spring.entity.Author;
import spring.service.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Transactional
    @Override
    public Author add(Author author) {
        return authorDao.add(author);
    }

    @Transactional
    @Override
    public List<Author> listAuthors() {
        return authorDao.listAuthors();
    }

}

