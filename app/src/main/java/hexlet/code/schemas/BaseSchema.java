package hexlet.code.schemas;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    private final Class<T> type;
    protected final Set<Predicate<T>> validations = new HashSet<>();

    public BaseSchema(Class<T> tClass) {
        this.type = tClass;
    }

    public final boolean isValid(Object value) {
        if (value != null && !type.isInstance(value)) {
            return false;
        }
        return validations.stream().allMatch(check -> check.test((T) value));
    }
}
