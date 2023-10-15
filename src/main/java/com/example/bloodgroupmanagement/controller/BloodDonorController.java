package com.example.bloodgroupmanagement.controller;

import com.example.bloodgroupmanagement.dto.BloodDonorDto;
import com.example.bloodgroupmanagement.model.BloodDonor;
import com.example.bloodgroupmanagement.service.BloodDonorService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/{bloodGroup}/{TodaysDate}")
    public List<BloodDonor> getByBloodGroupAndTodaysDate(@PathVariable String bloodGroup,@PathVariable LocalDate TodaysDate){
        return bloodDonorService.getByBloodGroupAndTodaysDate(bloodGroup,TodaysDate);
    }
}
