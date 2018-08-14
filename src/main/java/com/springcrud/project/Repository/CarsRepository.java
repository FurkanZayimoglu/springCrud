package com.springcrud.project.Repository;

import com.springcrud.project.Model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Integer> {
}
