package com.example.bloodgroupmanagement.dto;

import lombok.Data;

@Data
public class DashboardDto {
    private long totalDonor;
    private long totalAvailableDonor;
    private long totalAPositive;
    private long totalANegative;
    private long totalBPositive;
    private long totalBNegative;
    private long totalABPositive;
    private long totalABNegative;
    private long totalOPositive;
    private long totalONegative;
}
