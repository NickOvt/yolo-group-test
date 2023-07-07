package org.yolotest.test.dtos;

import lombok.Data;

import java.util.List;

public record DtoValidationErrorMessage(String message, List<DtoFieldValidationError> errors) { }
