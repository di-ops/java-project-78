package hexlet.code.schemas;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    private Class<T> type;
    protected final Set<Predicate<T>> validations = new HashSet<>();

    public BaseSchema(Class<T> type) {
        this.type = type;
    }

    public boolean isValid(Object value) {
        if (value != null && !type.isInstance(value))
            return false;
        return validations.stream().allMatch(check -> check.test((T)value));
    }
}
