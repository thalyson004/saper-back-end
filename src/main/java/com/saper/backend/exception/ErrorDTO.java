package com.saper.backend.exception;

import java.io.Serializable;
import java.util.List;

public class ErrorDTO {
    String field;
    String error;

    public ErrorDTO(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
