package fr.ufrsciencestech.panier;

/**
 *
 * @author roudet
 */
public class Fraise implements Fruit{
    private double prix;
    private String origine;

    public Fraise()
    {
        this.prix = 0.5;  //prix en euros
        this.origine="Espagne";
    }

    public Fraise(double prix, String origine)
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
        return "Fraise de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 Fraises sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Fraise or = (Fraise) o;
            return (prix == or.prix && origine.equals(or.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une Fraise a des pepins
        return false;
    }


    public static void main (String[] args){
        //Ecrire ici vos tests
    Fraise or = new Fraise();
	System.out.println(or.toString());

	Fraise or1 = new Fraise(1.2,"Brazil");
	System.out.println(or1.toString());

	System.out.println(or1.getPrix());

	System.out.println(or1.getOrigine());
   }
}
