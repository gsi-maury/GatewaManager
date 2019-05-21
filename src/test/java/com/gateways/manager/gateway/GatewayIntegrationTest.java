package com.gateways.manager.gateway;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GatewayIntegrationTest {

    @Test
    public void saveGatewayWhenExistSerialShouldGetConflictStatus() {
        Assert.fail();
    }

    @Test
    public void saveGatewayWhenIpv4HasBadFormatShouldGetABadIpv4FormatErrorMessage() {
        Assert.fail();
    }

    @Test
    public void saveGatewayWhenMissRequiredFieldsShouldGetARequiredFieldErrorMessage() {
        Assert.fail();
    }

    @Test
    public void saveGatewayShouldSaveAGateway() {
        Assert.fail();
    }

    @Test
    public void updateGatewayWhenIpv4HasBadFormatShouldGetABadIpv4FormatErrorMessage() {
        Assert.fail();
    }

    @Test
    public void updateGatewayWhenMissRequiredFieldsShouldGetARequiredFieldErrorMessage() {
        Assert.fail();
    }

    @Test
    public void updateGatewayShouldUpdateAGateway() {
        Assert.fail();
    }

    @Test
    public void getGatewayWhenNotExistSerialShouldGetANoContentStatus() {
        Assert.fail();
    }

    @Test
    public void getGatewayShouldGetAGateway() {
        Assert.fail();
    }

    @Test
    public void getAllGatewaysShouldGetAllGateways() {
        Assert.fail();
    }

    @Test
    public void deleteGatewayWhenNotExistSerialShouldGetANoContentStatus() {
        Assert.fail();
    }

    @Test
    public void deleteGatewayShouldDeleteAGateway() {
        Assert.fail();
    }
}
