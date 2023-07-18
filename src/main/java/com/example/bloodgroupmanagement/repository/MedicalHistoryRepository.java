package com.example.bloodgroupmanagement.repository;

import com.example.bloodgroupmanagement.model.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory,Long> {
    List<MedicalHistory> findAllByActiveStatusAndAllergies(int status,Boolean allergies);
}
