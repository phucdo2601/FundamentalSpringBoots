package com.web.phucdn.controllers;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.phucdn.dto.GeneralStatusDto;
import com.web.phucdn.dto.request.CreateGeneralStatusDto;
import com.web.phucdn.models.GeneralStatus;
import com.web.phucdn.services.BaseService;
import com.web.phucdn.services.IGeneralStatusService;
import com.web.phucdn.services.impl.GeneralStatusService;

@RestController
@RequestMapping("/api/v1/generalStatus")
public class GeneralStatusController extends BaseController<GeneralStatus, GeneralStatusDto, GeneralStatusService> {

	public GeneralStatusController(BaseService<GeneralStatus, GeneralStatusDto> service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

	private static final ZoneId zoneId = ZoneId.of("Asia/Bangkok");

	@Autowired
	private IGeneralStatusService iGeneralStatusService;

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody CreateGeneralStatusDto model) {
		GeneralStatusDto generalStatusDto = new GeneralStatusDto();

		// Get the current timestamp in a specific time zone
		ZonedDateTime curenZoneTime = ZonedDateTime.now(zoneId);

		// Convert ZonedDateTime to Timestamp
		Timestamp currTimestamp = Timestamp.from(curenZoneTime.toInstant());

		generalStatusDto.setGenStatusCode(model.getGenStatusCode());
		generalStatusDto.setGenStatusTitle(model.getGenStatusTitle());
		generalStatusDto.setDateOfCreate(currTimestamp);
		generalStatusDto.setDateOfUpdate(null);

		GeneralStatus generalStatus = iGeneralStatusService.convertDtoToEntity(generalStatusDto);
		GeneralStatus statusCreated = iGeneralStatusService.create(generalStatus);
		return ResponseEntity.status(HttpStatus.CREATED).body(statusCreated);
	}
}
