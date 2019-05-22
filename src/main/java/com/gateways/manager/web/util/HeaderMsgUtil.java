package com.gateways.manager.web.util;

import org.springframework.http.ResponseEntity;

public class HeaderMsgUtil {

    public static ResponseEntity buildMsg(ResponseEntity.HeadersBuilder bodyBuilder, String... msg) {
        return bodyBuilder.header("messages", msg).build();
    }
}
