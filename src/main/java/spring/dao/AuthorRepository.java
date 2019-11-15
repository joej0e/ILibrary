package spring.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
