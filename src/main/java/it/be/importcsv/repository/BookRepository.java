package it.be.importcsv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.be.importcsv.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
