package champollion;

public class Salle {
    private String intitule;
    private int capacite;

    public Salle(String intitule, int capacite){
        this.intitule=intitule;
        this.capacite=capacite;
    }

    public String getIntitule(){return this.intitule;}

    public int getCapacite(){return this.capacite;}
}
