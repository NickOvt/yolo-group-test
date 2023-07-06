package org.yolotest.test.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record GameRequestDto(
        @NotNull @Min(value = 1, message = "Number cannot be less than 1") @Max(value = 100, message = "Number cannot be bigger than 100") int number,
        @NotNull @Positive BigDecimal bet) { }
