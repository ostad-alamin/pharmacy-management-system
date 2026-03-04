package com.medeasy.pharmacymanagementsystem.service;


import com.medeasy.pharmacymanagementsystem.dto.MedicineDto;
import com.medeasy.pharmacymanagementsystem.dto.MedicineResponseDto;
import com.medeasy.pharmacymanagementsystem.dto.PurchaseRequestDto;
import com.medeasy.pharmacymanagementsystem.model.Medicine;
import com.medeasy.pharmacymanagementsystem.repository.MedicineRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {

    // Service layer is connected to the repository layer that's a object needs to be initialized
    private final MedicineRepository medicineRepository;

    // This is the constructor for the class in combination of the object
    // If we add this we don't need the @RequiredArgsConstructor
    public MedicineService(MedicineRepository medicineRepository){
        this.medicineRepository = medicineRepository;
    }


    // method to convert DTO to entity
    public void applyDto(Medicine medicine, MedicineDto medicineDto){
        medicine.setMedicineName(medicineDto.getMedicineName());
        medicine.setMedicinePrice(medicineDto.getMedicinePrice());
        medicine.setMedicineQuantity(medicineDto.getMedicineQuantity());
        medicine.setGroupName(medicineDto.getGroupName());
    }

    /*public void applyResponseDto(Medicine medicine, MedicineResponseDto medicineResponseDto){
        medicine.setMedicineName(medicineResponseDto.getMedicineName());
        medicine.setMedicinePrice(medicineResponseDto.getMedicinePrice());
        medicine.setGroupName(medicineResponseDto.getGroupName());
    }*/

    // Create a medicine from the admin side
    public Medicine addMedicine(MedicineDto medicineDto){
        Medicine medicine = new Medicine();
        applyDto(medicine, medicineDto);
        return medicineRepository.save(medicine);
    }

    // method for get all medicine
    public List<Medicine> getAllMedicine() {
        return medicineRepository.findAll();
    }

    /*public Optional<Medicine> getMedicineById(Long id){
        return medicineRepository.findById(id);
    }*/

    // find a medicine by id
    public Medicine getMedicineById(Long id) {
        return medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));
    }

    // method for delete a medicine
    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }

    // method for update medicine details if needed
    public Medicine updateMedicine(Long id, MedicineDto medicineDto) {
        Medicine existing = getMedicineById(id);
        applyDto(existing, medicineDto);
        return medicineRepository.save(existing);
    }

    // method for search by name
    public List<Medicine> searchByName(String medicineName){
       return medicineRepository.findByMedicineName(medicineName);
    }

    /*public List<MedicineDto> searchByName(String name) {
        List<Medicine> medicines = medicineRepository.findByMedicineName(name);

        return medicines.stream()
                .map(this::applyDto)
                .toList();
    }*/

    public List<Medicine> searchByGroupName(String groupName) {
        return medicineRepository.findByGroupName(groupName);
    }


    @Transactional
    public Medicine purchaseMedicine(PurchaseRequestDto purchaseRequestDto){
        Medicine medicine = medicineRepository.findById(purchaseRequestDto.getPurchaseId())
                .orElseThrow(() -> new RuntimeException("Not found with this id"));

        if (medicine.getMedicineQuantity() < purchaseRequestDto.getPurchaseQuantity()){
            System.out.println("stock not available");
        }


        medicine.setMedicineQuantity(medicine.getMedicineQuantity() -
                purchaseRequestDto.getPurchaseQuantity());

        if (medicine.getMedicineQuantity() <= 5 && medicine.getMedicineQuantity() > 0){
            System.out.println("stock is about to end");
        }

        return medicineRepository.save(medicine);
    }


}
