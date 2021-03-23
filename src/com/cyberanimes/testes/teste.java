package com.cyberanimes.testes;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cyberanimes.*;
import com.cyberanimesV2.AdicionarAnimeEpisodes;
import com.cyberanimesV2.Banco;

public class teste {

	public static void main(String[] args) throws MalformedURLException, IOException, SQLException {

//			Banco banco = new Banco();
//			banco.deletaAnime();
//			banco.deletaEp();
//			banco.close();

//			new AdicionarAnimeEpisodes("https://yayanimes.net/kono-subarashii-sekai-ni-shukufuku-wo/");
//			new AdicionarAnimeEpisodes("https://yayanimes.net/tatoeba-last-dungeon-mae-no-mura-no-shounen-ga-joban-no-machi-de-kurasu-youna-monogatari/");
//			new AdicionarAnimeEpisodes("https://yayanimes.net/kaifuku-jutsushi-no-yarinaoshi/");
		new AdicionarAnimeEpisodes("https://yayanimes.net/beastars-2/");
//		AdicionarAnimeEpisodes atualizar = new AdicionarAnimeEpisodes();
//		atualizar.AtualizarUrlEp();   
		
		
		
		System.out.println("FIM");

	}

}
