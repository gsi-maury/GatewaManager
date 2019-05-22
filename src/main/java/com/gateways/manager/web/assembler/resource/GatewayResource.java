package com.gateways.manager.web.assembler.resource;

import lombok.*;
import org.springframework.hateoas.ResourceSupport;

/**
 * Resource for export {@link com.gateways.manager.domain.entity.Gateway} to web clients
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GatewayResource extends ResourceSupport {
    private String serialNumber;
    private String name;
    private String iPv4;
}
