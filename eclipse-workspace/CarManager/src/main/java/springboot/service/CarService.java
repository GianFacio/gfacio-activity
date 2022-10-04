package springboot.service;

import java.util.List;

import springboot.entity.Car;

public interface CarService {
	List<Car> getAllCars();
	
	Car saveCar(Car car);
	
	Car getCarById(Long id);
	
	Car updateCar(Car car);
	
	void deleteCarById(Long id);
}
