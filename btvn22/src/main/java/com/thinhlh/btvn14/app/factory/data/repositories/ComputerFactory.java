package com.thinhlh.btvn14.app.factory.data.repositories;

import com.thinhlh.btvn14.app.factory.domain.entities.Computer;
import com.thinhlh.btvn14.app.factory.domain.entities.ComputerType;
import com.thinhlh.btvn14.app.factory.domain.entities.PC;
import com.thinhlh.btvn14.app.factory.domain.entities.Server;
import com.thinhlh.btvn14.config.constants.MessageConstants;
import com.thinhlh.btvn14.exceptions.NotFoundException;

public class ComputerFactory {
    public static Computer getComputer(String type) {
        type = type.toUpperCase();

        if (type.equals(ComputerType.PC.name())) {
            return new PC();
        } else if (type.equals(ComputerType.SERVER.name())) {
            return new Server();
        } else {
            throw new NotFoundException(MessageConstants.COMPUTER_TYPE_NOT_FOUND);
        }
    }
}
