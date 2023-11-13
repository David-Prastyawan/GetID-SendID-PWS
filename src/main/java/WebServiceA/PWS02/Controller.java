package WebServiceA.PWS02;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author David
 */

@RestController
@CrossOrigin
public class Controller { 
    
    private Book bookData; 

    @PostMapping(value = "/setBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> setBook(@RequestBody Book book) {
        bookData = book; // Simpan data buku di server
        return ResponseEntity.ok("Judul: " + book.getJudul() + ", Penulis: " + book.getPenulis() 
                + ", Penerbit: " + book.getPenerbit() + ", Tahun: " + book.getTahun());
    }

    @GetMapping(value = "/getBook")
    public ResponseEntity<Book> getBook() {
        if (bookData != null) {
            return ResponseEntity.ok(bookData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
