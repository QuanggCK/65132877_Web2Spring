package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageService {
	@Autowired
	PageRepository rRepos;
 // Dịch vụ lấy về tất cả các trang
	List<Page> getAllPage(){
		return rRepos.findAll();
	}
}
