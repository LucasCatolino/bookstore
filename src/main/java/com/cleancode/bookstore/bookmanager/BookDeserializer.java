package com.cleancode.bookstore.bookmanager;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class BookDeserializer extends StdDeserializer<Book> {

    private final ObjectMapper mapper;

    public BookDeserializer() {
        this(null);
    }

    public BookDeserializer(Class<?> vc) {
        super(vc);
        this.mapper = new ObjectMapper();
    }

    @Override
    public Book deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        JsonNode node = mapper.readTree(jp);

        // Extract necessary information from the JSON node
        String type = node.get("type").asText();
        String title = node.get("title").asText();
        String author = node.get("author").asText();
        int year = node.get("year").asInt();

        // Create a Book instance based on the type
        switch (type.toLowerCase()) {
            case "novel":
                return new Novel(title, author, year);
            case "technical":
                return new TechnicalBook(title, author, year);
            default:
                throw new IllegalArgumentException("Invalid book type: " + type);
        }
    }
}
