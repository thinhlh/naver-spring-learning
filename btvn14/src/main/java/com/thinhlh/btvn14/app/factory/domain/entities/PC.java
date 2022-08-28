package com.thinhlh.btvn14.app.factory.domain.entities;

import lombok.Data;
import lombok.Getter;

public class PC extends Computer {
    @Override
    public String getType() {
        return "PC";
    }
}
