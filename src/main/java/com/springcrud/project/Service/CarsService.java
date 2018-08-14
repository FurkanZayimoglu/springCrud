package com.springcrud.project.Service;

import com.springcrud.project.Model.Cars;

import java.util.List;

public interface CarsService {

    List<Cars> getAll();

    Cars getId(int id);

    Cars saveCars(Cars cars);

    void delete(int id);

}
