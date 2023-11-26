package com.cleancode.bookstore.customermanager;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class CustomerDeserializer extends StdDeserializer<Customer> {

    private final ObjectMapper mapper;

    public CustomerDeserializer() {
        this(null);
    }

    public CustomerDeserializer(Class<?> vc) {
        super(vc);
        this.mapper = new ObjectMapper();
    }

    @Override
    public Customer deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        JsonNode node = mapper.readTree(jp);

        // Extract necessary information from the JSON node
        String type = node.get("type").asText();
        String name = node.get("name").asText();
        String address = node.get("address").asText();

        // Create a Customer instance based on the type
        switch (type.toLowerCase()) {
            case "minor":
                return new MinorCustomer(name, address);
            case "major":
                return new MajorCustomer(name, address);
            default:
                throw new IllegalArgumentException("Invalid customer type: " + type);
        }
    }
}
