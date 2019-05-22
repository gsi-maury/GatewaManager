package com.gateways.manager.domain.factory;

import com.gateways.manager.domain.entity.Gateway;
import com.gateways.manager.domain.entity.value.IPv4Address;
import com.gateways.manager.web.dto.GatewayDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;

/**
 *  Factory for build {@link Gateway}
 */
@Component
public class GatewayFactory {

    /**
     * Build a {@link Gateway} from {@link GatewayDTO}
     *
     * @param dto {@link GatewayDTO}
     * @return Gateway
     */
    public Gateway from(@NotNull GatewayDTO dto) {
        Assert.notNull(dto, "GatewayDTO must not be null");

        return Gateway.builder()
                .serialNumber(dto.getSerialNumber())
                .iPv4(new IPv4Address(dto.getIpv4()))
                .name(dto.getName())
                .build();
    }
}
