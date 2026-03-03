package com.medeasy.pharmacymanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@JsonPropertyOrder({"id", "medicineName", "groupName", "medicinePrice", "medicineQuantity"})
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicineName;

    private String groupName;

    private BigDecimal medicinePrice;

    private Integer medicineQuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long medicineId) {
        this.id = id;
    }

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


