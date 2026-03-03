package com.medeasy.pharmacymanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;


@JsonPropertyOrder({"medicineName", "groupName", "medicinePrice", "medicineQuantity"})
public class MedicineDto {

    private String medicineName;

    private String groupName;

    private BigDecimal medicinePrice;

    private Integer medicineQuantity;

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public BigDecimal getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(BigDecimal medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public Integer getMedicineQuantity() {
        return medicineQuantity;
    }

    public void setMedicineQuantity(Integer medicineQuantity) {
        this.medicineQuantity = medicineQuantity;
    }
}
