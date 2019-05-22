package com.gateways.manager.gateway;

import com.gateways.manager.domain.entity.Gateway;
import com.gateways.manager.domain.factory.GatewayFactory;
import com.gateways.manager.web.dto.GatewayDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GatewayFactoryTest {

    @Autowired
    private GatewayFactory gatewayFactory;

    @Test
    public void fromGatewayDTOShouldReturnAGateway() {
        GatewayDTO dto = GatewayDTO.builder().ipv4("1.1.1.1").name("Name").serialNumber("111").build();

        Gateway gateway = gatewayFactory.from(dto);
        assertThat(gateway).isNotNull();
        assertThat(gateway.getSerialNumber()).isEqualTo(dto.getSerialNumber());
        assertThat(gateway.getName()).isEqualTo(dto.getName());
        assertThat(gateway.getIPv4().getIPv4()).isEqualTo(dto.getIpv4());
    }

    @Test
    public void fromGatewayDTOWhenGatewayDTOIsNullShouldThrowIllegalArgumentException() {
        assertThatThrownBy(()-> gatewayFactory.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("GatewayDTO must not be null");
    }
}
