package com.gateways.manager.web.controller;

import com.gateways.manager.domain.entity.Gateway;
import com.gateways.manager.domain.factory.GatewayFactory;
import com.gateways.manager.domain.service.GatewayService;
import com.gateways.manager.web.assembler.GatewayResourceAssembler;
import com.gateways.manager.web.assembler.resource.GatewayResource;
import com.gateways.manager.web.dto.GatewayDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/gateway")
public class GatewayController {

    private GatewayService gatewayService;
    private GatewayFactory gatewayFactory;
    private GatewayResourceAssembler gatewayAssembler;

    @Autowired
    public GatewayController(GatewayService gatewayService, GatewayFactory gatewayFactory, GatewayResourceAssembler gatewayAssembler) {
        this.gatewayService = gatewayService;
        this.gatewayFactory = gatewayFactory;
        this.gatewayAssembler = gatewayAssembler;
    }

}
