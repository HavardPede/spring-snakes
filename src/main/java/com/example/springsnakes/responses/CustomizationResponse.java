package com.example.springsnakes.responses;

import com.example.springsnakes.entities.Customization;

public class CustomizationResponse extends Customization {
    private String author = "Howie";
    private String version = "1.0.0";
    private String apiVersion = "1";

    public CustomizationResponse(Customization customization) {
        super(customization.getColor(), customization.getHead(), customization.getTail());
    }

    public static CustomizationResponse main() {
        return new CustomizationResponse(Customization.main());
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }
}
