package champollion;

import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.List;

public class Enseignant extends Personne {

    private List<ServicePrevu> myServicePrevu = new ArrayList<>();
    private List<Intervention> myListeIntervention = new ArrayList<>();

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML
    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures
     * équivalent TD" Pour le calcul : 1 heure de cours magistral vaut 1,5 h
     * "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut
     * 0,75h "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet
     * enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        // TODO: Implémenter cette méthode
        float res = 0;
        for (ServicePrevu s : this.myServicePrevu) {
            res += s.getMyHeuresCM() * 1.5;
            res += s.getMyHeuresTD();
            res += s.getMyHeuresTP() * 0.75;
        }
        return round(res);
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE
     * spécifiée en "heures équivalent TD" Pour le calcul : 1 heure de cours
     * magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent
     * TD" 1 heure de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet
     * enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        // TODO: Implémenter cette méthode
        float res = 0;
        for (ServicePrevu s : this.myServicePrevu) {
            if (s.getMyUE() == ue) {
                res += s.getMyHeuresCM() * 1.5;
                res += s.getMyHeuresTD();
                res += s.getMyHeuresTP() * 0.75;
            }
        }
        return round(res);
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        // TODO: Implémenter cette méthode
        ServicePrevu e = new ServicePrevu(volumeCM, volumeTD, volumeTP, this, ue);
        this.myServicePrevu.add(e);
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }

    public void ajouterIntervention(Intervention inter) {
        this.myListeIntervention.add(inter);
    }

    public boolean enSousService() {
        boolean sousService = false;
        if (this.heuresPrevues() < 192) {
            sousService = true;
        }

        return sousService;
    }

    public int resteAPlanifier(UE ue, TypeIntervention type) {
        int prevu = 0;
        int planifie = 0;
        for (ServicePrevu s : this.myServicePrevu) {
            if (s.getMyUE() == ue) {
                if (type == TypeIntervention.CM) {
                    prevu = s.getMyHeuresCM();
                }
                if (type == TypeIntervention.TD) {
                    prevu = s.getMyHeuresTD();
                }
                if (type == TypeIntervention.TP) {
                    prevu = s.getMyHeuresTP();
                }
            }
        }

        for (Intervention i : myListeIntervention) {
            if (i.getMyUE() == ue) {
                if (type == i.getMyTypeIntervention()) {
                    planifie = i.getMyDuree();
                }
                if (type == i.getMyTypeIntervention()) {
                    planifie = i.getMyDuree();
                }
                if (type == i.getMyTypeIntervention()) {
                    planifie = i.getMyDuree();
                }
            }
        }

        return prevu - planifie;
    }

}
