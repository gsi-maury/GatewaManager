package com.gateways.manager.gateway;

import com.gateways.manager.domain.entity.Gateway;
import com.gateways.manager.domain.entity.value.IPv4Address;
import com.gateways.manager.domain.repository.GatewayRepository;
import com.gateways.manager.domain.service.GatewayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GatewayServiceTest {

    @Autowired
    private GatewayService gatewayService;

    @Autowired
    private GatewayRepository gatewayRepository;

    @Test
    public void saveGatewayShouldSaveAGateway() {
        Gateway gateway = Gateway.builder().serialNumber("1111").name("Name")
                .iPv4(getIPv4()).build();
        gatewayService.saveGateway(gateway);
        assertThat(gatewayRepository.getOne(gateway.getSerialNumber()).getSerialNumber())
                .isEqualTo(gateway.getSerialNumber());
    }

    @Test
    public void saveGatewayWhenGatewayIsNullShouldThrowIllegalArgumentException() {
        assertThatThrownBy(()-> gatewayService.saveGateway(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Gateway must not be null");
    }

    @Test
    public void saveGatewayWhenNameIsNullShouldThrowIllegalArgumentException() {
        Gateway gateway = Gateway.builder().iPv4(getIPv4()).serialNumber("123").build();

        assertThatThrownBy(()-> gatewayService.saveGateway(gateway))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Name must not be null");
    }

    @Test
    public void saveGatewayWhenSerialNumberIsNullShouldThrowIllegalArgumentException() {
        Gateway gateway = Gateway.builder().iPv4(getIPv4()).name("Name").build();

        assertThatThrownBy(()-> gatewayService.saveGateway(gateway))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("SerialNumber must not be null");
    }

    @Test
    public void saveGatewayWhenIPv4IsNullShouldThrowIllegalArgumentException() {
        Gateway gateway = Gateway.builder().serialNumber("111").name("Name").build();

        assertThatThrownBy(()-> gatewayService.saveGateway(gateway))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("IPv4 must not be null");
    }

    @Test
    public void getGatewayShouldGetAGateway() {
        Gateway gateway = Gateway.builder().serialNumber("111").name("Name").iPv4(getIPv4()).build();
        gatewayService.saveGateway(gateway);

        assertThat(gatewayService.getGateway(gateway.getSerialNumber()).isPresent()).isTrue();
        assertThat(gatewayService.getGateway(gateway.getSerialNumber()).get().getSerialNumber())
                .isEqualTo(gateway.getSerialNumber());
    }

    @Test
    public void getGatewayWhenGatewayNotExistShouldAEmptyOptional() {
        assertThat(gatewayService.getGateway("1234").isPresent()).isFalse();
    }

    @Test
    public void getGatewayWhenSerialNumberIsNullShouldThrowIllegalArgumentException() {
        assertThatThrownBy(()-> gatewayService.getGateway(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("SerialNumber must not be null");
    }

    private IPv4Address getIPv4() {
        return new IPv4Address("1.1.1.111");
    }
}
