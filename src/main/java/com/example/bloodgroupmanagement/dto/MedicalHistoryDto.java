package com.example.bloodgroupmanagement.dto;

import lombok.Data;


@Data
public class MedicalHistoryDto extends BaseDto {
    private Boolean illness;
    private Boolean allergies;
    private String otherFactors;
}
