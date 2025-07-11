package Bayi;

import Bayi.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import Bayi.service.CustomerService;
import java.util.List;

@SpringBootApplication
public class BayiApplication {

	@Autowired
	CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(BayiApplication.class, args);
		ApplicationContext context = SpringApplication.run(BayiApplication.class, args);

		CustomerService customerService = context.getBean(CustomerService.class);


		List<Customer> customers = customerService.findAllCustomers();


		customers.forEach(customer -> System.out.println(customer));
	}

}

