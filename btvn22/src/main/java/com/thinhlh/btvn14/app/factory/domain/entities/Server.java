package com.thinhlh.btvn14.app.factory.domain.entities;

import lombok.Getter;

@Getter
public class Server extends Computer {
    @Override
    public String getType() {
        return "Server";
    }
}
