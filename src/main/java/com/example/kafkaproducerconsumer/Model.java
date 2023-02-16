package com.example.kafkaproducerconsumer;

public class Model {

    private String primaryField;
    private String secondaryField;

    public Model(String primaryField, String secondaryField) {
        this.primaryField = primaryField;
        this.secondaryField = secondaryField;
    }

    public Model() {
    }

    public String getPrimaryField() {
        return primaryField;
    }

    public void setPrimaryField(String primaryField) {
        this.primaryField = primaryField;
    }

    public String getSecondaryField() {
        return secondaryField;
    }

    public void setSecondaryField(String secondaryField) {
        this.secondaryField = secondaryField;
    }
}
