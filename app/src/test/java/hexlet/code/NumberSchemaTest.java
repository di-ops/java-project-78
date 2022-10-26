package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberSchemaTest {

    @Test
    public void testNumberSchema(){

        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertTrue(schema.isValid(10));
        assertTrue(schema.isValid(null));

        assertTrue(schema.positive().isValid(10));

        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid("5"));
        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));
        assertTrue(schema.isValid(10));

        schema.range(5, 10);
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));

    }

}