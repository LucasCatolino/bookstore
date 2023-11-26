package com.cleancode.bookstore.ordermanager;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class OrderDeserializer extends StdDeserializer<Order> {

    private final ObjectMapper mapper;

    public OrderDeserializer() {
        this(null);
    }

    public OrderDeserializer(Class<?> vc) {
        super(vc);
        this.mapper = new ObjectMapper();
    }

    @Override
    public Order deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        JsonNode node = mapper.readTree(jp);

        // Extract necessary information from the JSON node
        String type = node.get("type").asText();
        String customerName = node.get("name").asText();
        String address = node.get("address").asText();
        int quantity = node.get("quantity").asInt();

        // Create a Customer instance based on the type
        switch (type.toLowerCase()) {
            case "regular":
                return new RegularOrder(customerName, address, quantity);
            case "bulk":
                return new BulkOrder(customerName, address, quantity);
            default:
                throw new IllegalArgumentException("Invalid order type: " + type);
        }
    }
}
