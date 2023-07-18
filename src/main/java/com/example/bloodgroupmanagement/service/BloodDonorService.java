package com.example.bloodgroupmanagement.service;

import com.example.bloodgroupmanagement.dto.BloodDonorDto;
import com.example.bloodgroupmanagement.model.BloodDonor;

import java.time.LocalDate;
import java.util.List;

public interface BloodDonorService {
    BloodDonor saveDonor(BloodDonor bloodDonor);

    List<BloodDonorDto> gettAllDonor();

    List<BloodDonor> getAllAvailableDonor();

    List<BloodDonor> getByBloodGroupAndTodaysDate(String bloodGroup, LocalDate TodaysDate);
}
