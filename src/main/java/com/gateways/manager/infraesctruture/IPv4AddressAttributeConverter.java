package com.gateways.manager.infraesctruture;

import com.gateways.manager.domain.entity.value.IPv4Address;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *  AttributeConverter for serialization and deserialization of IPv4Address
 */
@Converter(autoApply = true)
public class IPv4AddressAttributeConverter implements AttributeConverter<IPv4Address, String> {

    @Override
    public String convertToDatabaseColumn(IPv4Address attribute) {
        return attribute.getIPv4();
    }

    @Override
    public IPv4Address convertToEntityAttribute(String dbData) {
        return new IPv4Address(dbData);
    }
}
