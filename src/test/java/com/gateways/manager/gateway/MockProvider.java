package com.gateways.manager.gateway;

import com.gateways.manager.domain.entity.Gateway;
import com.gateways.manager.domain.entity.value.IPv4Address;
import com.gateways.manager.web.dto.GatewayDTO;

class MockProvider {
    static IPv4Address getNewIPv4() {
        return new IPv4Address("1.1.1.111");
    }

    static Gateway getNewGateway() {
        return Gateway.builder().iPv4(getNewIPv4()).name("Name").serialNumber("111").build();
    }

    static GatewayDTO getNewGatewayDTO() {
        Gateway gateway = getNewGateway();

        return GatewayDTO.builder().ipv4(gateway.getIPv4().getIPv4())
                .name(gateway.getName()).serialNumber(gateway.getSerialNumber()).build();
    }
}
