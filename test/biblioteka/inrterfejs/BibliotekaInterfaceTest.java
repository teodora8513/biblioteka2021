package biblioteka.inrterfejs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import biblioteka.Knjiga;
import java.util.List;

public abstract class BibliotekaInterfaceTest {

	protected BibliotekaInterface biblioteka;
	
	@Test
	void testDodajKnjiga() {
		Knjiga k = new Knjiga();
		k.setNaslov("Knjiga 1");
		
		biblioteka.dodajKnjiga(k);
		
		assertEquals(1, biblioteka.vratiSveKnjige().size());//Testiramo da li je ubaceno jos nesto
		assertEquals(k, biblioteka.vratiSveKnjige().get(0));
	}

	@Test
	void testDodajKnjigaNull() {
		assertThrows(java.lang.NullPointerException.class, () -> biblioteka.dodajKnjiga(null));
	}
	
	@Test
	void testDodajKnjigaDuplikat() {
		Knjiga k = new Knjiga();
		k.setIsbn("1233");
		Knjiga k2 = new Knjiga();
		k2.setIsbn("1233");
		
		biblioteka.dodajKnjiga(k);
		RuntimeException e = assertThrows( java.lang.RuntimeException.class, () -> biblioteka.dodajKnjiga(k2));
		assertEquals("Knjiga vec postoji", e.getMessage());		//Proverava da li exception baca dobru poruku
	}
	
	@Test
	void testObrisiKnjigu() {
		Knjiga k = new Knjiga();
		k.setIsbn("1233");
		biblioteka.dodajKnjiga(k);
		biblioteka.obrisiKnjigu(k);
		
		assertEquals(0, biblioteka.vratiSveKnjige().size());
	}
	
	@Test
	void testObrisiKnjiguNull() {
		assertThrows(java.lang.RuntimeException.class , () -> biblioteka.obrisiKnjigu(null));
	}

	@Test
	void testObrisiKnjiguNePostoji() {
		Knjiga k = new Knjiga();
		k.setIsbn("1233");
		biblioteka.dodajKnjiga(k);
		biblioteka.obrisiKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn("234");
		
		assertThrows(java.lang.RuntimeException.class , () -> biblioteka.obrisiKnjigu(k2));
			}
	
	@Test
	void testVratiSveKnjige() {
		Knjiga k = new Knjiga();
		k.setIsbn("1233");
		biblioteka.dodajKnjiga(k);
		List<Knjiga> knjige = biblioteka.vratiSveKnjige();
		
		assertEquals(1, knjige.size());
		assertEquals(k, knjige.get(0));
	}

	@Test
	void testPronadjiKnjiguNull() {
		assertThrows(java.lang.RuntimeException.class , () -> biblioteka.pronadjiKnjigu(null, null, null, null));
	}

	@Test
	void testPronadjiKnjigu() {
		Knjiga k = new Knjiga();
		k.setIsbn("322");
		k.setNaslov("Avatar i dzungla");
		Knjiga k1 = new Knjiga();
		k1.setIsbn("3242");
		k1.setNaslov("Miki i Mini");
		Knjiga k2 = new Knjiga();
		k2.setIsbn("3223");
		k2.setNaslov("Knjiga o dzungli");
		
		biblioteka.dodajKnjiga(k);
		biblioteka.dodajKnjiga(k1);
		biblioteka.dodajKnjiga(k2);
		
		List<Knjiga> rezultat = biblioteka.pronadjiKnjigu(null, null, "zung", null);
		
		assertEquals(
				2,  rezultat.size());
		assertTrue(rezultat.contains(k2));
		assertTrue(rezultat.contains(k));
		
	}
	
}
