package ir.coinance.controller.errors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * View Model for transferring error message with a list of field errors.
 */
public class ErrorVM implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String message;
    private final String description;

    private List<FieldErrorVM> errors;

    public ErrorVM(String message) {
        this(message, null);
    }

    public ErrorVM(String message, String description) {
        this.message = message;
        this.description = description;
    }

    public ErrorVM(String message, String description, List<FieldErrorVM> errors) {
        this.message = message;
        this.description = description;
        this.errors = errors;
    }

    public void add(String objectName, String field, String message) {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        errors.add(new FieldErrorVM(objectName, field, message));
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public List<FieldErrorVM> getErrors() {
        return errors;
    }
}
