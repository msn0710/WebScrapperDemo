package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Scrapping.Scrapper;

@RestController
public class ScrapperController {

	@Autowired
	private Scrapper sc;

	@GetMapping("/link/{url}")
	public String getLinks(@PathVariable String url) {
		sc.getLinks(url);
		return "Your Request is submitted";
	}

	@GetMapping("/image/{url}")
	public String some(@PathVariable String url) {
		sc.fetchImages(url);
		return "Your Request is submitted";
	}

	@GetMapping("/article")
	public String getArticle() {
		sc.fetchArticle();
		return "Your Request is submitted";
	}

}
