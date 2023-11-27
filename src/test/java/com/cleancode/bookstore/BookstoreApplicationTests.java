package com.cleancode.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookstoreApplicationTests {
	
	private final TestRestTemplate restTemplate = new TestRestTemplate();

	private static final String URL = "http://localhost:8080/api";
	private static final String ID = "1";
	private static final String BOOKS = "/books";
	private static final String CUSTOMERS = "/customers";
	private static final String ORDERS = "/orders";

	@Test
    void testCreateNovel() {
        String url = URL + BOOKS;

        // Request body
        String requestBody = "{" +
                "\"title\": \"The-Great-Gatsby\"," +
                "\"author\": \"F. Scott Fitzgerald\"," +
                "\"year\": 1925," +
                "\"type\": \"novel\"" +
                "}";

        // Set request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Make the POST request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

		// Verify the response
        assertNotNull(response.getBody());

        // Verify that the response body contains the expected values
		assertTrue(response.getBody().contains("id"));
        assertTrue(response.getBody().contains("\"title\":\"The-Great-Gatsby\""));
        assertTrue(response.getBody().contains("\"author\":\"F. Scott Fitzgerald\""));
        assertTrue(response.getBody().contains("\"year\":1925"));
        assertTrue(response.getBody().contains("\"type\":\"NOVEL\""));
    }

	@Test
    void testCreateTechnicalBook() {
        String url = URL + BOOKS;

        // Request body
        String requestBody = "{" +
                "\"title\": \"C-Programming-Language\"," +
                "\"author\": \"Brian Kernighan\"," +
                "\"year\": 1978," +
                "\"type\": \"technical\"" +
                "}";

        // Set request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Make the POST request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

		// Verify the response
        assertNotNull(response.getBody());

        // Verify that the response body contains the expected values
		assertTrue(response.getBody().contains("id"));
        assertTrue(response.getBody().contains("\"title\":\"C-Programming-Language\""));
        assertTrue(response.getBody().contains("\"author\":\"Brian Kernighan\""));
        assertTrue(response.getBody().contains("\"year\":1978"));
        assertTrue(response.getBody().contains("\"type\":\"TECHNICAL\""));
    }

    @Test
    void testGetBookById() {
        String url = URL + BOOKS + "/" + ID;

        ResponseEntity<String> response = restTemplate.getForEntity(url , String.class);

        assertEquals("Book mock response " + ID, response.getBody());
    }

	@Test
    void testDeleteBookById() {
 		String url = URL + BOOKS + "/" + ID;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);

        assertEquals("Book deleted " + ID, response.getBody());
    }

	@Test
    void testUpdateBookById() {
        String url = URL + BOOKS + "/" + ID;

        // Request body
        String requestBody = "{" +
                "\"title\": \"C-Programming-Language\"," +
                "\"author\": \"Brian Kernighan\"," +
                "\"year\": 1978," +
                "\"type\": \"technical\"" +
                "}";

        // Set request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Make the PUT request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);

        assertEquals("Book updated " + ID, response.getBody());
    }

	@Test
    void testCreateRegularOrder() {
        String url = URL + ORDERS;

        // Request body
        String requestBody = "{" +
                "\"name\": \"Lance Armstrong\"," +
                "\"address\": \"False street 456\"," +
                "\"quantity\": 5," +
                "\"type\": \"regular\"" +
                "}";

        // Set request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Make the POST request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

		// Verify the response
        assertNotNull(response.getBody());

        // Verify that the response body contains the expected values
		assertTrue(response.getBody().contains("Lance Armstrong"));
        assertTrue(response.getBody().contains("False street 456"));
        assertTrue(response.getBody().contains("5"));
        assertTrue(response.getBody().contains("REGULAR"));
    }

	@Test
    void testCreateBulkOrder() {
        String url = URL + ORDERS;

        // Request body
        String requestBody = "{" +
                "\"name\": \"Kell\"," +
                "\"address\": \"False street 456\"," +
                "\"quantity\": 5," +
                "\"type\": \"bulk\"" +
                "}";

        // Set request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Make the POST request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

		// Verify the response
        assertNotNull(response.getBody());

        // Verify that the response body contains the expected values
		assertTrue(response.getBody().contains("id"));
        assertTrue(response.getBody().contains("Kell"));
        assertTrue(response.getBody().contains("False street 456"));
        assertTrue(response.getBody().contains("5"));
        assertTrue(response.getBody().contains("BULK"));
    }

	@Test
    void testGetOrderById() {
        String url = URL + ORDERS + "/" + ID;

        ResponseEntity<String> response = restTemplate.getForEntity(url , String.class);

        assertEquals("Order mock response " + ID, response.getBody());
    }

	@Test
    void testDeleteOrderById() {
 		String url = URL + ORDERS + "/" + ID;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);

        assertEquals("Order deleted " + ID, response.getBody());
    }

	@Test
    void testUpdateOrderById() {
        String url = URL + ORDERS + "/" + ID;

        // Request body
        String requestBody = "{" +
                "\"name\": \"Kell\"," +
                "\"address\": \"False street 456\"," +
                "\"quantity\": 10," +
                "\"type\": \"bulk\"" +
                "}";

        // Set request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Make the PUT request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);

        assertEquals("Order updated " + ID, response.getBody());
    }

	@Test
    void testCreateMinorCustomer() {
        String url = URL + CUSTOMERS;

        // Request body
        String requestBody = "{" +
                "\"name\": \"Lance Armstrong\"," +
                "\"address\": \"False street 123\"," +
                "\"type\": \"minor\"" +
                "}";

        // Set request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Make the POST request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

		// Verify the response
        assertNotNull(response.getBody());

        // Verify that the response body contains the expected values
		assertTrue(response.getBody().contains("id"));
        assertTrue(response.getBody().contains("Lance Armstrong"));
        assertTrue(response.getBody().contains("False street 123"));
        assertTrue(response.getBody().contains("MINOR"));
    }

	@Test
    void testCreateMajorCustomer() {
        String url = URL + CUSTOMERS;

        // Request body
        String requestBody = "{" +
                "\"name\": \"Kell\"," +
                "\"address\": \"False street 456\"," +
                "\"type\": \"major\"" +
                "}";

        // Set request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Make the POST request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

		// Verify the response
        assertNotNull(response.getBody());

        // Verify that the response body contains the expected values
		assertTrue(response.getBody().contains("id"));
        assertTrue(response.getBody().contains("Kell"));
        assertTrue(response.getBody().contains("False street 456"));
        assertTrue(response.getBody().contains("MAJOR"));
    }

	@Test
    void testGetCustomerById() {
        String url = URL + CUSTOMERS + "/" + ID;

        ResponseEntity<String> response = restTemplate.getForEntity(url , String.class);

        assertEquals("Customer mock response " + ID, response.getBody());
    }

	@Test
    void testDeleteCustomerById() {
 		String url = URL + CUSTOMERS + "/" + ID;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);

        assertEquals("Customer deleted " + ID, response.getBody());
    }

	@Test
    void testUpdateCustomerById() {
        String url = URL + CUSTOMERS + "/" + ID;

        // Request body
        String requestBody = "{" +
                "\"name\": \"Kell\"," +
                "\"address\": \"False street 456\"," +
                "\"type\": \"major\"" +
                "}";

        // Set request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Make the PUT request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);

        assertEquals("Customer updated " + ID, response.getBody());
    }

}
