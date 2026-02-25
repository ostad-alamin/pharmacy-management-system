package com.medeasy.pharmacymanagementsystem.repository;

import com.medeasy.pharmacymanagementsystem.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
