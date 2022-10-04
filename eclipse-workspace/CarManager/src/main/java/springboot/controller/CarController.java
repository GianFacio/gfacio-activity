package springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import springboot.entity.Car;
import springboot.service.CarService;

@Controller
public class CarController {
	
	private CarService carService;

	public CarController(CarService carService) {
		super();
		this.carService = carService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/cars")
	public String listCars(Model model) {
		model.addAttribute("cars", carService.getAllCars());
		return "cars";
	}
	
	@GetMapping("/cars/new")
	public String createCarForm(Model model) {
		
		// create student object to hold student form data
		Car car = new Car();
		model.addAttribute("car", car);
		return "create_car";
		
	}
	
	@PostMapping("/cars")
	public String saveCar(@ModelAttribute("car") Car car) {
		carService.saveCar(car);
		return "redirect:/cars";
	}
	
	@GetMapping("/cars/edit/{id}")
	public String editCarForm(@PathVariable Long id, Model model) {
		model.addAttribute("car", carService.getCarById(id));
		return "edit_car";
	}

	@PostMapping("/cars/{id}")
	public String updateCar(@PathVariable Long id,
			@ModelAttribute("car") Car car,
			Model model) {
		
		// get student from database by id
		Car existingCar = carService.getCarById(id);
		existingCar.setId(id);
		existingCar.setMake(car.getMake());
		existingCar.setModel(car.getModel());
		existingCar.setColor(car.getColor());
		
		// save updated student object
		carService.updateCar(existingCar);
		return "redirect:/cars";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/cars/{id}")
	public String deleteCar(@PathVariable Long id) {
		carService.deleteCarById(id);
		return "redirect:/cars";
	}
	
}
