package com.thinhlh.btvn14.app.factory.data.services;

import com.thinhlh.btvn14.app.factory.data.repositories.ComputerFactory;
import com.thinhlh.btvn14.app.factory.domain.entities.Computer;
import com.thinhlh.btvn14.app.factory.domain.services.ComputerService;
import org.springframework.stereotype.Service;

@Service
public class ComputerServiceImpl implements ComputerService {
    @Override
    public Computer getComputer(String type) {
        return ComputerFactory.getComputer(type);
    }
}
