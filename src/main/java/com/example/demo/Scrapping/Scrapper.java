package com.example.demo.Scrapping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class Scrapper {

	public void fetchArticle(String url) {
		Document doc;
		try {
			doc = Jsoup.connect(url).get();

			Element heading = doc.select("article h1").first();
			System.out.println(heading.text());

			Elements article = doc.select("article p");

			for (Element e : article) {
				System.out.println(e.text());
			}

		} catch (Exception e) {

		}

	}

}
