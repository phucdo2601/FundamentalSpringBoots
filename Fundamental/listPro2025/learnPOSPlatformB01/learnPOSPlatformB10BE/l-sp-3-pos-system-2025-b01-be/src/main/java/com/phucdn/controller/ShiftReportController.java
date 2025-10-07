package com.phucdn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.service.ShiftReportService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/shift-reports")
@RequiredArgsConstructor
public class ShiftReportController {

	private final ShiftReportService shiftReportService;
}
