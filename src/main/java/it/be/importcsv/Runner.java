package it.be.importcsv;

import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;

import it.be.importcsv.model.Book;
import it.be.importcsv.repository.BookRepository;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	BookRepository bookrepo;
	
	@Override
	public void run(String... args) throws Exception {
		//List<List<String>> records = new ArrayList<List<String>>();
		try (CSVReader csvReader = new CSVReader(new FileReader("book.csv"));) {
		    String[] values = null;
		    csvReader.readNext();//nel csv abbiamo l intestazione, questo serve a saltare una riga
		    while ((values = csvReader.readNext()) != null) {
		       // records.add(Arrays.asList(values));
		    	bookrepo.save(new Book(values[0], values[1]));
		    }
		}
		System.out.println("TEST");
		//prova
	}

}
