package com.cyberanimesV2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AdicionarAnimeEpisodes {
	public AdicionarAnimeEpisodes() {

	}

	public AdicionarAnimeEpisodes(String site) throws MalformedURLException, IOException {
		Banco banco = new Banco();
		Document doc = Jsoup.parse(new URL(site), 10000);
		String nome = doc.select(".color-change").first().text();
		String img_anime = doc.select("#capaAnime").select("img").attr("src");
		int id_anime = banco.adicionaAnime(nome, site, img_anime);
		Elements links = doc.select("#content2").select(".contentBox").select("ul").select("li");
		for (org.jsoup.nodes.Element element : links) {
			new Thread() {

				@Override
				public void run() {
					String url = element.select(".btn-online").attr("href");
					String url_yay = url;
					Document doc_ep = null;
					try {
						doc_ep = Jsoup.parse(new URL(url), 50000);
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					String[] ep_split = url.split("-");
					String nome_ep = ep_split[ep_split.length - 1];
					nome_ep = nome_ep.replaceAll("/", "");
					String img = element.select("img").attr("src");
					if (doc_ep.select("video").select("source").attr("src") != "") {
						url = doc_ep.select("video").select("source").attr("src");
						banco.adicionaEP(Integer.parseInt(nome_ep), img, url, id_anime, "1", url_yay);
					} else {
						String strHTML = doc_ep.html();
						int nURLStart = strHTML.indexOf("file\": ");
						int nURLEnd = strHTML.indexOf("}", nURLStart);
						String strURL = strHTML.substring(nURLStart + 8, nURLEnd - 1);
						banco.adicionaEP(Integer.parseInt(nome_ep), img, strURL, id_anime, "2", url_yay);
					}
				}
			}.start();
		}
		banco.close();
	}

	public void AtualizarUrlEp() throws MalformedURLException, IOException, SQLException {
		Banco banco = new Banco();
		ResultSet resultset = banco.getEp();
		while(resultset.next()) {
			System.out.println("aaa");
			System.out.println(resultset.getString("url_yay"));
			String url = null;
			String number_ep = banco.getIdUrl(resultset.getString("url_yay"));
			System.out.println(number_ep);
			String id = banco.getIdUrl(resultset.getString("fk_anime"));
			System.out.println(id);
			Document doc_ep = Jsoup.parse(new URL(resultset.getString("url_ep")), 50000);
			if (doc_ep.select("video").select("source").attr("src") != "") {
				url = doc_ep.select("video").select("source").attr("src");
				banco.atualizarUrl(id, url, number_ep);
			} else {
				String strHTML = doc_ep.html();
				int nURLStart = strHTML.indexOf("file\": ");
				int nURLEnd = strHTML.indexOf("}", nURLStart);
				String strURL = strHTML.substring(nURLStart + 8, nURLEnd - 1);
				banco.atualizarUrl(id, strURL, number_ep);
			}
		}
		banco.close();
	}
}
