package com.medeasy.pharmacymanagementsystem.controller;


import com.medeasy.pharmacymanagementsystem.dto.MedicineDto;
import com.medeasy.pharmacymanagementsystem.dto.PurchaseRequestDto;
import com.medeasy.pharmacymanagementsystem.model.Medicine;
import com.medeasy.pharmacymanagementsystem.service.MedicineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

    // We need this object because it is connected to the service layer
    private final MedicineService medicineService;

    // This is the constructor for the class
    public MedicineController(MedicineService medicineService){
        this.medicineService = medicineService;
    }

    // Create medicine
    @PostMapping("/save")
    public ResponseEntity<Medicine> addMedicine(@RequestBody MedicineDto medicineDto){
        Medicine createdMedicine = medicineService.addMedicine(medicineDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMedicine);
    }

    // Get all medicine
    @GetMapping("/get/all")
    public List<Medicine> getAllMedicine(@RequestParam(value = "quantity", required = false) Integer quantity) {
        return medicineService.getAllMedicine(quantity);
    }

    @GetMapping("/get/all/byPrice")
    public List<Medicine> getAllMedicine(@RequestParam(value = "price", required = false) Long price) {
        return medicineService.getAllMedicineByPrice(price);
    }

    // Get medicine by id
    @GetMapping("/get/{id}")
    public Medicine getMedicineById(@PathVariable Long id) {
        return medicineService.getMedicineById(id);
    }

    //Delete medicine by id
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
    }

    // Update medicine by id and payload
    @PutMapping("/update/{id}")
    public ResponseEntity<Medicine> update (@PathVariable Long id, @RequestBody MedicineDto medicineDto) {
        Medicine s = medicineService.updateMedicine(id, medicineDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(s);
    }

    // Search medicine by String medicineName
    @GetMapping("/name/{medicineName}")
    public ResponseEntity<List<Medicine>> searchByName(@PathVariable String medicineName){
        return ResponseEntity.ok(medicineService.searchByName(medicineName));
    }

    // Search medicine by String groupName
    @GetMapping("/group-name/{groupName}")
    public ResponseEntity<List<Medicine>> searchByGroupName(@PathVariable String groupName) {
        return ResponseEntity.ok(medicineService.searchByGroupName(groupName));
    }

    // Purchase medicine by payload, after purchasing quantity change automatically
    @PostMapping("/purchase")
    public ResponseEntity<Medicine> purchaseMedicine(@RequestBody PurchaseRequestDto purchaseRequestDto) {
        Medicine medicine = medicineService.purchaseMedicine(purchaseRequestDto);
        return ResponseEntity.ok(medicine);
    }
}

