package com.assignment.ShipperService.controller;

import com.assignment.ShipperService.dto.LoadDto;
import com.assignment.ShipperService.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/load")
public class LoadController {

    @Autowired
    private LoadService loadService;

    @PostMapping("/add")
    public ResponseEntity<String> addLoad(@RequestBody LoadDto loadDto) {
        return loadService.addLoad(loadDto);
    }
    @GetMapping("/")
    public ResponseEntity<List<LoadDto>> findLoadsByShipperId(@RequestParam(value = "shipperId") Integer shipperId) {
        return loadService.findLoadsByShipperId(shipperId);
    }
    @GetMapping("/{loadId}")
    public ResponseEntity<LoadDto> findLoadById(@PathVariable("loadId") Integer id) {
        return loadService.findLoadById(id);
    }
    @PutMapping("/update/{loadId}")
    public ResponseEntity<String> updateLoadById(@PathVariable("loadId") Integer id) {
        return loadService.updateLoadById(id);
    }
    @DeleteMapping("/delete/{loadId}")
    public ResponseEntity<String> deleteLoadById(@PathVariable("loadId") Integer id) {
        return loadService.deleteLoadById(id);
    }
}
