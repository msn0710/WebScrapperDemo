package com.example.demo.Scrapping;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class Scrapper {
	private Elements links;

	public void getLinks(String url) {
		Document doc;
		String uri = "https://" + url;

		try {
			doc = Jsoup.connect(uri).get();
			Element content = doc.getElementById("content");
			links = content.getElementsByTag("a");
			for (Element link : links) {
				String linkHref = link.attr("abs:href");
				String linkText = link.text();
				System.out.println("Text: " + linkText + "\n URL: " + linkHref);

			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void fetchImages(String url) {
		Document doc;
		String uri = "https://" + url;
		try {
			doc = Jsoup.connect(uri).get();
			Elements imageElements = doc.select("img");

			for (Element imageElement : imageElements) {

				String strImageURL = imageElement.attr("abs:src");
				System.out.println(strImageURL);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	// For fetching articles of website
	// "https://www.theguardian.com/politics/2020/jan/17/emily-thornberry-warns-"

	/*
	 * public void fetchArticle() { Document doc; try { doc = Jsoup.connect(
	 * "https://www.theguardian.com/politics/2020/jan/17/emily-thornberry-warns-unions-dont-close-the-gates-to-labours-would-be-leaders")
	 * .get(); //Elements elements =
	 * doc.getElementsByClass("content__headline-standfirst-wrapper");
	 * 
	 * Elements els = doc.select("div.content__headline-standfirst-wrapper > div");
	 * 
	 * for (Element element : els) { System.out.println(element.text()); }
	 * 
	 * Elements articles = doc.select("div.content__article-body > p"); for (Element
	 * element : articles) { System.out.println(element.text()); }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * catch (Exception e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * } }
	 */

	public void fetchArticle() {
		Document doc;
		try {
			doc = Jsoup.connect(
					"https://www.scotsman.com/news/opinion/columnists/why-labour-s-jess-phillips-is-perfect-choice-to-read-immortal-memory-at-burns-supper-susan-dalgety-1-5076677")
					.get();

			Elements heading = doc.getElementsByClass("article-header__title");
			System.out.println(heading.text());

			Elements article = doc.select("div.p402_premium > p");
			for (Element e : article) {
				System.out.println(e.text());
			}

		} catch (Exception e) {

		}

	}

}
