package com.codegym.tikistore.service.impl;

import com.codegym.tikistore.dto.CouponDTO;
import com.codegym.tikistore.entitiy.product.Coupon;
import com.codegym.tikistore.repository.CouponRepository;
import com.codegym.tikistore.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {
    private final CouponRepository couponRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CouponDTO> findAllActiveCoupon() {
        List<Coupon> coupons = couponRepository.findAllActiveAndNotExpiredCoupons();
        return coupons.stream()
                .map(coupon -> modelMapper.map(coupon, CouponDTO.class))
                .collect(Collectors.toList());
    }
}
