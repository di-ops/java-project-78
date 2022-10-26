package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        super(String.class);
    }

    public StringSchema contains(CharSequence s) {
        validations.add(val -> val.contains(s));
        return this;
    }

    public StringSchema required() {
        validations.add(val -> val != null && !val.isEmpty());
        return this;
    }

    public StringSchema minLength(int len) {
        validations.add(val -> val.length() >= len);
        return this;
    }
}
