package com.example.demo.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UpdateMapper extends ModelMapper {

        @Override
        public <D> D map(Object source, Class<D> destinationType) {
            Object tmpSource = source;
            if(source == null){
                tmpSource = new Object();
            }

            return super.map(tmpSource, destinationType);
        }
    /*@Override
    public void copyProperty(Object dest, String name, Object value)
            throws IllegalAccessException, InvocationTargetException {
        if(value==null)return;
        super.copyProperty(dest, name, value);
    }*/
}
