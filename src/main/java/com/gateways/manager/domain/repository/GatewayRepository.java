package com.gateways.manager.domain.repository;

import com.gateways.manager.domain.entity.Gateway;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for access to {@link Gateway}
 */
public interface GatewayRepository extends JpaRepository<Gateway, String> {
}
