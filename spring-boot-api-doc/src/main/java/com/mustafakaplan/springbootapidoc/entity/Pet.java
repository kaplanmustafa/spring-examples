package com.mustafakaplan.springbootapidoc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "My Pet Object", description = "My Pet")
public class Pet {

    @ApiModelProperty(value = "Unique id field of Pet object")
    private Integer id;

    @ApiModelProperty(value = "Name field of Pet object")
    private String name;

    @ApiModelProperty(value = "Date field of Pet object")
    private Date date;
}
