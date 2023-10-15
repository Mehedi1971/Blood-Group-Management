package com.example.bloodgroupmanagement.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodDonor extends BaseModel{
    private String name;
    private String age;
    private String gender;
    private String phone;
    private String address;
    private String bloodGroup;
    private LocalDate lastDonated;

    @OneToOne(cascade = CascadeType.ALL)
    private MedicalHistory medicalHistory;
}
