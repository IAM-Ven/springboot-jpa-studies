package com.mycompany.jpaassociations.onetoone.compositepk.rest.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreatePersonDto {

    @ApiModelProperty(example = "Ivan Franchin")
    @NotBlank
    private String name;

}
