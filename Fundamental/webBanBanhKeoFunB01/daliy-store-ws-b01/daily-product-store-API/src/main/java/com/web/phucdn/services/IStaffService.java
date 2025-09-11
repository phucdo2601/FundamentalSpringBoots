package com.web.phucdn.services;

import com.web.phucdn.dto.StaffDto;
import com.web.phucdn.dto.request.CreateStaffReqDto;
import com.web.phucdn.dto.response.StaffInfoResDto;
import com.web.phucdn.models.Staff;

public interface IStaffService extends BaseService<Staff, StaffDto> {
	public StaffInfoResDto createNewStaff(CreateStaffReqDto model);
}
