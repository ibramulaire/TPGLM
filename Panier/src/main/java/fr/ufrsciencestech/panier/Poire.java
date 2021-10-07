package fr.ufrsciencestech.panier;

/**
 *
 * @author roudet
 */
public class Poire {
    private double prix;
    private String origine;
	
    public Poire() 
    {
        this.prix = 0.5;  //prix en euros
        this.origine="Espagne";
    }
    
    public Poire(double prix, String origine) 
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
        return("Poire de : " + origine + " a " + prix + " euros");
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 oranges sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Poire or = (Poire) o;
            return (prix == or.prix && origine.equals(or.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une orange a des pepins
        return false;
    }


    public static void main (String[] args){
        //Ecrire ici vos tests
Orange or18 = new Orange(-2,"France");        
        
	System.out.println("premier test Poire");
	Poire or = new Poire(-10,"France");
	System.out.println(or.toString());
	
	System.out.println("deuxieme test Poire");
	Poire or2 = new Poire(10,"France");
	System.out.println(or2.toString());
	
	System.out.println("troisieme test Poire");
	Poire or3 = new Poire(10,"");
	System.out.println(or3.toString());

	System.out.println("setPrix");
	or.setPrix(2);
	System.out.println(or.toString());
	
	System.out.println("setOrigine");
	or2.setOrigine("Belgique");
	System.out.println(or2.toString());
	
	System.out.println("getPrix");
	System.out.println(or.getPrix());
	
	System.out.println("getOrigine");
	System.out.println(or2.getOrigine());
	
	System.out.println("Poire 1 = Poire 2 ?");
	
	System.out.println(or.equals(or3));
	System.out.println(or.equals(or18));
	
   }
}
