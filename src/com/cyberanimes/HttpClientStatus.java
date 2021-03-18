package com.cyberanimes;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;

public class HttpClientStatus {
	
	public void adicionar(String site) throws MalformedURLException, IOException {
		AcoesBanco banco = new AcoesBanco();
		System.out.println(site);
		Document doc = Jsoup.parse(new URL(site), 500000);
		String nome = doc.select(".color-change").first().text();
		String img_anime = doc.select("#capaAnime").select("img").attr("src");
		int id_anime = banco.adicionaAnime(nome, null, img_anime);

		Elements links = doc.select("#content2").select(".contentBox").select("ul").select("li");
		for (org.jsoup.nodes.Element element : links) {
			String url = element.select(".btn-online").attr("href");
			Document doc_ep = Jsoup.parse(new URL(url), 500000);
			String strHTML = doc_ep.html();

			int nURLStart  = strHTML.indexOf("file\": ");
			int nURLEnd    = strHTML.indexOf("}", nURLStart);

			String strURL  = strHTML.substring(nURLStart+8, nURLEnd-1);
			String img = element.select("img").attr("src");
			banco.adicionaEP(id_anime, img, strURL);
		}
		banco.close();
	}
}