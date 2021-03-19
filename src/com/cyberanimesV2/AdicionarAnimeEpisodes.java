package com.cyberanimesV2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class AdicionarAnimeEpisodes {
	public AdicionarAnimeEpisodes(String site) throws MalformedURLException, IOException {
		Banco banco = new Banco();
		Document doc = Jsoup.parse(new URL(site), 500000);
		String nome = doc.select(".color-change").first().text();
		String img_anime = doc.select("#capaAnime").select("img").attr("src");
		int id_anime = banco.adicionaAnime(nome, null, img_anime);

		Elements links = doc.select("#content2").select(".contentBox").select("ul").select("li");
		for (org.jsoup.nodes.Element element : links) {
			String url = element.select(".btn-online").attr("href");
			Document doc_ep = Jsoup.parse(new URL(url), 50000);
			String[] ep_split = url.split("-");
			String nome_ep = ep_split[ep_split.length - 1];
			nome_ep = nome_ep.replaceAll("/", "");	
			String img = element.select("img").attr("src");
			if(doc_ep.select("video").select("source").attr("src") != ""){
				System.out.println("batata 1");

				url = doc_ep.select("video").select("source").attr("src");
				banco.adicionaEP(Integer.parseInt(nome_ep), img, url, id_anime, "1");
			}else {
				String strHTML = doc_ep.html();
				int nURLStart  = strHTML.indexOf("file\": ");
				int nURLEnd    = strHTML.indexOf("}", nURLStart);
				System.out.println("batata 2");
				String strURL  = strHTML.substring(nURLStart+8, nURLEnd-1);
				banco.adicionaEP(Integer.parseInt(nome_ep), img, strURL, id_anime, "2");
			}
			
		}
		banco.close();
	}
}
