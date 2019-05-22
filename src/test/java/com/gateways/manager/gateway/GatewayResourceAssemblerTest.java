package com.gateways.manager.gateway;

import com.gateways.manager.domain.entity.Gateway;
import com.gateways.manager.web.assembler.GatewayResourceAssembler;
import com.gateways.manager.web.assembler.resource.GatewayResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
import static com.gateways.manager.gateway.MockProvider.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GatewayResourceAssemblerTest {

    @Autowired
    private GatewayResourceAssembler gatewayAssembler;

    @Test
    public void toResourceShouldReturnAGateway() {
        Gateway gateway = Gateway.builder().iPv4(getNewIPv4()).name("Name").serialNumber("111").build();

        GatewayResource resource = gatewayAssembler.toResource(gateway);
        assertThat(resource).isNotNull();
        assertThat(resource.getSerialNumber()).isEqualTo(gateway.getSerialNumber());
        assertThat(resource.getName()).isEqualTo(gateway.getName());
        assertThat(resource.getIPv4()).isEqualTo(gateway.getIPv4().getIPv4());
    }

    @Test
    public void toResourceWhenGatewayIsNullShouldThrowIllegalArgumentException() {
        assertThatThrownBy(()-> gatewayAssembler.toResource(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Gateway must not be null");
    }
}
