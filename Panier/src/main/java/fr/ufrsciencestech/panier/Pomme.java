package fr.ufrsciencestech.panier;

/**
 *
 * @author roudet
 */
public class Pomme implements Fruit{
    private double prix;
    private String origine;
	
    public Pomme() 
    {
        this.prix = 0.5;  //prix en euros
        this.origine="Espagne";
    }
    
    public Pomme(double prix, String origine) 
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
        return "Pomme de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 oranges sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Pomme pom = (Pomme) o;
            return (prix == pom.prix && origine.equals(pom.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une orange a des pepins
        return false;
    }


    public static void main (String[] args){
        //Ecrire ici vos tests
        Pomme fruit_pomme = new Pomme(50, "Islande");
        //Creation d'une orange avec la provenance d'Islande
        System.out.println(fruit_pomme.toString());
        //Affiche les informations de l'orange crée
        Pomme pomme_20 = new Pomme(20, "Islande");
        //Création d'une deuxieme orange d'Islande avec un prix différent
        System.out.println(fruit_pomme.equals(pomme_20));
	System.out.println("premier test Pomme");
   }
}
