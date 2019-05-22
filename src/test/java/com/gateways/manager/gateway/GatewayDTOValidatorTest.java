package com.gateways.manager.gateway;

import com.gateways.manager.web.dto.GatewayDTO;
import com.gateways.manager.web.dto.validator.GatewayDTOValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class GatewayDTOValidatorTest {

    @Test
    public void isValidWhenGatewayDTOHasNotErrorsShouldReturnTrue() {
        GatewayDTO dto = MockProvider.getNewGatewayDTO();

        GatewayDTOValidator validator = new GatewayDTOValidator(dto);
        assertThat(validator.isValid()).isTrue();
    }

    @Test
    public void isValidWhenGatewayDTOHasErrorsShouldReturnFalse() {
        GatewayDTO dto = GatewayDTO.builder().build();

        GatewayDTOValidator validator = new GatewayDTOValidator(dto);
        assertThat(validator.isValid()).isFalse();
    }

    @Test
    public void getErrorsWhenGatewayDTOHasErrorsShouldReturnExpectedErrorMessages() {
        GatewayDTO dto = GatewayDTO.builder().build();

        GatewayDTOValidator validator = new GatewayDTOValidator(dto);
        assertThat(validator.getErrors()).contains("Name must not be null or empty");
        assertThat(validator.getErrors()).contains("SerialNumber must not be null or empty");
        assertThat(validator.getErrors()).contains("IPv4 must not be null or empty");
    }
}
