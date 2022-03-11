package it.be.importcsv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.be.importcsv.model.Autore;

public interface AutoreRepository extends JpaRepository<Autore, Long> {

}
