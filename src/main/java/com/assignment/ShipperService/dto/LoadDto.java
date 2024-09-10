package com.assignment.ShipperService.dto;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class LoadDto {
    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private String noOfTrucks;
    private String weight;
    private String description;
    private Integer shipperId;
    private Timestamp date;
}
