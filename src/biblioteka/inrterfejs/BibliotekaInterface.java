package biblioteka.inrterfejs;

import java.util.LinkedList;

import biblioteka.Autor;
import biblioteka.Knjiga;

public interface BibliotekaInterface {
	/**
	 * Interfejs koji predstavlja biblioteku
	 * 
	 * @author Teodora
	 * 
	 *         Dodaje novu knjigu u biblioteku
	 * @param knjiga
	 *            koja se dodaje
	 * @throws java.lang.NullPointerException
	 *             ako je uneta knjiga null
	 * @throws java.lang.RuntimeException
	 *             ako je uneta knjiga vec postoji u biblioteci
	 */
	public void dodajKnjiga(Knjiga knjiga);

	/**
	 * Brise knjigu
	 * 
	 * @param knjiga
	 *            koja se brise
	 */
	public void obrisiKnjigu(Knjiga knjiga);

	public LinkedList<Knjiga> vratiSveKnjige();

	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavac);
}
