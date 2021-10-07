package fr.ufrsciencestech.panier;

/**
 *
 * @author roudet
 */
public class Cerise {
    private double prix;
    private String origine;
	
    public Cerise() 
    {
        this.prix = 0.5;  //prix en euros
        this.origine="Espagne";
    }
    
    public Cerise(double prix, String origine) 
    {
	if(prix < 0)
	    //this.prix = -prix;  //une solution possible pour interdire les prix negatifs
	    prix = 0.0 ;
	else
	    this.prix = prix;

	if(origine.equals(""))
            this.origine = "France";  //Espagne par défaut
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
        return "Cerise de " + origine + " à " + prix + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 oranges sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Cerise or = (Cerise) o;
            return (prix == or.prix && origine.equals(or.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une orange a des pepins
        return false;
    }


    public static void main (String[] args){
        //Ecrire ici vos tests
	System.out.println("premier test Cerise");
	Cerise O1= new Cerise(5.0 , "France");
	Cerise O2= new Cerise(5.25 , "Japon");
	//System.out.println(O1);
	System.out.println("la cerise O1 "+O1+"\nla cerise O2 "+O2);
	//a tester avec O1 getters et setters mais flemme voir exemple suivant
	O1.setOrigine("Espagne");//exemple setter origine
	System.out.println("la cerise O1 "+O1+"\nla cerise O2 "+O2);//exemple setter origine
   }
}
