package com.codegym.tikistore.repository;

import com.codegym.tikistore.entitiy.product.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    @Query("SELECT c FROM Coupon c WHERE (c.expireDate IS NULL OR c.expireDate >= CURRENT_DATE) AND c.active = TRUE")
    List<Coupon> findAllActiveAndNotExpiredCoupons();

}
