package ir.coinance.controller.errors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * View Model for transferring error type with a list of field errors.
 */
public class ErrorVM implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String type;
    private final String description;

    private List<FieldErrorVM> errors;

    public ErrorVM(String type) {
        this(type, null);
    }

    public ErrorVM(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public ErrorVM(String type, String description, List<FieldErrorVM> errors) {
        this.type = type;
        this.description = description;
        this.errors = errors;
    }

    public void add(String objectName, String field, String message) {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        errors.add(new FieldErrorVM(objectName, field, message));
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public List<FieldErrorVM> getErrors() {
        return errors;
    }
}
