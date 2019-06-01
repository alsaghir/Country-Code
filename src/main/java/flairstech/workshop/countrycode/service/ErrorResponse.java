package flairstech.workshop.countrycode.service;

public class ErrorResponse implements GenericResponse{
    private String errorMessage;

    ErrorResponse(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
