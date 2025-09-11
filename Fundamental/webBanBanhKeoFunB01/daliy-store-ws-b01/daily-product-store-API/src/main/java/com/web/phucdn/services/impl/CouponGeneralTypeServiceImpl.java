package com.web.phucdn.services.impl;

import java.time.ZoneId;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.phucdn.dto.CouponGeneralTypeDto;
import com.web.phucdn.models.CouponGeneralType;
import com.web.phucdn.repositories.BaseRepository;
import com.web.phucdn.repositories.CouponGeneralTypeRepository;
import com.web.phucdn.services.ICouponGeneralTypeService;

@Service
public class CouponGeneralTypeServiceImpl implements ICouponGeneralTypeService{

    @Autowired
    private CouponGeneralTypeRepository couponGeneralTypeRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final ZoneId ZONE_ID = ZoneId.of("Asia/Bangkok");

    @Override
    public BaseRepository<CouponGeneralType> getRepository() {
        return couponGeneralTypeRepository;
    }

    @Override
    public CouponGeneralTypeDto convertEntityToDto(CouponGeneralType t) {
        // set up for model mapper for adapt number
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        CouponGeneralTypeDto couponGeneralTypeDto = new CouponGeneralTypeDto();
        couponGeneralTypeDto = modelMapper.map(t, CouponGeneralTypeDto.class);
        return couponGeneralTypeDto;
    }

    @Override
    public CouponGeneralType convertDtoToEntity(CouponGeneralTypeDto c) {
        // set up for model mapper for adapt number
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        CouponGeneralType couponGeneralType = new CouponGeneralType();
        couponGeneralType = modelMapper.map(c, CouponGeneralType.class);
        return couponGeneralType;
    }
}
