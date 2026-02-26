package com.medeasy.pharmacymanagementsystem.controller;


import com.medeasy.pharmacymanagementsystem.service.MedicineService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
