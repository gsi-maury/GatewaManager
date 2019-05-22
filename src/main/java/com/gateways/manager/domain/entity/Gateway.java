package com.gateways.manager.domain.entity;

import com.gateways.manager.domain.entity.value.IPv4Address;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Gateway entity class
 */
@Entity(name = "gateway")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Gateway {
    @Id
    @Column(name = "serial_number")
    private String serialNumber;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "ipv4", nullable = false)
    private IPv4Address iPv4;
}
