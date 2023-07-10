package org.yolotest.test.validations;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import org.yolotest.test.dtos.game.WinDto;

import java.math.BigDecimal;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class WinDtoValidationTest {
    @Test
    void testValidWinDtoValidationNoErrors() {
        WinDto winDto = new WinDto(BigDecimal.TEN, true);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        final Validator validator = factory.getValidator();

        Set<ConstraintViolation<WinDto>> constraintViolations =
                validator.validate(winDto);

        assertThat(constraintViolations).isEmpty();
    }

    @Test
    void testInvalidWinDtoBothFieldsInvalid() {
        WinDto winDto = new WinDto(null, null);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        final Validator validator = factory.getValidator();

        Set<ConstraintViolation<WinDto>> constraintViolations =
                validator.validate(winDto);

        assertThat(constraintViolations).hasSize(2);
        assertThat(constraintViolations.stream().toList().get(0).getMessage()).isEqualTo("WinScore cannot be empty");
        assertThat(constraintViolations.stream().toList().get(1).getMessage()).isEqualTo("IsWin cannot be empty");
    }

    @Test
    void testInvalidWinDtoWinScoreNegative() {
        WinDto winDto = new WinDto(BigDecimal.valueOf(-1), false);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        final Validator validator = factory.getValidator();

        Set<ConstraintViolation<WinDto>> constraintViolations =
                validator.validate(winDto);

        assertThat(constraintViolations).hasSize(1);
        assertThat(constraintViolations.stream().toList().get(0).getMessage()).isEqualTo("WinScore has to be positive");
    }
}
