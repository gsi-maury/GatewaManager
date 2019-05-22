package com.gateways.manager.web.controller;

import com.gateways.manager.domain.factory.GatewayFactory;
import com.gateways.manager.domain.service.GatewayService;
import com.gateways.manager.web.assembler.GatewayResourceAssembler;
import com.gateways.manager.web.dto.GatewayDTO;
import com.gateways.manager.web.dto.validator.GatewayDTOValidator;
import com.gateways.manager.web.util.HeaderMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity saveGateway(@RequestBody GatewayDTO gatewayDTO) {
        GatewayDTOValidator validator = new GatewayDTOValidator(gatewayDTO);

        if (!validator.isValid())
            return HeaderMsgUtil.buildMsg(ResponseEntity.unprocessableEntity(),
                    validator.getErrors().toArray(new String[0]));

        if (gatewayService.getGateway(gatewayDTO.getSerialNumber()).isPresent())
            return HeaderMsgUtil.buildMsg(
                    ResponseEntity.status(HttpStatus.CONFLICT), "This Gateway already exist");

        return ResponseEntity.ok(gatewayAssembler.toResource(
                gatewayService.saveGateway(gatewayFactory.from(gatewayDTO))));
    }
}
