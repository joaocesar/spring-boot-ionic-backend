package com.nelioalves.cursomc.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class BeanValidationError extends StandardError {

    private static final long serialVersionUID = 1L;

    List<FieldMessage> fieldMessages = new ArrayList<>();

    public BeanValidationError(Long timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public List<FieldMessage> getFieldMessages() {
        return fieldMessages;
    }

    public void addError(String fieldName, String message) {
        fieldMessages.add(new FieldMessage(fieldName, message));
    }
}
