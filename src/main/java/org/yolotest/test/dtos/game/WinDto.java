package org.yolotest.test.dtos.game;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record WinDto(@NotNull(message = "WinScore cannot be empty") @Positive(message = "WinScore has to be positive") BigDecimal winScore, @NotNull(message = "IsWin cannot be empty") Boolean isWin) {
}
