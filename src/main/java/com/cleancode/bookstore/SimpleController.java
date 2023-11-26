package com.cleancode.bookstore;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/books")
public class SimpleController {

    private final DatabaseConnector databaseConnector;
    private final BookRepository bookRepository;
    //private final EntityManager entityManager;

    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger LOGGER = Logger.getLogger(SimpleController.class.getName());

    @Autowired
    public SimpleController(DatabaseConnector databaseConnector, BookRepository bookRepository/*, EntityManager entityManager*/) {
        this.databaseConnector = databaseConnector;
        this.bookRepository = bookRepository;
        //this.entityManager = entityManager;
    }
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello world :D";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id) {
        return "Mock response Book " + id;
        //return bookRepository.findById(id);
        /*
        String nativeQuery = "SELECT * FROM novel WHERE id = :id UNION ALL SELECT * FROM technical_book WHERE id = :id";
        
        NativeQuery<Book> query = (NativeQuery<Book>) entityManager.createNativeQuery(nativeQuery, Book.class);
        query.setParameter("id", id);
        
        try {
            Book book = query.getSingleResult();
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        */
    }

    @PostMapping
    public Book addBook(@RequestBody Book bookRequest) throws Error {
        try {
            Book newBook = objectMapper.readValue(objectMapper.writeValueAsString(bookRequest), Book.class);
            LOGGER.info("SE GUARDA EL LIBRO");
            return bookRepository.save(newBook);
         } catch (JsonProcessingException e) {
        // Handle exception (e.g., return an error response)
            throw new Error();
        }
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable Long id, @RequestBody Book bookRequest) {// throws NotFoundException {
        return "Book updated " + id;
        /*
        // Retrieve the existing book from the database
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();

            // Update the book's information with the new data
            existingBook.setTitle(bookRequest.getTitle());
            existingBook.setAuthor(bookRequest.getAuthor());
            existingBook.setYear(bookRequest.getYear());

            // Save the updated book to the database
            return bookRepository.save(existingBook);
        } else {
            // Handle the case where the book with the given ID is not found
            throw new NotFoundException();
        }
        */
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        //bookRepository.deleteById(id);
        return "Deleted book " + id;
    }
}
