package com.example.demo.helper;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.request.CreateCustomerReqDto;
import com.example.demo.dto.request.CreateStaffReqDto;
import com.example.demo.dto.request.CreateUserReqDto;
import com.example.demo.models.GeneralRole;
import com.example.demo.models.GeneralUserInfo;
import com.example.demo.repositories.GeneralRoleRepository;

@Component
public class GeneralHelper {

	private static GeneralRoleRepository generalRoleRepository;

	@Autowired
	public GeneralHelper(GeneralRoleRepository generalRoleRepository) {
		this.generalRoleRepository = generalRoleRepository;
	}

	public static Date convertStringToTimeStaTimestamp(String strDate) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = formatter.parse(strDate);
			Date sqlDate = new Date(date.getTime());

			return sqlDate;
		} catch (ParseException e) {
			System.out.println("Exception: " + e.getMessage());
			return null;
		}
	}

	public static Date getcurrentTimeStamp(ZoneId zoneId) {
		// Get the current time zome in the specific time zone
		ZonedDateTime currentZoneTime = ZonedDateTime.now(zoneId);

		// Convert ZonedDateTime to LocalDate
		LocalDate localDate = currentZoneTime.toLocalDate();

		// Convert ZonedDatetime to Timestamp
		Date currentDate = Date.valueOf(localDate);

		return currentDate;
	}

	public static UUID convertStringToUUID(String id) {
		UUID uuid = null;

		try {
			uuid = UUID.fromString(id);
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid UUID String.");
		}
		return uuid;
	}

	public static GeneralUserInfo setUpDataOnGeneralUserInfo(CreateUserReqDto model, ZoneId zoneId) {
		GeneralUserInfo generalUserInfo = new GeneralUserInfo();
		generalUserInfo.setFullName(model.getFullName());
		generalUserInfo.setUserName(model.getUserName());
		generalUserInfo.setPassword(model.getPassword());
		generalUserInfo.setEmail(model.getEmail());
		generalUserInfo.setPhoneNumber(model.getPhoneNumber());
		generalUserInfo.setNationalId(model.getNationalId());
		generalUserInfo.setDateOfBirth(model.getDateOfBirth());
		generalUserInfo.setGender(model.getGender());
		generalUserInfo.setAddress(model.getAddress());

		UUID genRoleUuid = GeneralHelper.convertStringToUUID(model.getGenRoleId());

		GeneralRole generalRole = generalRoleRepository.findGeneralRoleByGenRoleId(genRoleUuid);
		generalUserInfo.setGeneralRole(generalRole);

		// estimate IsActive status is true - Before implementing send the activate
		// e-mail
		generalUserInfo.setActive(true);
		generalUserInfo.setDateOfCreate(getcurrentTimeStamp(zoneId));

		return generalUserInfo;
	}

	public static GeneralUserInfo setUpDataOnGenUserInfoOfCus(CreateCustomerReqDto model, ZoneId zoneId) {
		GeneralUserInfo generalUserInfo = new GeneralUserInfo();
		generalUserInfo.setFullName(model.getFullName());
		generalUserInfo.setUserName(model.getUserName());
		generalUserInfo.setPassword(model.getPassword());
		generalUserInfo.setEmail(model.getEmail());
		generalUserInfo.setPhoneNumber(model.getPhoneNumber());
		generalUserInfo.setNationalId(model.getNationalId());
		generalUserInfo.setDateOfBirth(model.getDateOfBirth());
		generalUserInfo.setGender(model.getGender());
		generalUserInfo.setAddress(model.getAddress());

		GeneralRole generalRole = generalRoleRepository.findCustomerRoleOfGenRole();
		generalUserInfo.setGeneralRole(generalRole);

		// estimate IsActive status is true - Before implementing send the activate
		// e-mail
		generalUserInfo.setActive(true);
		generalUserInfo.setDateOfCreate(getcurrentTimeStamp(zoneId));

		return generalUserInfo;
	}

	public static GeneralUserInfo setUpDataOnGenUserInfoOfStaff(CreateStaffReqDto model, ZoneId zoneId) {
		GeneralUserInfo generalUserInfo = new GeneralUserInfo();
		generalUserInfo.setFullName(model.getFullName());
		generalUserInfo.setUserName(model.getUserName());
		generalUserInfo.setPassword(model.getPassword());
		generalUserInfo.setEmail(model.getEmail());
		generalUserInfo.setPhoneNumber(model.getPhoneNumber());
		generalUserInfo.setNationalId(model.getNationalId());
		generalUserInfo.setDateOfBirth(model.getDateOfBirth());
		generalUserInfo.setGender(model.getGender());
		generalUserInfo.setAddress(model.getAddress());

		// Find role of for staff in the system
		GeneralRole generalRole = generalRoleRepository.findStaffRoleOfGenRole();
		generalUserInfo.setGeneralRole(generalRole);

		// estimate IsActive status is true - Before implementing send the activate
		// e-mail
		generalUserInfo.setActive(true);
		generalUserInfo.setDateOfCreate(getcurrentTimeStamp(zoneId));

		return generalUserInfo;

	}
}
