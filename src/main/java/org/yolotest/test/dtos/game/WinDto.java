package org.yolotest.test.dtos.game;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WinDto {
    @NotNull(message = "WinScore cannot be empty") @Positive(message = "WinScore has to be positive") private final BigDecimal winScore;
    @NotNull(message = "IsWin cannot be empty") private final Boolean isWin;
}
