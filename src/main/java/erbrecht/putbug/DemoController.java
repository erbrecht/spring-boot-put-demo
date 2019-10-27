package erbrecht.putbug;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class DemoController {
	private Logger logger = Logger.getLogger(DemoController.class.getName());

	@GetMapping
	public String showForm() {
		return "form";
	}

	@PostMapping("/post")
	public ResponseEntity<String> handlePost(@RequestParam String value) {
		logger.log(Level.INFO, "POST: " + value);
		return ResponseEntity.ok(value);
	}

	@PutMapping("/put")
	ResponseEntity<String> handlePut(@RequestParam String value) {
		logger.log(Level.INFO, "PUT: " + value);
		return ResponseEntity.ok(value);
	}
}
