package com.example.bloodgroupmanagement.repository;

import com.example.bloodgroupmanagement.model.BloodDonor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BloodDonorRepository extends JpaRepository<BloodDonor, Long> {
    List<BloodDonor> findAllByActiveStatus(int status);

    List<BloodDonor>findAllByLastDonatedBeforeAndActiveStatus(LocalDate startDate,int status);

    List<BloodDonor>findAllByBloodGroupAndActiveStatus(String bloodgroups,int status);

    List<BloodDonor>findAllByBloodGroupAndLastDonatedBeforeAndActiveStatus(String bloodGroup, LocalDate TodaysDate, int status);
}
