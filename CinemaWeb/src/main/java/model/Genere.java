package model;

import java.util.List;

public class Genere {
	
	private Integer idGenere;
	private String nomeGenere;
	private List<Genere>generi;
	
	
	/**
	 * @return the generi
	 */
	public List<Genere> getGeneri() {
		return generi;
	}
	/**
	 * @param generi the generi to set
	 */
	public void setGeneri(List<Genere> generi) {
		this.generi = generi;
	}
	/**
	 * @return the idGenere
	 */
	public Integer getIdGenere() {
		return idGenere;
	}
	/**
	 * @param idGenere the idGenere to set
	 */
	public void setIdGenere(Integer idGenere) {
		this.idGenere = idGenere;
	}
	/**
	 * @return the nomeGenere
	 */
	public String getNomeGenere() {
		return nomeGenere;
	}
	/**
	 * @param nomeGenere the nomeGenere to set
	 */
	public void setNomeGenere(String nomeGenere) {
		this.nomeGenere = nomeGenere;
	}
	
	

}
