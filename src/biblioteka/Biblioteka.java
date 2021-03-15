package biblioteka;

import java.util.LinkedList;
import java.util.List;

import biblioteka.inrterfejs.BibliotekaInterface;
/**
 * Ova klasa implementira interfejs BibliotekaInterfejs
 */
public class Biblioteka implements BibliotekaInterface {

	/**
	 * Lista sa svim knjigama u biblioteci
	 */
	//Head i druga verzija se razlikuju po komentarima i znakovima <<<<<<< i ======
	private  List<Knjiga> knjige = new LinkedList<>();
	
	@Override
	public void dodajKnjiga(Knjiga knjiga) {

		if(knjiga==null)
			throw new NullPointerException("NE sme biti null");
		if(knjige.contains(knjiga))
			throw new RuntimeException("Knjiga vec postoji");
 
		knjige.add(knjiga); 
		
  
	}

	
	
	@Override
	public LinkedList<Knjiga> vratiSveKnjige() {
		return (LinkedList<Knjiga>) knjige;
	}

	@Override
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavac) {

		if(autor == null && isbn==null && naslov==null && izdavac ==null)
			throw new RuntimeException("Mora da se unese bar jedan kriterijum pretrage");

		List<Knjiga> rezultat = new LinkedList<>();
		for (Knjiga knjiga : knjige) {
			if(knjiga.getNaslov().contains(naslov))
				rezultat.add(knjiga);
		}
		
		return (LinkedList<Knjiga>) rezultat;
	}



	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		if(knjiga==null || !knjige.contains(knjiga))
			throw new RuntimeException("Knjiga ne sme biti null  i mora postojati u biblioteci");
		knjige.remove(knjiga);
		
	}

}
