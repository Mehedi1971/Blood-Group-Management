package com.example.bloodgroupmanagement.service.Impl;

import com.example.bloodgroupmanagement.dto.DashboardDto;
import com.example.bloodgroupmanagement.enums.ActiveStatus;
import com.example.bloodgroupmanagement.repository.BloodDonorRepository;
import com.example.bloodgroupmanagement.service.DashBoardService;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashBoardServiceImpl implements DashBoardService {

  private final BloodDonorRepository bloodDonorRepository;
//  private final MedicalHistoryRepository medicalHistoryRepository;

  @Override
  public DashboardDto dashBoard() {
    DashboardDto dashboardDto = new DashboardDto();

    LocalDate threeMonthsBefore = LocalDate.now().minusMonths(3);

    dashboardDto.setTotalDonor(
        bloodDonorRepository.findAllByActiveStatus(ActiveStatus.ACTIVE.getValue()).size());

//        dashboardDto.setTotalAvailableDonor(bloodDonorRepository.findAllByLastDonatedBeforeAndActiveStatus(threeMonthsBefore,ActiveStatus.ACTIVE.getValue()).size());

//    List<MedicalHistory> abc=medicalHistoryRepository
//        .findAllByActiveStatusAndAllergies(ActiveStatus.ACTIVE.getValue(), false);

    dashboardDto.setTotalAvailableDonor(bloodDonorRepository.findAllByLastDonatedBeforeAndActiveStatus(threeMonthsBefore,ActiveStatus.ACTIVE.getValue())
        .stream()
        .filter(bloodDonor-> !bloodDonor.getMedicalHistory().getAllergies())
        .count());
//if(!abc.isEmpty()){
//  dashboardDto.setTotalAvailableDonor(bloodDonorRepository.findAllByLastDonatedBeforeAndActiveStatus(threeMonthsBefore,ActiveStatus.ACTIVE.getValue()).size());
//
//}
//    dashboardDto.setTotalAvailableDonor(bloodDonorRepository
//        .findAllByLastDonatedBeforeAndActiveStatus(threeMonthsBefore,
//            ActiveStatus.ACTIVE.getValue())
//        .stream()
//        .filter(bloodDonor -> !medicalHistoryRepository
//            .findAllByActiveStatusAndAllergies(ActiveStatus.ACTIVE.getValue(), false)
//            .isEmpty())
//        .count());

    return dashboardDto;
  }
}
