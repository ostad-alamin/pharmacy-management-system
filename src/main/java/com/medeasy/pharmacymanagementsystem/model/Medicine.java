package com.medeasy.pharmacymanagementsystem.model;

import jakarta.persistence.Id;

public class Medicine {

    @Id
    private Long medicineId;
    private String medicineName;
}


