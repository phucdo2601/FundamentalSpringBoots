package com.web.phucdn.services.impl;

import java.time.ZoneId;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.phucdn.dto.GeneralCouponDto;
import com.web.phucdn.models.GeneralCoupon;
import com.web.phucdn.repositories.BaseRepository;
import com.web.phucdn.repositories.GeneralCouponRepository;
import com.web.phucdn.services.IGeneralCouponService;

@Service
public class GeneralCouponServiceImpl implements IGeneralCouponService{

    @Autowired
    private GeneralCouponRepository generalCouponRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final ZoneId ZONE_ID = ZoneId.of("Asia/Bangkok");

    @Override
    public BaseRepository<GeneralCoupon> getRepository() {
        // TODO Auto-generated method stub
        return generalCouponRepository;
    }

    @Override
    public GeneralCouponDto convertEntityToDto(GeneralCoupon t) {
        // set up for model mapper for adapt number
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        GeneralCouponDto generalCouponDto = new GeneralCouponDto();
        generalCouponDto = modelMapper.map(t, GeneralCouponDto.class);
        return generalCouponDto;
    }

    @Override
    public GeneralCoupon convertDtoToEntity(GeneralCouponDto c) {
        // set up for model mapper for adapt number
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        GeneralCoupon generalCoupon = new GeneralCoupon();
        generalCoupon = modelMapper.map(c, GeneralCoupon.class);
        return generalCoupon;
    }
}
