package com.gateways.manager.gateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gateways.manager.domain.entity.Gateway;
import com.gateways.manager.domain.service.GatewayService;
import com.gateways.manager.web.assembler.GatewayResourceAssembler;
import com.gateways.manager.web.assembler.resource.GatewayResource;
import com.gateways.manager.web.dto.GatewayDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GatewayIntegrationTest {

    private static String msgHeader = "messages";

    @Autowired
    private GatewayResourceAssembler gatewayResourceAssembler;

    @Autowired
    private GatewayService gatewayService;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mvc;
    private ObjectMapper objectMapper;

    @Before
    public void before () {
        this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void addGatewayShouldReturnSuccessCode() throws Exception {
        GatewayDTO dto = MockProvider.getNewGatewayDTO();
        String gatewayDTO = objectMapper.writeValueAsString(MockProvider.getNewGatewayDTO());
        String gatewaySource = objectMapper.writeValueAsString(getNewGatewayResource());

        MvcResult result = this.mvc.perform(
                post("/gateway")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gatewayDTO))
                .andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(gatewaySource).contains(dto.getName());
        assertThat(gatewaySource).contains(dto.getIpv4());
        assertThat(gatewaySource).contains(dto.getSerialNumber());
    }

    @Test
    public void addGatewayWhenIpv4HasBadFormatShouldReturnUnProcessableEntityCode() throws Exception{
        String gatewayDTO = objectMapper.writeValueAsString(
                GatewayDTO.builder().name("Name").serialNumber("111").ipv4("1555").build());

        MvcResult result = this.mvc.perform(
                post("/gateway")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gatewayDTO))
                .andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY.value());
        assertThat(result.getResponse().getHeaders(msgHeader)).contains("IPv4 bad format");
    }

    @Test
    public void addGatewayWhenMissRequiredFieldsShouldReturnUnProcessableEntity() throws Exception{
        String gatewayDTO = objectMapper.writeValueAsString(GatewayDTO.builder().build());

        MvcResult result = this.mvc.perform(
                post("/gateway")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gatewayDTO))
                .andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY.value());
        assertThat(result.getResponse().getHeaders(msgHeader)).contains("Name must not be null or empty");
        assertThat(result.getResponse().getHeaders(msgHeader)).contains("SerialNumber must not be null or empty");
        assertThat(result.getResponse().getHeaders(msgHeader)).contains("IPv4 must not be null or empty");
    }

    @Test
    public void addGatewayWhenGatewayAlreadyExistShouldReturnUnProcessableEntity() throws Exception {
        Gateway gateway = MockProvider.getNewGateway();
        gatewayService.saveGateway(gateway);

        String gatewayDTO = objectMapper.writeValueAsString(MockProvider.getNewGatewayDTO());

        MvcResult result = this.mvc.perform(
                post("/gateway")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gatewayDTO))
                .andReturn();
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.CONFLICT.value());
        assertThat(result.getResponse().getHeaders(msgHeader)).contains("This Gateway already exist");
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

    private GatewayResource getNewGatewayResource() {
        return gatewayResourceAssembler.toResource(MockProvider.getNewGateway());
    }

}
