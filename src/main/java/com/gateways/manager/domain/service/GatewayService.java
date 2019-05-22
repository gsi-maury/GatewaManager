package com.gateways.manager.domain.service;

import com.gateways.manager.domain.entity.Gateway;
import com.sun.istack.internal.NotNull;

public interface GatewayService {

    Gateway saveGateway(@NotNull Gateway gateway);

}
