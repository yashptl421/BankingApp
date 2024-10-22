package com.yash.banking.customer_webservices.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapper {


    private final ModelMapper modelMapper = new ModelMapper();

    public <D> D map(Object source, Class<D> destinationType){
        return modelMapper.map(source, destinationType);
    }

}
