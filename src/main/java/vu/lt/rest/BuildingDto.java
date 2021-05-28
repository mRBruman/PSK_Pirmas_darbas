package vu.lt.rest;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BuildingDto {

    private String address;

    private Integer build_year;

    private Integer price;

    private String manufacturerCompanyName;
}
