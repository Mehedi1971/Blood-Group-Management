package com.example.bloodgroupmanagement.dto;

import com.example.bloodgroupmanagement.model.MedicalHistory;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Data
public class BloodDonorDto extends BaseDto{
    private String name;
    private String age;
    private String gender;
    private String phone;
    private String address;
    private String bloodGroup;
    private LocalDate lastDonated;
    private MedicalHistory medicalHistory;
}
