package com.basonur.Soru1PersonelTakipSistemi;

public class PersonelTakipException extends RuntimeException {

    private final ErrorType errorType;

    public PersonelTakipException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public PersonelTakipException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }
}
