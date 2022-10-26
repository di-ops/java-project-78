package hexlet.code.schemas;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class StringSchema {

    private final Set<Predicate<String>> validations = new HashSet<>();

    public boolean isValid(String s) {
        return validations.stream().allMatch(check -> check.test(s));
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
