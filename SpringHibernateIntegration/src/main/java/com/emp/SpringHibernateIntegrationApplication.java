package com.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SuppressWarnings("unused")
@SpringBootApplication
//@EnableTransactionManagement
public class SpringHibernateIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateIntegrationApplication.class, args);

		/*
		 Code to persist entities for non MVC application when we don't use controller
		 
		  
		ConfigurableApplicationContext appletContext = SpringApplication
				.run(SpringHibernateIntegrationApplication.class, args);
		EmployeeRepository repository = appletContext.getBean(EmployeeRepository.class);

		Address address = new Address();
		address.setCity("mumbai");
		address.setState("maharashtra");

		Employee employee = new Employee();
		employee.setName("anant");
		employee.setEmail("anant@gmail.com");

		address.setEmployee(employee);
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address);
		employee.setAddresses(addresses);
		
		repository.save(employee);
		
		*/
	}

}
