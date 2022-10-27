package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Number> {

    public NumberSchema() {
        super(Number.class);
    }

    public NumberSchema range(Number startRange, Number endRange) {
        validations.add(val -> val == null
                || ((val.doubleValue() >= startRange.doubleValue())
                && (val.doubleValue() <= endRange.doubleValue()))
        );
        return this;
    }

    public NumberSchema required() {
        validations.add(Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        validations.add(val -> val == null || val.doubleValue() > 0);
        return this;
    }
}
