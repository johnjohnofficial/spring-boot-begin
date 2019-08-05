package com.schoolofnet.SpringGradle.controller;

import com.schoolofnet.SpringGradle.model.Car;
import com.schoolofnet.SpringGradle.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public List<Car> findAll() {
        return this.carRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Car> findById(@PathVariable("id") Long id) {
        return this.carRepository.findById(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public Car create(@RequestBody Car car) {
        return this.carRepository.save(car);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Long id, @RequestBody Car car) {
        this.carRepository.findById(id).map(record -> {
            record.setName(car.getName());
            record.setColor(car.getColor());
            record.setYear(car.getYear());
            this.carRepository.save(record);
            return record;
        });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        this.carRepository.deleteById(id);
    }
}