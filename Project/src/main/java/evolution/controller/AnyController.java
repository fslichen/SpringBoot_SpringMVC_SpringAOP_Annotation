package evolution.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import evolution.annotation.AnyAnnotation;

@AnyAnnotation
@RestController
public class AnyController {
	@GetMapping("/get/{parameter}")
	public String get(@PathVariable("parameter") String parameter) {
		return "The parameter is " + parameter + ".";
	}
}
