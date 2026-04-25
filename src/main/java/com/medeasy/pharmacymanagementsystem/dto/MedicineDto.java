package com.medeasy.pharmacymanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonPropertyOrder({"medicineName", "groupName", "medicinePrice", "medicineQuantity"})
public class MedicineDto {

    private String medicineName;

    private String groupName;

    private BigDecimal medicinePrice;

    private Integer medicineQuantity;

}
