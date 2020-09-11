package com.dome.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HHH {

    A("A",1),
    B("B",2),
    ;

    public static HHH getByName(String name){
       return A;
    }

    private String name;
    private Integer age;
}

class A{
    public static void main(String[] args) {


        switch (HHH.getByName("")){
            case A:
                break;
            case B:
                break;
        }
    }
}