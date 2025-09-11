package com.web.phucdn.helper;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.web.phucdn.dto.request.CreateCustomerReqDto;
import com.web.phucdn.dto.request.CreateStaffReqDto;
import com.web.phucdn.dto.request.CreateUserReqDto;
import com.web.phucdn.models.GeneralRole;
import com.web.phucdn.models.GeneralUserInfo;
import com.web.phucdn.repositories.GeneralRoleRepository;

@Component
public class GeneralHelper {

	private static GeneralRoleRepository generalRoleRepository;

	private static PasswordEncoder passwordEncoder;

	@Autowired
	public GeneralHelper(GeneralRoleRepository generalRoleRepository, PasswordEncoder passwordEncoder) {
		this.generalRoleRepository = generalRoleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public static Timestamp convertStringToTimeStaTimestamp(String strDate) {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			Date date = formatter.parse(strDate);
			Timestamp timestampDate = new Timestamp(date.getTime());

			return timestampDate;
		} catch (ParseException e) {
			System.out.println("Exception: " + e.getMessage());
			return null;
		}
	}

	public static Timestamp getcurrentTimeStamp(ZoneId zoneId) {
		// Get the current time zome in the specific time zone
		ZonedDateTime currentZoneTime = ZonedDateTime.now(zoneId);

		// Convert ZonedDatetime to Timestamp
		Timestamp currentTimestamp = Timestamp.from(currentZoneTime.toInstant());

		return currentTimestamp;
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
		String passwordDescrypt = passwordEncoder.encode(model.getPassword());
		generalUserInfo.setPassword(passwordDescrypt);
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
		String passwordEncrpyt = passwordEncoder.encode(model.getPassword());
		generalUserInfo.setFullName(model.getFullName());
		generalUserInfo.setUserName(model.getUserName());
		generalUserInfo.setPassword(passwordEncrpyt);
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
		String passwordDescrypt = passwordEncoder.encode(model.getPassword());
		generalUserInfo.setPassword(passwordDescrypt);
		generalUserInfo.setFullName(model.getFullName());
		generalUserInfo.setUserName(model.getUserName());
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
