package champollion;

public class ServicePrevu {
	// TODO : implémenter cette classe
    
    private int myHeuresCM;
    private int myHeuresTD;
    private int myHeuresTP;
    private final Enseignant myEnseignant;
    private final UE myUE;

    public ServicePrevu(int myHeuresCM, int myHeuresTD, int myHeuresTP, Enseignant myEnseignant, UE myUE) {
        this.myHeuresCM = myHeuresCM;
        this.myHeuresTD = myHeuresTD;
        this.myHeuresTP = myHeuresTP;
        this.myEnseignant = myEnseignant;
        this.myUE = myUE;
    }

    public int getMyHeuresCM() {
        return myHeuresCM;
    }

    public int getMyHeuresTD() {
        return myHeuresTD;
    }

    public int getMyHeuresTP() {
        return myHeuresTP;
    }

    public UE getMyUE() {
        return myUE;
    }
    
    

}
