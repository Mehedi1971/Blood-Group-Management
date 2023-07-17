package com.example.bloodgroupmanagement.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalHistory extends BaseModel{
    private Boolean illness;
    private Boolean allergies;
    private String otherFactors;
}
