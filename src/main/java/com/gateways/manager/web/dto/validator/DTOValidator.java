package com.gateways.manager.web.dto.validator;

import java.util.ArrayList;
import java.util.List;

public abstract class DTOValidator<T> {
    protected T dto;

    protected List<String> errors;

    public DTOValidator(T dto) {
        this.dto = dto;
        this.errors = new ArrayList<>();
    }

    public abstract void validate();

    public boolean isValid() {
        return this.errors.isEmpty();
    }

    public List<String> getErrors() {
        return this.errors;
    }
}
