package com.gateways.manager.web.assembler;

import com.gateways.manager.domain.entity.Gateway;
import com.gateways.manager.web.assembler.resource.GatewayResource;
import com.gateways.manager.web.controller.GatewayController;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Assembler for build {@link GatewayResource} to export {@link Gateway}
 */
@Component
public class GatewayResourceAssembler extends ResourceAssemblerSupport<Gateway, GatewayResource> {

    public GatewayResourceAssembler() {
        super(GatewayController.class, GatewayResource.class);
    }

    @Override
    public GatewayResource toResource(Gateway gateway) {
        Assert.notNull(gateway, "Gateway must not be null");

        return GatewayResource.builder()
                .serialNumber(gateway.getSerialNumber())
                .name(gateway.getName())
                .iPv4(gateway.getIPv4().getIPv4())
                .build();
    }
}
