package fr.ufrsciencestech.panier;

/**
 *
 * @author barault
 */
public class Kiwi implements Fruit {
    private double prix;
    private String origine;
	
    public Kiwi() 
    {
        this.prix = 0.5;  //prix en euros
        this.origine="Espagne";
    }
    
    public Kiwi(double prix, String origine) 
    {
	if(prix < 0)
	    this.prix = -prix;  //une solution possible pour interdire les prix negatifs
	else
	    this.prix = prix;

	if(origine.equals(""))
            this.origine = "Espagne";  //Espagne par défaut
	else
            this.origine = origine;   
    }

    public double getPrix(){
	return prix;
    }

    public void setPrix(double prix){
	this.prix=prix;
    }

    public String getOrigine(){
	return origine;
    }
 
    public void setOrigine(String origine){
	this.origine=origine;
    }

    @Override
    public String toString(){
        return "Kiwi de " + origine + " a " + prix + " euros";

    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 kiwi sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Kiwi or = (Kiwi) o;
            return (prix == or.prix && origine.equals(or.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une kiwi a des pepins
        return false;
    }


    public static void main (String[] args){
        //Ecrire ici vos tests
		System.out.println("premier test Kiwi");
		Kiwi or1 = new Kiwi();
		Kiwi or2 = new Kiwi(0.5,"Espagne");
		System.out.println(or1.equals(or2));
		Kiwi or3 = new Kiwi(-4,"France");
		System.out.println(or3.toString());
		System.out.println(or3.getPrix());
		System.out.println(or3.getOrigine());
   }
}
