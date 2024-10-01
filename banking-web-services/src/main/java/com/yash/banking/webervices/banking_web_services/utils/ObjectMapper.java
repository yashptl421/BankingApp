package com.yash.banking.webervices.banking_web_services.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapper {


    private final ModelMapper modelMapper = new ModelMapper();

    public <D> D map(Object source, Class<D> destinationType){
        return modelMapper.map(source, destinationType);
    }

}
