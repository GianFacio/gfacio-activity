package springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import springboot.entity.Car;
import springboot.repository.CarRepository;
import springboot.service.CarService;

@Service
public class CarServiceImpl implements CarService
{

	private CarRepository carRepository;
	
	public CarServiceImpl(CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}

	@Override
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

	@Override
	public Car saveCar(Car car) {
		return carRepository.save(car);
	}

	@Override
	public Car getCarById(Long id) {
		return carRepository.findById(id).get();
	}

	@Override
	public Car updateCar(Car car) {
		return carRepository.save(car);
	}

	@Override
	public void deleteCarById(Long id) {
		carRepository.deleteById(id);	
	}

}
