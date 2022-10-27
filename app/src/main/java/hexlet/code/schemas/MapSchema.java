package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema<Map> {

    public MapSchema() {
        super(Map.class);
    }

    public MapSchema required() {
        validations.add(Objects::nonNull);
        return this;
    }

    public MapSchema sizeOf(int n) {
        validations.add(val -> val.size() == n);
        return this;
    }
}
