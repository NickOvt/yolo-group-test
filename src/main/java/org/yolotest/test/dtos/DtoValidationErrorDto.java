package org.yolotest.test.dtos;

import java.util.List;

public record DtoValidationErrorDto(String message, List<DtoFieldValidationErrorDto> errors) { }
