package com.example.bloodgroupmanagement.controller;

import com.example.bloodgroupmanagement.dto.BloodDonorDto;
import com.example.bloodgroupmanagement.model.BloodDonor;
import com.example.bloodgroupmanagement.repository.BloodDonorRepository;
import com.example.bloodgroupmanagement.service.BloodDonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/donor")
public class BloodDonorController {
    private final BloodDonorService bloodDonorService;

    @PostMapping
    public BloodDonor saveDonor(@RequestBody BloodDonor bloodDonor) {
        return bloodDonorService.saveDonor(bloodDonor);
    }

    @GetMapping
    public List<BloodDonorDto> getAllDonor(){
        return bloodDonorService.gettAllDonor();
    }

    @GetMapping("/listofAvailableDonor")
    public List<BloodDonor> getAllAvailableDonor(){
        return bloodDonorService.getAllAvailableDonor();
    }
}
