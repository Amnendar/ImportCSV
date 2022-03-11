package it.be.importcsv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;

import it.be.importcsv.model.Autore;
import it.be.importcsv.model.Book;
import it.be.importcsv.model.CasaEditrice;
import it.be.importcsv.model.Genere;
import it.be.importcsv.repository.AutoreRepository;
import it.be.importcsv.repository.BookRepository;
import it.be.importcsv.repository.CasaEditriceRepository;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	BookRepository bookrepo;
	
	@Autowired
	CasaEditriceRepository casarepo;
	
	@Autowired
	AutoreRepository autorepo;

	@Override
	public void run(String... args) throws Exception {
		initCasaEditore();
		initAutore();
		initBook();
	}
	
	private void initCasaEditore() throws FileNotFoundException, IOException {
		try (CSVReader csvReader = new CSVReader(new FileReader("casaeditore.csv"));) {
		    String[] values = null;
		    csvReader.readNext();//nel csv abbiamo l intestazione, questo serve a saltare una riga
		    while ((values = csvReader.readNext()) != null) {
		    	casarepo.save(new CasaEditrice(values[0], values[1]));
		    }
		}
	}
	
	private void initBook() throws FileNotFoundException, IOException {
		try (CSVReader csvReader = new CSVReader(new FileReader("book.csv"));) {
		    String[] values = null;
		    csvReader.readNext();//nel csv abbiamo l intestazione, questo serve a saltare una riga
		    while ((values = csvReader.readNext()) != null) {
		    	bookrepo.save(new Book(values[0], values[1], values[2]));
		    }
		}
	}
	
	private void initAutore() throws FileNotFoundException, IOException {
		try (CSVReader csvReader = new CSVReader(new FileReader("autore.csv"));) {
		    String[] values = null;
		    csvReader.readNext();//nel csv abbiamo l intestazione, questo serve a saltare una riga
		    while ((values = csvReader.readNext()) != null) {
		    	autorepo.save(new Autore(values[0], values[1]));
		    }
		}
	}
	
//	@Override
//	public void run(String... args) throws Exception {
//		//List<List<String>> records = new ArrayList<List<String>>();
//		try (CSVReader csvReader = new CSVReader(new FileReader("book.csv"));) {
//		    String[] values = null;
//		    csvReader.readNext();//nel csv abbiamo l intestazione, questo serve a saltare una riga
//		    while ((values = csvReader.readNext()) != null) {
//		       // records.add(Arrays.asList(values));
//		    	bookrepo.save(new Book(values[0], values[1]));
//		    }
//		}
//		System.out.println("TEST");
//		//prova
//	}
	
	

}
