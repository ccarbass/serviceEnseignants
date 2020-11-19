package champollion;

import java.util.Date;

public class Intervention {
    private Date debut;
    private int duree;
    private boolean annulee;
    private Salle s;
    private  UE u;
    private Enseignant e;

    public Intervention(Salle s, UE ue, Enseignant e, Date deb, int duree){
        this.s=s;
        this.u=ue;
        this.e=e;
        this.debut=deb;
        this.duree=duree;
        this.annulee=false;

    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }

    public Salle getS() {
        return s;
    }

    public void setS(Salle s) {
        this.s = s;
    }

    public UE getU() {
        return u;
    }

    public void setU(UE u) {
        this.u = u;
    }

    public Enseignant getE() {
        return e;
    }

    public void setE(Enseignant e) {
        this.e = e;
    }
}
