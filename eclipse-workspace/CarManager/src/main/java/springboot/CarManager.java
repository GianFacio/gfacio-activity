package springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import springboot.entity.Car;
import springboot.repository.CarRepository;

@SpringBootApplication
public class CarManager implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CarManager.class, args);
	}

	@Autowired
	private CarRepository studentRepository;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(String... args) throws Exception 
	{
		String sql = "INSERT INTO car (id, make, model, color, year) VALUES (?, ?, ?, ?, ?)";
        
        int result = jdbcTemplate.update(sql, "2","Mercedes Benz", "C300", "Red", "2023");
         
        if (result > 0) {
            System.out.println("A new row has been inserted.");
        }

	}

}
