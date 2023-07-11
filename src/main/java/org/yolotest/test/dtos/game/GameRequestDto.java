package org.yolotest.test.dtos.game;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameRequestDto {
    @NotNull(message = "Number has to be specified") @Min(value = 1, message = "Number cannot be less than 1") @Max(value = 100, message = "Number cannot be bigger than 100") private Integer number;
    @NotNull(message = "Bet has to be specified") @Positive(message = "Bet has to be a positive number") private BigDecimal bet;

}