package com.assignment.ShipperService.service;

import com.assignment.ShipperService.dao.LoadDao;
import com.assignment.ShipperService.dto.LoadDto;
import com.assignment.ShipperService.model.Load;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoadServiceImpl implements LoadService {

    @Autowired
    private LoadDao loadDao;

    @Override
    public ResponseEntity<String> addLoad(LoadDto loadDto) {
        Load load = new Load();
        BeanUtils.copyProperties(loadDto,load);
        loadDao.save(load);
        return new ResponseEntity<>("loads details added successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<LoadDto>> findLoadsByShipperId(Integer shipperId) {
        List<Load> loads = loadDao.findAllByShipperId(shipperId);
        List<LoadDto> dtoList = new ArrayList<>();
        BeanUtils.copyProperties(loads,dtoList);
        return null;
    }

    @Override
    public ResponseEntity<LoadDto> findLoadById(Integer id) {
        Optional<Load> load = loadDao.findById(id);
        LoadDto loadDto = new LoadDto();
        load.ifPresent(value -> BeanUtils.copyProperties(value, loadDto));
        return new ResponseEntity<>(loadDto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateLoadById(Integer id) {
        Optional<Load> load = loadDao.findById(id);
        load.ifPresent(value -> loadDao.save(value));
        return new ResponseEntity<>("load details updated successfully",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteLoadById(Integer id) {
        loadDao.deleteById(id);
        return new ResponseEntity<>("load details deleted successfully",HttpStatus.OK);
    }
}
