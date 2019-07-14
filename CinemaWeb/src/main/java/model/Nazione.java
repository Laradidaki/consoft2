package model;

import java.util.List;

public class Nazione {
	
	private Integer idNazione;
	private String nomeNazione;
	private List<Nazione>nazioni;
	
	
	/**
	 * @return the nazioni
	 */
	public List<Nazione> getNazioni() {
		return nazioni;
	}
	/**
	 * @param nazioni the nazioni to set
	 */
	public void setNazioni(List<Nazione> nazioni) {
		this.nazioni = nazioni;
	}
	/**
	 * @return the idNazione
	 */
	public Integer getIdNazione() {
		return idNazione;
	}
	/**
	 * @param idNazione the idNazione to set
	 */
	public void setIdNazione(Integer idNazione) {
		this.idNazione = idNazione;
	}
	/**
	 * @return the nomeNazione
	 */
	public String getNomeNazione() {
		return nomeNazione;
	}
	/**
	 * @param nomeNazione the nomeNazione to set
	 */
	public void setNomeNazione(String nomeNazione) {
		this.nomeNazione = nomeNazione;
	}
	
	

}
