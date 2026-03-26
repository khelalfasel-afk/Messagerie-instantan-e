package com.example.de.copy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
@RestController
public class MainController {



	  @GetMapping("/check")
	public void getIndexService() {
	    // قم بتنفيذ الخدمة المطلوبة هنا
	    System.out.println("Request for index service received.");
	}
    
    @GetMapping("/styles")
    public String getIndex() {
        return "style.css";
    }
    @GetMapping("/error")
    public String handleError() {
        return "error.html";}
    
}