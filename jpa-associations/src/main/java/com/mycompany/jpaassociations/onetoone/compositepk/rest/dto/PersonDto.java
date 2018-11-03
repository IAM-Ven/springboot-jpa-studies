package com.mycompany.jpaassociations.onetoone.compositepk.rest.dto;

import lombok.Data;

@Data
public class PersonDto {

    private Long id;
    private String name;
    private PersonDetailDto personDetail;

}
