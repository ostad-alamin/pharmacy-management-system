package com.medeasy.pharmacymanagementsystem.controller;


import com.medeasy.pharmacymanagementsystem.dto.MedicineDto;
import com.medeasy.pharmacymanagementsystem.model.Medicine;
import com.medeasy.pharmacymanagementsystem.service.MedicineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

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

//    public Medicine addMedicine(@RequestBody Medicine medicine){
//        return medicineService.addMedicine(medicine);
//    }

    @PostMapping("/save")
    public ResponseEntity<Medicine> addMedicine(@RequestBody MedicineDto medicineDto){
        Medicine createdMedicine = medicineService.addMedicine(medicineDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMedicine);
    }

    @GetMapping("/get/all")
    public List<Medicine> getAllMedicine() {
        return medicineService.getAllMedicine();
    }

    // can be used as optional
    // id
    /*@GetMapping("/{id}")
    public Medicine getMedicineById(@PathVariable Long id){
        return medicineService.getMedicineById(id);
    }*/

    @GetMapping("/get/{id}")
    public Medicine getMedicineById(@PathVariable Long id) {
        return medicineService.getMedicineById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
        return id + " number ids data is deleted";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Medicine> update (@PathVariable Long id, @RequestBody MedicineDto medicineDto) {
        Medicine s = medicineService.updateMedicine(id, medicineDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(s);
    }

    @GetMapping("/name/{name}")



}
