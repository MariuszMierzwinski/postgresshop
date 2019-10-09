package com.example.demo.exceptions;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EmailExistsException extends Throwable {
    public EmailExistsException(@NotNull @NotEmpty String s) {
    }
}
