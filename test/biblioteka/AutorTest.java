package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutorTest {

	Autor a;
	
	//Ova metoda se izvrsava pre svake metode
	@BeforeEach
	void setUp() throws Exception {
		 a = new Autor();
	}

	//Ova metoda se izvrsava posle svake metode
	@AfterEach
	void tearDown() throws Exception {
		a= null;
	}

	@Test
	void testAutor() {
		a = new Autor();
		assertNotNull(a);
	}

	@Test
	void testAutorStringString() {
		a = new Autor("Mika", "Mikic");
		assertNotNull(a);
		assertEquals("Mika", a.getIme());
		assertEquals("Mikic", a.getPrezime());
	}

	@Test
	void testSetIme() {
		Autor a = new Autor();
		a.setIme("Pera");
		assertEquals("Pera", a.getIme());
		
		
	}
	
	@Test
	@DisplayName("Testira ako je uneto null umesto imena")
	
	void testSetImeNull() {
		//Autor a = new Autor();
		
		//Klasa izuzetka koji treba da bazi
		assertThrows(java.lang.NullPointerException.class, ()-> a.setIme(null));
	}
	
	@Test
	@DisplayName("Testira duzinu imena")
	
	void testSetImeKRatakString() {
		//Autor a = new Autor();
		
		assertThrows(java.lang.RuntimeException.class, ()-> a.setIme("f"));
	}

	@Test
	void testSetPrezime() {
		//Autor a = new Autor();
		a.setPrezime("Ivanovic");
		assertEquals("Ivanovic", a.getPrezime());
	}
	
	@Test
	void testSetPrezimeNull() {
		assertThrows(java.lang.NullPointerException.class, ()-> a.setPrezime(null));
	}

	@Test
	@DisplayName("Testira duzinu imena")
	
	void testSetPreizmemeKRatakString() {
		//Autor a = new Autor();
		
		assertThrows(java.lang.RuntimeException.class, ()-> a.setPrezime("f"));
	}
	
	//Parametrizovani test - znaci da imamo parametre u okviru metode
	@ParameterizedTest
	@CsvSource(value = { "Pera,Peric,Pera,Peric, true",
			"Pera, Peric, Zika, Peric, false",
			"Pera, Peric, pera, peric, false"})
	void testEqualsObject(String ime1, String pr1, String ime2, String pr2, boolean eq) {
		a.setIme(ime1);
		a.setPrezime(pr1);
		
		Autor b = new Autor();
		b.setIme(ime2);
		b.setPrezime(pr2);
		
		assertEquals(eq, a.equals(b));
	}
	
	@Test
	void testToString() {
		a.setIme("Zika");
		a.setPrezime("Zikic");
		String s = a.toString();
		assertTrue(s.contains("Zika"));
		assertTrue(s.contains("Zikic"));
	}

}
