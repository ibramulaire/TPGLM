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
   private ArrayList<Fruit> fruits;
    private int cont_max;   //nb maximum d'oranges que peut contenir le panier
	
    public Panier(int max){
	cont_max = max;
	fruits = new ArrayList<Fruit>(max);  //panier vide
    }
    
    public double getPrix(){
	double total=0;
	for(int i = 0 ; i < getFruits().size() ; i++)
            total += getFruits().get(i).getPrix();
	return total;
		
	//ou :
	/*double total=0;
	Iterator<Orange> it = oranges.iterator();
	while(it.hasNext()){ 
            Orange curr = it.next();
            total += curr.getPrice();
	}
	return total;*/
    }
    
    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
       

    }
    
    public int getTaille(){
        return getFruits().size();
    }
    
    public int getContMax(){
	return cont_max;
    }
    
    public Fruit getFruits(int i){
        if(i >= 0 && i < getFruits().size())
            return getFruits().get(i);
        else
            return null;
    }
    
    public boolean estVide(){
        return getFruits().isEmpty();
    }
    
    public boolean estPlein(){
        return getFruits().size() == cont_max;
    }
    
    public void ajoute() throws PanierPleinException{
        if(!estPlein()){
            Fruit o;
            if(!estVide())
                o = getFruits().get(getFruits().size()-1);
            else
                o = new Orange();
            getFruits().add(o);
            
        }
        else {
            throw new PanierPleinException();
        }
    }
	
    public void ajoute(Fruit o) throws PanierPleinException{
        if(o == null)
            return;
        if(!estPlein()){
            getFruits().add(o);
           
        }
        else 
            throw new PanierPleinException();
    }
        
    public void retire() throws PanierVideException{
        if(!estVide()){
            getFruits().remove(getFruits().size()-1);
           
        }
        else 
        {
            throw new PanierVideException();
        }
    }
	
    public void boycotteOrigine(String origine){
	int i = 0;					//A
	while(i < getFruits().size()){			//B
            if(getFruits().get(i).getOrigine().equals(origine)){ //C
		getFruits().remove(i);			//D
              
            }
            else								 
		i++ ;					//E
        }
    }  
        
    @Override
    public String toString(){
        String tmp = "[";
        int i = 0;
        while(i < getTaille()-1){
            tmp += getFruits().get(i).getClass().getSimpleName();
            tmp += getFruits().get(i).getPrix()+"€ ,";
            i++;
        }
        if(estVide())
            tmp += "]";
        else
            tmp += getFruits().get(getFruits().size()-1).getClass().getSimpleName() + ""+getFruits().get(getFruits().size()-1).getPrix()+"€ ]";
        return tmp;
    }
    
    public String toStringAffichage(){
        String tmp = "[";
        int i = 0;
        while(i < getTaille()-1){
            tmp += getFruits().get(i).getClass().getSimpleName();
            tmp += getFruits().get(i).getPrix()+"€ \n";
            i++;
        }
        if(estVide())
            tmp += "]";
        else
            tmp += getFruits().get(getFruits().size()-1).getClass().getSimpleName() + ""+getFruits().get(getFruits().size()-1).getPrix()+"€ ]";
        return tmp;
    }
        
    @Override
    public boolean equals(Object o){ //equivalent si c'est dans le même ordre
        if(o == null)
            return false;

        boolean result = false;
        if(o instanceof Panier){
            Panier p = (Panier) o;
            if(p.getTaille() == this.getTaille())
            {
                int i=0;
                while(i < p.getTaille())
                {					 
                    if( p.getFruits().get(i).getPrix() != this.getFruits().get(i).getPrix() ||
                        !p.fruits.get(i).getOrigine().equals(this.fruits.get(i).getOrigine()) )
                            break;				
                    i++ ;	
                }
                if(i == p.getTaille()) //toutes les oranges parcourues sont les mêmes
                    result = true;
            }
            else //les 2 paniers n'ont pas le même nb d'oranges
                result = false;
        }
        return result;
    }
    
    public int nbFruits(Fruit f){  //combien trouve-t-on de fruits f dans le panier
        int cpt = 0;
        int i = 0;					
	while(i < getFruits().size()){	
            if(getFruits().get(i).equals(f)) 
		cpt++;									 
            i++ ;					
        }
        return cpt;
    }
}
