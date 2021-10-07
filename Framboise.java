/**
 *
 * @author roudet
 */
public class Framboise {
    private double prix;
    private String origine;
	
    public Framboise() 
    {
        this.prix = 0.5;  //prix en euros
        this.origine="Espagne";
    }
    
    public Framboise(double prix, String origine) 
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
        return "Framboise de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 Framboises sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Framboise or = (Framboise) o;
            return (prix == or.prix && origine.equals(or.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une Framboise a des pepins
        return false;
    }


    public static void main (String[] args){
        //Ecrire ici vos tests
	//System.out.println("premier test Framboise");
	Framboise o1= new Framboise(-100,"mamou");
	Framboise o2=new Framboise();
	System.out.println("La premiere Framboise coute "+o1.getPrix());
        System.out.println("La 2eme Framboise vient de "+o2.getOrigine());
	o1.setPrix(10);
        o1.setOrigine("e:rkgnlkm");
	System.out.println(o1.toString());



   }
}
