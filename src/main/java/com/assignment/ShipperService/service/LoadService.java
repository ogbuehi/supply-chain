package com.assignment.ShipperService.service;

import com.assignment.ShipperService.dto.LoadDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LoadService {
    ResponseEntity<String> addLoad(LoadDto loadDto);
    ResponseEntity<List<LoadDto>> findLoadsByShipperId(Integer shipperId);
    ResponseEntity<LoadDto> findLoadById(Integer id);
    ResponseEntity<String> updateLoadById(Integer id);
    ResponseEntity<String> deleteLoadById(Integer id);
}
