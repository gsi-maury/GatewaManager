package com.gateways.manager.domain.service;

import com.gateways.manager.domain.entity.Gateway;
import com.sun.istack.internal.NotNull;

import java.util.Optional;

public interface GatewayService {

    Gateway saveGateway(@NotNull Gateway gateway);

    Optional<Gateway> getGateway(@NotNull String serialNumber);

}
