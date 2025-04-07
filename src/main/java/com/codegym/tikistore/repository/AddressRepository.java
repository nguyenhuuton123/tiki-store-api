package com.codegym.tikistore.repository;

import com.codegym.tikistore.entitiy.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
