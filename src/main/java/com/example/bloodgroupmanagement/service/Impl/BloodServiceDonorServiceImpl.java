package com.example.bloodgroupmanagement.service.Impl;

import com.example.bloodgroupmanagement.dto.BloodDonorDto;
import com.example.bloodgroupmanagement.enums.ActiveStatus;
import com.example.bloodgroupmanagement.model.BloodDonor;
import com.example.bloodgroupmanagement.repository.BloodDonorRepository;
import com.example.bloodgroupmanagement.service.BloodDonorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BloodServiceDonorServiceImpl implements BloodDonorService {
    private final BloodDonorRepository bloodDonorRepository;
    private final ModelMapper modelMapper;

    @Override
    public BloodDonor saveDonor(BloodDonor bloodDonor) {
        return bloodDonorRepository.save(bloodDonor);
//        BloodDonor bloodDonor=modelMapper.map(bloodDonorDto,BloodDonor.class);
//        BloodDonor saved=bloodDonorRepository.save(bloodDonor);
//        return modelMapper.map(saved,BloodDonorDto.class);
//        BloodDonor bloodDonor = bloodDonorRepository.save(modelMapper.map(bloodDonorDto, BloodDonor.class));
//        return modelMapper.map(bloodDonor, BloodDonorDto.class);
    }

    @Override
    public List<BloodDonorDto> gettAllDonor() {
        return bloodDonorRepository.findAll()
                .stream()
                .map((bloodDonor -> modelMapper.map(bloodDonor,BloodDonorDto.class)))
                .collect(Collectors.toList());
    }

    @Override
    public List<BloodDonor> getAllAvailableDonor() {
        LocalDate threeMonthsBefore=LocalDate.now().minusMonths(3);
        return bloodDonorRepository.findAllByLastDonatedBeforeAndActiveStatus(threeMonthsBefore, ActiveStatus.ACTIVE.getValue());
    }


}
