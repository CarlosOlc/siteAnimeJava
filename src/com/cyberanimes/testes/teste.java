package com.cyberanimes.testes;

import java.io.IOException;
import java.net.MalformedURLException;

import com.cyberanimes.*;
import com.cyberanimesV2.AdicionarAnimeEpisodes;
import com.cyberanimesV2.Banco;

public class teste {

	public static void main(String[] args) throws MalformedURLException, IOException {

//			Banco banco = new Banco();
			
			AdicionarAnimeEpisodes fun = new AdicionarAnimeEpisodes("https://yayanimes.net/dr-stone-stone-wars/");
//			banco.deletaAnime();
//			banco.deletaEp();
//			String teste = "aBBa";
			
			System.out.println("FIM");
	}

}
