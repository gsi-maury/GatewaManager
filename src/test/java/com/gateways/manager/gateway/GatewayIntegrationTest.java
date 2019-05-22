package com.gateways.manager.gateway;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GatewayIntegrationTest {

    @Test
    @Ignore
    public void addGatewayShouldReturnSuccessCode() {
        Assert.fail();
    }

    @Test
    @Ignore
    public void addGatewayWhenIpv4HasBadFormatShouldReturnUnProcessableEntity() {
        Assert.fail();
    }

    @Test
    @Ignore
    public void addGatewayWhenMissRequiredFieldsShouldReturnUnProcessableEntity() {
        Assert.fail();
    }

    @Test
    @Ignore
    public void updateGatewayWhenIpv4HasBadFormatShouldGetABadIpv4FormatErrorMessage() {
        Assert.fail();
    }

    @Test
    @Ignore
    public void updateGatewayWhenMissRequiredFieldsShouldGetARequiredFieldErrorMessage() {
        Assert.fail();
    }

    @Test
    @Ignore
    public void updateGatewayShouldUpdateAGateway() {
        Assert.fail();
    }

    @Test
    @Ignore
    public void getGatewayWhenNotExistSerialShouldGetANoContentStatus() {
        Assert.fail();
    }

    @Test
    @Ignore
    public void getGatewayShouldGetAGateway() {
        Assert.fail();
    }

    @Test
    @Ignore
    public void getAllGatewaysShouldGetAllGateways() {
        Assert.fail();
    }

    @Test
    @Ignore
    public void deleteGatewayWhenNotExistSerialShouldGetANoContentStatus() {
        Assert.fail();
    }

    @Test
    @Ignore
    public void deleteGatewayShouldDeleteAGateway() {
        Assert.fail();
    }
}
