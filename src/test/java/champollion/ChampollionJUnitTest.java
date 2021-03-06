package champollion;

import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
	Salle B102, B103;
	Intervention I1, I2;
	Date D1,D2;

		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");
		B102= new Salle("B102",20);
		B103= new Salle("B103",22);
		D1= new Date(2020, 10, 15);
		D2= new Date(2020, 10, 16);
		I1 = new Intervention(B102,uml,untel,D1,2,TypeIntervention.CM);
		I2 = new Intervention(B102,java,untel,D2,2,TypeIntervention.TP);

	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
	@Test
	public void testHeuresPrevuesUe(){
		// 10h TD 3 CM 4 1P pour UML
		untel.ajouteEnseignement(uml, 3, 10, 4);
		assertEquals(17, untel.heuresPrevuesPourUE(uml),
				"L'enseignant doit maintenant avoir 18 heures prévues pour l'UE 'uml'");

	}

	@Test
	public void testHeuresPrevue(){
		// 10h TD 3 CM 4 1P pour UML
		untel.ajouteEnseignement(uml, 3, 10, 4);
		untel.ajouteEnseignement(java, 3, 10, 4);
		assertEquals(34, untel.heuresPrevues(),
				"L'enseignant doit maintenant avoir 18 heures prévues pour l'UE 'uml'");

	}
	@Test
	public void testSousServiceT(){
		untel.ajouteEnseignement(uml, 3, 10, 4);
		untel.ajouteEnseignement(java, 3, 10, 4);
		assertTrue(untel.enSousService(),"doit renvoyer vraie");
	}

	@Test
	public void testSousServiceF(){
		untel.ajouteEnseignement(uml, 150, 10, 4);
		untel.ajouteEnseignement(java, 3, 10, 4);
		assertFalse(untel.enSousService(),"doit renvoyer Faux");
	}
}
