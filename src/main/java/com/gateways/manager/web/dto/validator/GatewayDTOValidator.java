package com.gateways.manager.web.dto.validator;

import com.gateways.manager.domain.entity.value.IPv4Address;
import com.gateways.manager.web.dto.GatewayDTO;

import java.util.Objects;

public class GatewayDTOValidator extends DTOValidator<GatewayDTO> {

    public GatewayDTOValidator(GatewayDTO dto) {
        super(dto);
        validate();
    }

    @Override
    public void validate() {
        errors.clear();
        if (Objects.isNull(dto)) {
            errors.add("Gateway DTO must not be null");
            return;
        }

        if (Objects.isNull(dto.getName()) || dto.getName().isEmpty())
            errors.add("Name must not be null or empty");
        if (Objects.isNull(dto.getSerialNumber()) || dto.getSerialNumber().isEmpty())
            errors.add("SerialNumber must not be null or empty");
        if (Objects.isNull(dto.getIpv4()) || dto.getIpv4().isEmpty())
            errors.add("IPv4 must not be null or empty");
        else
            try {
                new IPv4Address(dto.getIpv4());
            } catch (Exception e) {
                errors.add(e.getMessage());
            }
    }
}
