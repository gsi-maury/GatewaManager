package com.gateways.manager.domain.service;

import com.gateways.manager.domain.entity.Gateway;
import com.gateways.manager.domain.repository.GatewayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class GatewayServiceImpl implements GatewayService {

    private GatewayRepository gatewayRepository;

    @Autowired
    public GatewayServiceImpl(GatewayRepository gatewayRepository) {
        this.gatewayRepository = gatewayRepository;
    }

    @Override
    public Gateway saveGateway(Gateway gateway) {
        Assert.notNull(gateway, "Gateway must not be null");
        Assert.notNull(gateway.getName(), "Name must not be null");
        Assert.notNull(gateway.getIPv4(), "IPv4 must not be null");
        Assert.notNull(gateway.getSerialNumber(), "SerialNumber must not be null");

        return gatewayRepository.save(gateway);
    }

    @Override
    public Optional<Gateway> getGateway(String serialNumber) {
        Assert.notNull(serialNumber, "SerialNumber must not be null");

        return gatewayRepository.findById(serialNumber);
    }
}
