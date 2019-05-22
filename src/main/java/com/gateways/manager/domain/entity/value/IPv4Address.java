package com.gateways.manager.domain.entity.value;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.util.Assert;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * Value object for IPv4 Address
 */
@Getter
@EqualsAndHashCode
public final class IPv4Address {

    private final String iPv4;

    public IPv4Address(String iPv4) {
        Assert.notNull(iPv4, "IPv4 must not be null");
        boolean goodFormat;
        try {
            goodFormat = Inet4Address.getByName(iPv4).getHostAddress().equals(iPv4);
        } catch (UnknownHostException e) {
            goodFormat = false;
        }
        Assert.isTrue(goodFormat, "IPv4 bad format");
        this.iPv4 = iPv4;
    }
}
