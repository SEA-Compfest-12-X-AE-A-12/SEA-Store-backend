package com.compfest.sea.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class APIException {
    private final String message;
    private final String status;
    private final int code;
}
