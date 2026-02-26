package com.medeasy.pharmacymanagementsystem.service;


import com.medeasy.pharmacymanagementsystem.model.Medicine;
import com.medeasy.pharmacymanagementsystem.repository.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {

    // Service layer is connected to the repository layer that's a object needs to be initialized
    private final MedicineRepository medicineRepository;

    // This is the constructor for the class in combination of the object
    // If we add this we don't need the @RequiredArgsConstructor
    public MedicineService(MedicineRepository medicineRepository){
        this.medicineRepository = medicineRepository;
    }

    // Create a medicine from the admin side
    public Medicine addMedicine(Medicine medicine){
        return medicineRepository.save(medicine);
    }






}
