package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema<Map> {

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

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        validations.add(val -> schemas.keySet().stream()
                .allMatch(key -> schemas.get(key).isValid(val.get(key))));
        return this;
    }

}
