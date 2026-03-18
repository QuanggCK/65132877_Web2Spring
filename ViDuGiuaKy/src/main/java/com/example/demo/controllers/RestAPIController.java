package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPIController {
	@Autowired
	PageService pService;

	@GetMapping("/restAPI/page/all")
	public List<Page> getAllPage() {
		List<Page> dsTrang = new ArrayList<Page>();
		dsTrang = pService.getAllPage();
		return dsTrang;
	}
}
