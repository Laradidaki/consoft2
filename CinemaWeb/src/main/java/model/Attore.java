package model;

import java.util.List;

public class Attore {

	private Integer idAttore;
	private String nomeAttore;
	private String cognomeAttore;
	private int etaAttore;
	private List<Attore>attori;
	
	
	/**
	 * @return the attori
	 */
	public List<Attore> getAttori() {
		return attori;
	}
	/**
	 * @param attori the attori to set
	 */
	public void setAttori(List<Attore> attori) {
		this.attori = attori;
	}
	/**
	 * @return the idAttore
	 */
	public Integer getIdAttore() {
		return idAttore;
	}
	/**
	 * @param idAttore the idAttore to set
	 */
	public void setIdAttore(Integer idAttore) {
		this.idAttore = idAttore;
	}
	/**
	 * @return the nomeAttore
	 */
	public String getNomeAttore() {
		return nomeAttore;
	}
	/**
	 * @param nomeAttore the nomeAttore to set
	 */
	public void setNomeAttore(String nomeAttore) {
		this.nomeAttore = nomeAttore;
	}
	/**
	 * @return the cognomeAttore
	 */
	public String getCognomeAttore() {
		return cognomeAttore;
	}
	/**
	 * @param cognomeAttore the cognomeAttore to set
	 */
	public void setCognomeAttore(String cognomeAttore) {
		this.cognomeAttore = cognomeAttore;
	}
	/**
	 * @return the etaAttore
	 */
	public int getEtaAttore() {
		return etaAttore;
	}
	/**
	 * @param string the etaAttore to set
	 */
	public void setEtaAttore(int etaAttore) {
		this.etaAttore = etaAttore;
	}
	
	
}
