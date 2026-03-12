package com.medeasy.pharmacymanagementsystem.service;


import com.medeasy.pharmacymanagementsystem.dto.MedicineDto;
import com.medeasy.pharmacymanagementsystem.dto.PurchaseRequestDto;
import com.medeasy.pharmacymanagementsystem.model.Medicine;
import com.medeasy.pharmacymanagementsystem.repository.MedicineRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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

    // Method for create medicine
    public Medicine addMedicine(MedicineDto medicineDto){
        Medicine medicine = new Medicine();
        applyDto(medicine, medicineDto);
        return medicineRepository.save(medicine);
    }

    // Method for get all medicine
    public List<Medicine> getAllMedicine(Integer quantity) {
        if(quantity != null && quantity > 0) {
            return medicineRepository.getAllMedicineQuantity(quantity);
        }
        else {
            return medicineRepository.findAll();
        }
    }


    public List<Medicine> getAllMedicineByPrice(Long price) {
        if(price != null && price > 0 ) {
            return medicineRepository.getAllMedicineByPrice(price);
        }
        else {
            return medicineRepository.findAll();
        }
    }


    // Method for find a medicine by id
    public Medicine getMedicineById(Long id) {
        return medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));
    }

    // Method for delete a medicine
    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }

    // Method for update medicine
    public Medicine updateMedicine(Long id, MedicineDto medicineDto) {
        Medicine existing = getMedicineById(id);
        applyDto(existing, medicineDto);
        return medicineRepository.save(existing);
    }

    // Method for search by medicineName
    public List<Medicine> searchByName(String medicineName){
       return medicineRepository.findByMedicineName(medicineName);
    }

    // Method for search by groupName
    public List<Medicine> searchByGroupName(String groupName) {
        return medicineRepository.findByGroupName(groupName);
    }

    //Purchase method
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
