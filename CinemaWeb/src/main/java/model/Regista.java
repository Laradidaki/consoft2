package model;

import java.util.List;

public class Regista {

	private Integer idRegista;
	private String nomeRegista;
	private String cognomeRegista;
	private Integer etaRegista;
	private List<Regista>registi;
	
	
	/**
	 * @return the registi
	 */
	public List<Regista> getRegisti() {
		return registi;
	}
	/**
	 * @param registi the registi to set
	 */
	public void setRegisti(List<Regista> registi) {
		this.registi = registi;
	}
	/**
	 * @return the idRegista
	 */
	public Integer getIdRegista() {
		return idRegista;
	}
	/**
	 * @param idRegista the idRegista to set
	 */
	public void setIdRegista(Integer idRegista) {
		this.idRegista = idRegista;
	}
	/**
	 * @return the nomeRegista
	 */
	public String getNomeRegista() {
		return nomeRegista;
	}
	/**
	 * @param nomeRegista the nomeRegista to set
	 */
	public void setNomeRegista(String nomeRegista) {
		this.nomeRegista = nomeRegista;
	}
	/**
	 * @return the cognomeRegista
	 */
	public String getCognomeRegista() {
		return cognomeRegista;
	}
	/**
	 * @param cognomeRegista the cognomeRegista to set
	 */
	public void setCognomeRegista(String cognomeRegista) {
		this.cognomeRegista = cognomeRegista;
	}
	/**
	 * @return the etaRegista
	 */
	public Integer getEtaRegista() {
		return etaRegista;
	}
	/**
	 * @param etaRegista the etaRegista to set
	 */
	public void setEtaRegista(Integer etaRegista) {
		this.etaRegista = etaRegista;
	}
	
	
}
