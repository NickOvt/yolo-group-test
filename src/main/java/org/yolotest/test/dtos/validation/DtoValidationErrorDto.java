package org.yolotest.test.dtos.validation;

import java.util.List;

public record DtoValidationErrorDto(String message, List<DtoFieldValidationErrorDto> errors) { }
