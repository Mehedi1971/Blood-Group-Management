package com.example.bloodgroupmanagement.service.Impl;

import com.example.bloodgroupmanagement.dto.DashboardDto;
import com.example.bloodgroupmanagement.enums.ActiveStatus;
import com.example.bloodgroupmanagement.enums.BloodGroup;
import com.example.bloodgroupmanagement.repository.BloodDonorRepository;
import com.example.bloodgroupmanagement.repository.MedicalHistoryRepository;
import com.example.bloodgroupmanagement.service.DashBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DashBoardServiceImpl implements DashBoardService {
    private final BloodDonorRepository bloodDonorRepository;
    private final MedicalHistoryRepository medicalHistoryRepository;

    @Override
    public DashboardDto dashBoard() {
        DashboardDto dashboardDto = new DashboardDto();

        LocalDate threeMonthsBefore = LocalDate.now().minusMonths(3);

        dashboardDto.setTotalDonor(bloodDonorRepository.findAllByActiveStatus(ActiveStatus.ACTIVE.getValue()).size());
//        dashboardDto.setTotalAvailableDonor(bloodDonorRepository.findAllByLastDonatedBeforeAndActiveStatus(threeMonthsBefore,ActiveStatus.ACTIVE.getValue()).size());

        dashboardDto.setTotalAvailableDonor(bloodDonorRepository.findAllByLastDonatedBeforeAndActiveStatus(threeMonthsBefore, ActiveStatus.ACTIVE.getValue())
                .stream()
                .filter(bloodDonor -> (!bloodDonor.getMedicalHistory().getAllergies() && bloodDonor.getMedicalHistory().getActiveStatus() == (ActiveStatus.ACTIVE.getValue())))
                .count());

        dashboardDto.setTotalAPositive(bloodDonorRepository.findAllByBloodGroupAndActiveStatus(BloodGroup.A_POSITIVE.getValue(), ActiveStatus.ACTIVE.getValue()).size());
        dashboardDto.setTotalANegative(bloodDonorRepository.findAllByBloodGroupAndActiveStatus(BloodGroup.A_NEGATIVE.getValue(), ActiveStatus.ACTIVE.getValue()).size());
        dashboardDto.setTotalBPositive(bloodDonorRepository.findAllByBloodGroupAndActiveStatus(BloodGroup.B_POSITIVE.getValue(), ActiveStatus.ACTIVE.getValue()).size());
        dashboardDto.setTotalBNegative(bloodDonorRepository.findAllByBloodGroupAndActiveStatus(BloodGroup.B_NEGATIVE.getValue(), ActiveStatus.ACTIVE.getValue()).size());
        dashboardDto.setTotalABPositive(bloodDonorRepository.findAllByBloodGroupAndActiveStatus(BloodGroup.AB_POSITIVE.getValue(), ActiveStatus.ACTIVE.getValue()).size());
        dashboardDto.setTotalABNegative(bloodDonorRepository.findAllByBloodGroupAndActiveStatus(BloodGroup.AB_NEGATIVE.getValue(), ActiveStatus.ACTIVE.getValue()).size());
        dashboardDto.setTotalOPositive(bloodDonorRepository.findAllByBloodGroupAndActiveStatus(BloodGroup.O_POSITIVE.getValue(), ActiveStatus.ACTIVE.getValue()).size());
        dashboardDto.setTotalONegative(bloodDonorRepository.findAllByBloodGroupAndActiveStatus(BloodGroup.O_NEGATIVE.getValue(), ActiveStatus.ACTIVE.getValue()).size());

//        dashboardDto.setTotalAvailableDonor(bloodDonorRepository
//                .findAllByLastDonatedBeforeAndActiveStatus(threeMonthsBefore, ActiveStatus.ACTIVE.getValue())
//                .stream()
//                .filter(bloodDonor -> !medicalHistoryRepository
//                        .findAllByActiveStatusAndAllergies(ActiveStatus.ACTIVE.getValue(), false).contains(bloodDonor))
//                .count());


        return dashboardDto;
    }
}
