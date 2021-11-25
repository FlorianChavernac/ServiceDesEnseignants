package champollion;

import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {

    Enseignant untel;
    UE uml, java;

    @BeforeEach
    public void setUp() {
        untel = new Enseignant("untel", "untel@gmail.com");
        uml = new UE("UML");
        java = new UE("Programmation en java");
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
    public void testAjouterIntervention() {
        Date date = new Date();
        Salle salle = new Salle("103", 30);
        untel.ajouterIntervention(new Intervention(date, 2, 10, TypeIntervention.CM, salle, uml));
        untel.ajouterIntervention(new Intervention(date, 4, 10, TypeIntervention.TD, salle, uml));
        untel.ajouterIntervention(new Intervention(date, 6, 10, TypeIntervention.TP, salle, uml));

        untel.ajouteEnseignement(uml, 2, 4, 6);
        assertTrue(untel.enSousService(),
                "L'enseignant est en sous service");
        assertEquals(0, untel.resteAPlanifier(uml, TypeIntervention.CM),
                "Il ne reste pas d'heure à planifier");
        assertEquals(0, untel.resteAPlanifier(uml, TypeIntervention.TD),
                "Il ne reste pas d'heure à planifier");
        assertEquals(0, untel.resteAPlanifier(uml, TypeIntervention.TP),
                "Il ne reste pas d'heure à planifier");
    }

    @Test
    public void testEnSousService() {
        untel.ajouteEnseignement(uml, 80, 100, 90);
        assertFalse(untel.enSousService(),
                "L'enseignant n'est pas en sous service");
        assertNotEquals(0, untel.resteAPlanifier(uml, TypeIntervention.CM),
                "Il reste des heures à planifier");
    }
}
