package com.gateways.manager.web.dto;

import lombok.*;

/**
 * Data Transfer Object for receive Gateway
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GatewayDTO {
    private String serialNumber;
    private String name;
    private String ipv4;
}
