package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

}
