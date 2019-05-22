package com.gateways.manager.gateway;

import com.gateways.manager.domain.entity.value.IPv4Address;

class MockProvider {
    static IPv4Address getNewIPv4() {
        return new IPv4Address("1.1.1.111");
    }
}
