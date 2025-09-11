package com.web.phucdn.dto.request;
import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateGeneralCouponDto implements Serializable{
    private String genCouCode;
	private String genCouTitle;
	private Float value;
	private String unitOfValue;
	private Timestamp dateOfCreate;
	private Timestamp dateOfBegin;
	private Timestamp dateOfEnd;
	private Timestamp dateOfUpdate;
	private String statusId;
    private String couponGeneralTypeId;
}
