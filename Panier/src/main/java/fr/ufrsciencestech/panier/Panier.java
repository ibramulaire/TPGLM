/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier;
import java.util.*;
/**
 *
 * @author 33782
 */

public class Panier {
    private ArrayList<Fruit> fruits;  //attribut pour stocker les fruits
    private int contenanceMax;        //nb maximum d'oranges que peut contenir le panier

    //groupe 1
    public Panier(int contenanceMax){  //initialise un panier vide ayant une certaine contenance maximale (precisee en parametre)
		this.contenanceMax = contenanceMax;
                this.fruits = new ArrayList<>();
    }

    @Override
    public String toString(){  //affichage de ce qui est contenu dans le panier : liste des fruits presents
    	String listeDesFruits = "";
    		int i = 1;
        for (Fruit fruit : fruits) {
            listeDesFruits += "Fruit "+i+" : "+fruit.toString()+"\n";
            i++;
        }
        return listeDesFruits;
    }

    //groupe 2
    public ArrayList<Fruit> getFruits() {  //accesseur du premier attribut
       return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) { //modificateur du premier attribut
      this.fruits = fruits;
    }

    public int getTaillePanier(){  //accesseur retournant la taille allouee pour l'attibut fruits
        return this.fruits.size();
    }

    public int getContenanceMax(){  //accesseur du second attribut
	return contenanceMax;
    }

    //groupe 3
    public Fruit getFruit(int i){  //accesseur retournant le fruit contenu dans le panier a l'emplacement n°i ou null s'il n'y a rien a cet emplacement
    	if (this.fruits.get(i) != null){return this.fruits.get(i);}
	return null;
    }

    public void setFruit(int i, Fruit f){  //modificateur du fruit contenu dans le panier a l'emplacement n°i par f (s'il y a bien deja un fruit a cet emplacement, ne rien faire sinon)
    	if (this.getTaillePanier() > i){this.fruits.set(i, f);}
    }

    
    
    public boolean estVide(){  //predicat indiquant que le panier est vide
    return this.fruits.isEmpty();
    }

    public boolean estPlein(){  //predicat indiquant que le panier est plein
    return !(this.fruits.size() < this.contenanceMax);
    }

    //groupe 4
    public void ajout(Fruit o) throws PanierPleinException{  //ajoute le fruit o a la fin du panier si celui-ci n'est pas plein
      if(this.estPlein())
      {
        throw new PanierPleinException();
      }
      else
      {
        this.fruits.add(o);
      }

    }

    //groupe 5
    public void retrait() throws PanierVideException{ //retire le dernier fruit du panier si celui-ci n'est pas vide
        if (this.estVide()){
            throw new PanierVideException();
        }
        else{
            this.fruits.remove(this.fruits.size()-1);
        }

    }

    //groupe 6
    public double getPrix(){  //calcule le prix du panier par addition des prix de tous les fruits contenus dedans
	return 0;
    }

    //groupe 7
    public void boycotteOrigine(String origine){  //supprime du panier tous les fruits provenant du pays origine

    }

    //groupe 8
    @Override
    public boolean equals(Object o){  ///predicat pour tester si 2 paniers sont equivalents : s'ils contiennent exactement les memes fruits
        return false;
    }

    //tests
    public static void main (String[] args){
    	//Ecrire ici vos tests
		System.out.println("premier test Panier");
		Panier panier = new Panier(3);
    try{
    panier.retrait();
    }
    catch(PanierVideException e){System.out.println(e);}
 
    try{
      panier.ajout(new Orange());
		panier.ajout(new Orange(2,"US"));
		panier.ajout(new Kiwi(2,"Japon"));
  }
  catch(PanierPleinException e){}
		//panier.ajout(new Orange(87,"Qatar"));
		System.out.println(panier.toString());
		panier.setFruit(2, new Pomme(55, "Argentine"));
		System.out.println("Le Fruit 3 est " + panier.getFruit(2).toString());
    }
}
