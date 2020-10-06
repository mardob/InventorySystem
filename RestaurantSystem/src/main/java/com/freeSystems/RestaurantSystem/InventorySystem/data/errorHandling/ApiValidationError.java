package com.freeSystems.RestaurantSystem.InventorySystem.data.errorHandling;

import java.util.Objects;

abstract class ApiSubError {

}


public class ApiValidationError extends ApiSubError{

    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ApiValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApiValidationError)) return false;
        ApiValidationError that = (ApiValidationError) o;
        return Objects.equals(getObject(), that.getObject()) &&
                getField().equals(that.getField()) &&
                Objects.equals(getRejectedValue(), that.getRejectedValue()) &&
                getMessage().equals(that.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getObject(), getField(), getRejectedValue(), getMessage());
    }
}
