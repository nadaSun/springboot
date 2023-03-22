package ma.cigma.springmvcrestdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import ma.cigma.springmvcrestdatajpa.SpringmvcRestDataJpaApplication;
import ma.cigma.springmvcrestdatajpa.domaine.EmpVo;

import ma.cigma.springmvcrestdatajpa.service.IService2;

@SpringBootApplication
public class SpringmvcRestDataJpaApplication extends SpringBootServletInitializer implements CommandLineRunner {
	@Autowired
	private IService2 service;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringmvcRestDataJpaApplication.class, args);
		System.out.println("Application démarrée");
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringmvcRestDataJpaApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {
		service.deleteAll();
		service.save(new EmpVo("name1", 8500d, "Technicien"));
		service.save(new EmpVo("name2", 8500d, "Technicien"));
		service.save(new EmpVo("name3", 8500d, "Chauffeur"));
		service.save(new EmpVo("name4", 8500d, "Comptable"));
		service.save(new EmpVo("name5", 10000d, "Comptable"));
		service.save(new EmpVo("name6", 15000d, "Chef de projet"));
		service.save(new EmpVo("name7", 17500d, "Responsable du service"));
		service.save(new EmpVo("name8", 10000d, "Comptable"));
	}

}
