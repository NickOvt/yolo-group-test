package org.yolotest.test.validations;

import jakarta.validation.*;
import org.junit.jupiter.api.Test;
import org.yolotest.test.dtos.game.GameRequestDto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class GameRequestDtoValidationTest {
    @Test
    void testValidGameRequestDtoValidationNoErrors() {
        GameRequestDto gameRequestDto = new GameRequestDto(10, BigDecimal.TEN);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        final Validator validator = factory.getValidator();

        Set<ConstraintViolation<GameRequestDto>> constraintViolations =
                validator.validate(gameRequestDto);

        assertThat(constraintViolations).isEmpty();
    }

    @Test
    void testInvalidGameRequestDtoBothFieldsInvalid() {
        GameRequestDto gameRequestDto = new GameRequestDto(null,null);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        final Validator validator = factory.getValidator();

        Set<ConstraintViolation<GameRequestDto>> constraintViolations =
                validator.validate(gameRequestDto);

        assertThat(constraintViolations).hasSize(2);
//        assertThat(constraintViolations.stream().toList().get(0).getMessage()).isEqualTo("Number has to be specified");
//        assertThat(constraintViolations.stream().toList().get(1).getMessage()).isEqualTo("Bet has to be specified");
    }

    @Test
    void testInvalidGameRequestDtoNumberIsInvalid() {
        GameRequestDto gameRequestDto = new GameRequestDto(null,BigDecimal.TEN);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        final Validator validator = factory.getValidator();

        Set<ConstraintViolation<GameRequestDto>> constraintViolations =
                validator.validate(gameRequestDto);

        assertThat(constraintViolations).hasSize(1);
        assertThat(constraintViolations.stream().toList().get(0).getMessage()).isEqualTo("Number has to be specified");
    }

    @Test
    void testInvalidGameRequestDtoBetIsInvalid() {
        GameRequestDto gameRequestDto = new GameRequestDto(10,null);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        final Validator validator = factory.getValidator();

        Set<ConstraintViolation<GameRequestDto>> constraintViolations =
                validator.validate(gameRequestDto);

        assertThat(constraintViolations).hasSize(1);
        assertThat(constraintViolations.stream().toList().get(0).getMessage()).isEqualTo("Bet has to be specified");
    }
}
