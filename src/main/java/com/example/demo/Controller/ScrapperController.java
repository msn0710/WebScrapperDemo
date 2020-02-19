package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Scrapping.Scrapper;

@RestController
public class ScrapperController {

	@Autowired
	private Scrapper sc;

	@GetMapping("/article/**")
	public String getArticle(HttpServletRequest request) {
		String url = request.getRequestURL().toString().split("/article/")[1];
		sc.fetchArticle(url);
		return "Your Request is submitted";
	}

}
