package com.basonur.Soru1PersonelTakipSistemi;

public enum ErrorType {
    LISTE_BOS(1001, "Liste boş"),
    LISTEDE_YOK(1002, "Listede yok"),
    ZATEN_VAR(1003,"Zaten mevcut");


    private int code;
    private String message;

    private ErrorType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
