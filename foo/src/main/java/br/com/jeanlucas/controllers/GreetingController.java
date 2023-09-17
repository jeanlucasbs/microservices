package br.com.jeanlucas.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.jeanlucas.confi.GreetingConfiguration;
import br.com.jeanlucas.model.Greeting;

@RestController
public class GreetingController {

	@Autowired
	private GreetingConfiguration configuration;
	
	private static final String template = "%s, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue = "") String name) {
		
		if(name.isEmpty()) name = configuration.getDefaultValue();
		
		return new Greeting(counter.incrementAndGet(), String.format(template, configuration.getGreeting(), name));
	}
}
