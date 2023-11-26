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

import com.cleancode.bookstore.bookmanager.Book;
import com.cleancode.bookstore.bookmanager.BookRepository;
import com.cleancode.bookstore.customermanager.Customer;
import com.cleancode.bookstore.customermanager.CustomerRepository;
import com.cleancode.bookstore.ordermanager.Order;
import com.cleancode.bookstore.ordermanager.OrderRepository;
import com.cleancode.bookstore.reportsmanager.CustomerActivityReport;
import com.cleancode.bookstore.reportsmanager.SalesReport;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class SimpleController {

    private final DatabaseConnector databaseConnector;
    private final BookRepository bookRepository;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    //private final EntityManager entityManager;

    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger LOGGER = Logger.getLogger(SimpleController.class.getName());

    @Autowired
    public SimpleController(DatabaseConnector databaseConnector, BookRepository bookRepository,
                            CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.databaseConnector = databaseConnector;
        this.bookRepository = bookRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        //this.entityManager = entityManager;
    }

    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable Long id) {
        return "Book mock response " + id;
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

    @PostMapping("/books")
    public Book addBook(@RequestBody Book bookRequest) throws Error {
        try {
            Book newBook = objectMapper.readValue(objectMapper.writeValueAsString(bookRequest), Book.class);
            return bookRepository.save(newBook);
         } catch (JsonProcessingException e) {
            throw new Error();
        }
    }

    @PutMapping("/books/{id}")
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

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable Long id) {
        //bookRepository.deleteById(id);
        return "Book deleted " + id;
    }

    @GetMapping("/customers/{id}")
    public String getCustomeryId(@PathVariable Long id) {
        return "Customer mock response " + id;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customerRequest) throws Error {
        try {
            Customer newCustomer = objectMapper.readValue(objectMapper.writeValueAsString(customerRequest), Customer.class);
            return customerRepository.save(newCustomer);
         } catch (JsonProcessingException e) {
            throw new Error();
        }
    }

    @PutMapping("/customers/{id}")
    public String updateCustomer(@PathVariable Long id, @RequestBody Customer customerRequest) {
        return "Customer updated " + id;
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        return "Customer deleted " + id;
    }
    
    @GetMapping("/orders/{id}")
    public String getOrderId(@PathVariable Long id) {
        return "Order mock response " + id;
    }

    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order orderRequest) throws Error {
        try {
            Order newOrder = objectMapper.readValue(objectMapper.writeValueAsString(orderRequest), Order.class);
            return orderRepository.save(newOrder);
         } catch (JsonProcessingException e) {
            throw new Error();
        }
    }

    @PutMapping("/orders/{id}")
    public String updateOrder(@PathVariable Long id, @RequestBody Order orderRequest) {
        return "Order updated " + id;
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return "Order deleted " + id;
    }

    @GetMapping("/reports/sales/{data}")
    public String getSalesReport(@PathVariable String data){
        SalesReport salesReport = new SalesReport();
        return salesReport.generateReport(data);
    }

    @GetMapping("/reports/customer/{data}")
    public String getCustomerReport(@PathVariable String data){
        CustomerActivityReport customerActivityReport = new CustomerActivityReport();
        return customerActivityReport.generateReport(data);
    }
}
