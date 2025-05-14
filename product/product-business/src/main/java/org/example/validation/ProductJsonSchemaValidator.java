package org.example.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.ValidationException;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Component
public class ProductJsonSchemaValidator {
    public void validate(Map<String, Object> data, String productType) {
        String schemaPath = "/schemas/" + productType.toLowerCase() + ".schema.json";
        try (InputStream schemaStream = getClass().getResourceAsStream(schemaPath)) {

            assert schemaStream != null;
            JSONObject rawSchema = new JSONObject((new JSONTokener(schemaStream)));
            Schema schema = SchemaLoader.load(rawSchema);
            String jsonData = new ObjectMapper().writeValueAsString(data);
            schema.validate(new JSONObject(jsonData));

        } catch (ValidationException e) {
            throw new IllegalArgumentException("Schema validation failed: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new RuntimeException("Schema load failed: " + e.getMessage(), e);
        }
    }
}
