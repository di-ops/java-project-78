package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringSchemaTest {

    private StringSchema schema;

    @BeforeEach
    public void init() {
        Validator v = new Validator();
        schema = v.string();
    }

    @Test
    public void isValidEmptyAndNull() {
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
    }

    @Test
    public void isInvalidEmptyAndNullWhenRequired() {
        schema.required();
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void isValidNotEmptyWhenRequired() {
        assertTrue(schema.isValid("Съешь еще этих мягких французских булок"));
    }

    @Test
    public void isValidMinLength() {
        schema.minLength(10);
        assertTrue(schema.isValid("Съешь еще этих мягких французских булок"));
    }

    @Test
    public void isInvalidMinLength() {
        schema.minLength(100);
        assertFalse(schema.isValid("Съешь еще этих мягких французских булок"));
    }

    @Test
    public void isValidContains() {
        schema.contains("Съешь");
        assertTrue(schema.isValid("Съешь еще этих мягких французских булок"));
    }

    @Test
    public void isInvalidContains() {
        schema.contains("Не ешь");
        assertFalse(schema.isValid("Съешь еще этих мягких французских булок"));
    }

    @Test
    public void isValidAllChecks() {
        schema.contains("мягк").minLength(20).required();
        assertTrue(schema.isValid("Съешь еще этих мягких французских булок"));
    }

}