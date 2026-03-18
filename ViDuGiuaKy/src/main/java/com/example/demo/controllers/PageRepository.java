package com.example.demo.controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.controllers.Page;

public interface PageRepository extends JpaRepository<Page, String>{

}
  