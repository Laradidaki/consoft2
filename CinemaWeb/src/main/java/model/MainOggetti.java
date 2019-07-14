package model;

public class MainOggetti {

	public static void main(String[] args) {

		Attore att= new Attore();
		att.setIdAttore(17);
		att.setNomeAttore("James");
		att.setCognomeAttore("McAvoy");
		att.setEtaAttore(40);
		
		Attore att1= new Attore();
		att1.setIdAttore(18);
		att1.setNomeAttore("Rachel");
		att1.setCognomeAttore("Weisz");
		att1.setEtaAttore(49);
		
		Film movie= new Film();
		movie.setIdFilm(22);
		movie.setNomeFilm("Split");
		movie.setDurataFilm("116");
		movie.setAnnoFilm(2016);
		movie.setCostoFilm(9.000000);
		
		Film movie1= new Film();
		movie1.setIdFilm(23);
		movie1.setNomeFilm("The Mummy");
		movie1.setDurataFilm("120");
		movie1.setAnnoFilm(1999);
		movie1.setCostoFilm(41.0000000);
		
		Regista regista= new Regista();
		regista.setIdRegista(17);
		regista.setCognomeRegista("Tarantino");
		regista.setNomeRegista("Quentin");
		regista.setEtaRegista(56);
		
		Regista regista1= new Regista();
		regista1.setIdRegista(18);
		regista1.setCognomeRegista("Kurtzman");
		regista1.setNomeRegista("Alex");
		regista1.setEtaRegista(45);
		
		movie.addAttore(att);
		movie.addAttore(att1);
		movie.addRegista(regista);
		movie.addRegista(regista1);
		
	}

}
