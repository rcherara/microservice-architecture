package ca.rcherara.services.vehicle.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestException extends RuntimeException {
    private String message;
    private Object[] args;
}