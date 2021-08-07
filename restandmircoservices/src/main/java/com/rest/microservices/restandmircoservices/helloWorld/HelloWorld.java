package com.rest.microservices.restandmircoservices.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	@GetMapping(path="/hello-world")
	public String helloWorld(){
		return "Hello World";
	}
	@GetMapping(path="/person-bean")
	public Person personBean(){
		return new Person("Usman");
	}
	//path variable
	@GetMapping(path="/person-bean/path-variable/{name}")
	public Person personBeanPathVariable(@PathVariable String name){
		return new Person(String.format("Usman, %s", name));
	}
	
	
}
