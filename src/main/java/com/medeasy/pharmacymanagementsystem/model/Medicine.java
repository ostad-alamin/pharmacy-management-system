package com.medeasy.pharmacymanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@JsonPropertyOrder({"id", "medicineName", "groupName", "medicinePrice", "medicineQuantity"})
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicineName;

    private String groupName;

    private BigDecimal medicinePrice;

    private Integer medicineQuantity;

}


