package com.Apirest.errorManager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/error")
public class ErrorController {
	
	@GetMapping(path="/", produces={"application/json"})
	public String saludo(){
		String saludo = "You're not allowed to be here m8";
		return saludo;
	}
}
