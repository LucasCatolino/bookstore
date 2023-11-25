package com.cleancode.bookstore;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class SimpleController {

    private final DatabaseConnector databaseConnector;
    private final BookRepository bookRepository;

    @Autowired
    public SimpleController(DatabaseConnector databaseConnector, BookRepository bookRepository) {
        this.databaseConnector = databaseConnector;
        this.bookRepository = bookRepository;
    }
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello world :D";
    }
/*
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
*/
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book bookRequest) {
        // You can set additional properties or perform validation before saving
        Book newBook;
        switch (bookRequest.getType().toLowerCase()) {
            case "novel":
                newBook = new Novel(bookRequest.getTitle(), bookRequest.getAuthor(), bookRequest.getYear());
                break;
            /*case "technical":
                newBook = new TechnicalBook(bookRequest.getTitle(), bookRequest.getAuthor(), bookRequest.getYear());
                break;*/
            default:
                throw new IllegalArgumentException("Invalid book type: " + bookRequest.getType());
        }
        /*Book newBook = Book.createBook(
            bookRequest.getType(),
            bookRequest.getTitle(),
            bookRequest.getAuthor(),
            bookRequest.getYear()
        );*/
        return bookRepository.save(newBook);
    }
/*
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookRequest) throws NotFoundException {
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
    }
*/
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
