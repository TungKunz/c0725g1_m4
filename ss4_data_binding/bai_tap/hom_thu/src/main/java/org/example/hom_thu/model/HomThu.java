package org.example.hom_thu.model;

public class HomThu {
    private String languages;
    private String size;
    private boolean filler;
    private String  signature;

    public HomThu() {
    }
    public HomThu(String languages, String size, boolean filler, String signature) {
        this.languages = languages;
        this.size = size;
        this.filler = filler;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isFiller() {
        return filler;
    }

    public void setFiller(boolean filler) {
        this.filler = filler;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}