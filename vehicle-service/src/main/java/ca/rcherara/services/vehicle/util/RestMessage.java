package ca.rcherara.services.vehicle.util;

import lombok.Getter;

import java.util.List;

@Getter
public class RestMessage {
    private String message;
    private List<String> messages;

    public RestMessage(List<String> messages) {
        this.messages = messages;
    }

    public RestMessage(String message) {
        this.message = message;
    }
}