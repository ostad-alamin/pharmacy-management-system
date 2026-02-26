package com.medeasy.pharmacymanagementsystem.controller;


import com.medeasy.pharmacymanagementsystem.model.Medicine;
import com.medeasy.pharmacymanagementsystem.service.MedicineService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

@RestController
@RequestMapping("/medicines")
public class MedicineController {


    // We need this object because it is connected to the service layer
    private final MedicineService medicineService;

    // this is the constructor for the class
    public MedicineController(MedicineService medicineService){
        this.medicineService = medicineService;
    }

    // For Create we need Postmapping
    @PostMapping
    public Medicine addMedicine(@RequestBody Medicine medicine){
        return medicineService.addMedicine(medicine);
    }


}
