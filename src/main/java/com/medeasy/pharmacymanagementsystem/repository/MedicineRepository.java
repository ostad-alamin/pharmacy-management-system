package com.medeasy.pharmacymanagementsystem.repository;

import com.medeasy.pharmacymanagementsystem.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    // search by first name
    List<Medicine> findByMedicineName(String medicineName);
}
