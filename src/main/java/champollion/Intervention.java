/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package champollion;

import java.util.Date;

/**
 *
 * @author Florian
 */
public class Intervention {

    private Date myDebut;
    private int myDuree;
    private boolean myAnnulee;
    private int myHeureDebut;
    private TypeIntervention myTypeIntervention;
    private Salle mySalle;
    private UE myUE;

    public Intervention(Date myDebut, int myDuree, int myHeureDebut, TypeIntervention myTypeIntervention, Salle mySalle, UE myUE) {
        this.myDebut = myDebut;
        this.myDuree = myDuree;
        this.myHeureDebut = myHeureDebut;
        this.myTypeIntervention = myTypeIntervention;
        this.mySalle = mySalle;
        this.myUE = myUE;
        this.myAnnulee=false;   
    }

    public void setMyAnnulee(boolean myAnnulee) {
        this.myAnnulee = myAnnulee;
    }

    public TypeIntervention getMyTypeIntervention() {
        return myTypeIntervention;
    }

    public UE getMyUE() {
        return myUE;
    }

    public int getMyDuree() {
        return myDuree;
    }
    
    

    
    
    



}
