package com.medeasy.pharmacymanagementsystem.repository;

import com.medeasy.pharmacymanagementsystem.dto.MedicineDto;
import com.medeasy.pharmacymanagementsystem.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    // Search medicine by medicineName
    List<Medicine> findByMedicineName(String medicineName);

    // Search medicine by groupName
    List<Medicine> findByGroupName(String groupName);

    // Search medicine by quantity (@Param ?quantity=10)
    @Query(value = "SELECT * FROM Medicine WHERE medicine_quantity <= :quantity", nativeQuery = true)
    List<Medicine> getAllMedicineQuantity(@Param("quantity") Integer quantity);

    @Query(value = "select * from Medicine WHERE medicine_price <= :price", nativeQuery = true)
    List<Medicine> getAllMedicineByPrice(@Param("price") Long price);
}
