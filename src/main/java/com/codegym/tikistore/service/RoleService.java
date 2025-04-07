package com.codegym.tikistore.service;

import com.codegym.tikistore.dto.RoleDTO;

import java.util.Optional;

public interface RoleService {
    Optional<RoleDTO> findById(Long id);
}
