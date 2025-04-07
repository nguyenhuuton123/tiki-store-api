package com.codegym.tikistore.service;

import com.codegym.tikistore.dto.CouponDTO;

import java.util.List;

public interface CouponService {
    List<CouponDTO> findAllActiveCoupon();
}
