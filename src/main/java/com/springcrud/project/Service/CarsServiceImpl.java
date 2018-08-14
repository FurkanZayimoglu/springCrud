package com.springcrud.project.Service;

import com.springcrud.project.Model.Cars;
import com.springcrud.project.Repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {


    @Autowired
    CarsRepository carsRepository;



    @Override
    public List<Cars> getAll() {
        return carsRepository.findAll();
    }

    @Override
    public Cars getId(int id) {
        return carsRepository.getOne(id);
    }

    @Override
    public Cars saveCars(Cars cars) {
        return carsRepository.save(cars);
    }

    @Override
    public void delete(int id) {
        carsRepository.deleteById(id);

    }
}
