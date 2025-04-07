package com.codegym.tikistore.service;

import com.codegym.tikistore.dto.SpecificationTemplateDTO;

import java.util.List;

/**
 * @author ADMIN
 */
public interface SpecificationTemplateService {

    List<SpecificationTemplateDTO> getSpecTemplatesByCategory(String categoryName);
}
