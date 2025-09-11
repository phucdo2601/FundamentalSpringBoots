package com.web.phucdn.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.web.phucdn.dto.GeneralCouponDto;
import com.web.phucdn.models.GeneralCoupon;
import com.web.phucdn.services.BaseService;
import com.web.phucdn.services.IGeneralCouponService;

@RestController
@RequestMapping("/api/v1/generalCoupon")
public class GeneralCouponController extends BaseController<GeneralCoupon, GeneralCouponDto, IGeneralCouponService>{

    public GeneralCouponController(BaseService<GeneralCoupon, GeneralCouponDto> service) {
        super(service);
    }
}
