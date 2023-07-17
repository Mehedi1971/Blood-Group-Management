package com.example.bloodgroupmanagement.controller;

import com.example.bloodgroupmanagement.dto.DashboardDto;
import com.example.bloodgroupmanagement.service.DashBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public")
public class DashBoardController {

    private final DashBoardService dashBoardService;

    @GetMapping
    public DashboardDto dashBoard() {
        return dashBoardService.dashBoard();
    }
}
