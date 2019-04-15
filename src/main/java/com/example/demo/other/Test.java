package com.example.demo.other;

import lombok.ToString;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

@ToString
public class Test {
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.setName1("abhii");
        demo1.setAge1("10");

        Demo2 demo2 = new Demo2();
        demo2.setAge2("15");
        demo2.setName2("raj");
        demo2.setDemo1(demo1);

        System.out.println(demo2.toString());

        Demo1 demo3 = new Demo1();
        demo3.setName1("abhi update");

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        //demo 3 is update object
        //demo 2 is old value object ... new value map in demo 2
        modelMapper.map(demo3,demo2);
        System.out.println(demo2.toString());
    }
}
