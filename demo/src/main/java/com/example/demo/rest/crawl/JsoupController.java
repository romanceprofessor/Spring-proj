package com.example.demo.rest.crawl;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsoupController {
	
	@GetMapping("/jsoup/test")
	public void test() throws IOException {
		Document doc = Jsoup.connect("https://www.netflix.com/kr-en/browse/genre/34399").get();
		System.out.println(doc);
		Elements list = doc.select(".nm-collections-title-img");
		for ( Element ele : list ) {
			String imgSrc = ele.attr("src");
			System.out.println(imgSrc);
		}
	}

}
