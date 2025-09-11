package com.web.phucdn.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.phucdn.dto.CouponGeneralTypeDto;
import com.web.phucdn.models.CouponGeneralType;
import com.web.phucdn.services.BaseService;
import com.web.phucdn.services.ICouponGeneralTypeService;

@RestController
@RequestMapping("/api/v1/couponGeneralType")
public class CouponGeneralTypeController
    extends BaseController<CouponGeneralType, CouponGeneralTypeDto, ICouponGeneralTypeService> {

    public CouponGeneralTypeController(BaseService<CouponGeneralType, CouponGeneralTypeDto> service) {
        super(service);
    }
}
