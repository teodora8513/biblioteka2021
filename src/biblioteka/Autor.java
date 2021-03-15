package biblioteka;

public class Autor {
	/**
	 * Klasa koja predstavlja autore knjige
	 * 
	 * Autor ima ime i prezime kao String vrednosti.
	 * 
	 * @author Teodora
	 * @versio 0.1
	 * 
	 */
	/**
	 * Ime i prezime autora kao String
	 */
	private String ime;

	private String prezime;

	/**
	 * Bezparametarski konstruktor inicijalizuje objekat
	 */
	public Autor() {
		super();
	}

	/**
	 * Parametrizovani konstruktror
	 * 
	 * @param ime
	 *            Ime autora kao String
	 * @param prezime
	 *            Prezime autora kao String
	 */
	public Autor(String ime, String prezime) {
		super();
		setIme(ime);
		setPrezime(prezime);
	}

	/**
	 * Vraca ime autora.
	 * 
	 * @return Ime autora kao String
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Postavlja ime autora na novu vrednost
	 * 
	 * @param ime
	 *            Ime autora kao String
	 * 
	 * @throws java.lang.NullPointerException
	 *             ako je ime autora null
	 * @throws java.lang.RuntimeException
	 *             ako je ime autora manje od 2 znaka
	 */
	public void setIme(String ime) {
		if (ime == null)
			throw new NullPointerException("Ime ne sme biti null");

		if (ime.length() < 2)
			throw new RuntimeException("Ime mora imati vise od dva znaka");

		this.ime = ime;
	}

	/**
	 * Vraca prezime autora
	 * 
	 * @return Prezime autora kao String
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Postavlja prezime autora
	 * 
	 * @param prezime
	 *            Prezime autora kao string
	 * 
	 * @throws java.lang.NullPointerException
	 *             ako je prezime null
	 * @throws java.lang.RuntimeException
	 *             ako je prezime krace od 2 karaktera
	 */
	public void setPrezime(String prezime) {
		if (prezime == null)
			throw new NullPointerException("Prezime ne sme biti null");

		if (prezime.length() < 2)
			throw new RuntimeException("Prezime mora imati vise od dva znaka");

		this.prezime = prezime;
	}

	/**
	 * @return Vraca String sa svim podacima o auturu
	 * 
	 */
	public String toString() {
		return "Autor [ime=" + ime + ", prezime=" + prezime + "]";
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
		return result;
	}

	/**
	 * Poredi dva autora i vraca true ako su isti i false ako nisu. Autori se porede
	 * po imenu i prezimenu
	 * 
	 * @return
	 *         <ul>
	 *         <li>true ako su oba objekta klase Autor isto imenovani</li>
	 *         <li>u svim ostalim slucajevima</li>
	 *         </ul>
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		return true;
	}

}
