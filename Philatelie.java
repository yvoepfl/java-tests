import java.util.ArrayList;

class Timbre {

    public static final int ANNEE_COURANTE = 2016;
    public static final int VALEUR_TIMBRE_DEFAUT = 1;
    public static final String PAYS_DEFAUT = "Suisse";
    public static final String CODE_DEFAUT = "lambda";

    public static final int BASE_1_EXEMPLAIRES = 100;
    public static final int BASE_2_EXEMPLAIRES = 1000;
    public static final double PRIX_BASE_1 = 600;
    public static final double PRIX_BASE_2 = 400;
    public static final double PRIX_BASE_3 = 50;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
	private String code;
	private int annee;
	private String paysOrig;
	private double valFac;
	
	public Timbre(String code, int annee, String paysOrig, double valFac){
		this.code = code;
		this.annee = annee;
		this.paysOrig = paysOrig;
		this.valFac = valFac;
	}
	public double vente(){
		double prix;
		if (getAnnee() < 5){
			prix = getValeurFaciale();
		}else{
			prix = getValeurFaciale() * age() * 2.5;
		}
		return prix;
	}
	public int age(){
		return ANNEE_COURANTE - getAnnee();
	}
	public String getCode(){
		return code;
	}
	public int getAnnee(){
		return annee;
	}
	public String getPays(){
		return paysOrig;
	}
	public double getValeurFaciale(){
		return valFac;
	}
	public String toString(){
		return "Timbre de code " +getCode() +" datant de " +getAnnee() +" (provenance " +getPays() +") ayant pour valeur faciale " +getValeurFaciale() +" francs";
	}
}

class Rare extends Timbre {
	private int nbEx;
	
	public Rare (String code, int annee, String paysOrig, double valFac, int nbEx){
		super(code, annee, paysOrig, valFac);
		this.nbEx = nbEx;
	}
	public double vente(){
		double prix;
		if (getExemplaires() < BASE_1_EXEMPLAIRES){
			prix = PRIX_BASE_1 * (age() / 10.0);
		}else if (getExemplaires() >= BASE_1_EXEMPLAIRES && getExemplaires() < BASE_2_EXEMPLAIRES){
			prix = PRIX_BASE_2 * (age() / 10.0);
		}else{
			prix = PRIX_BASE_3 * (age() / 10.0);
		}
		return prix;
	}
	public int getExemplaires(){
		return nbEx;
	}
	public String toString(){
		return "Timbre de code " +getCode() +" datant de " +getAnnee() +" (provenance " +getPays() +") ayant pour valeur faciale " +getValeurFaciale() +" francs"
				+"\nNombre d’exemplaires -> " +getExemplaires();
	}
}
class Commemoratif extends Timbre {
	public Commemoratif (String code, int annee, String paysOrig, double valFac){
		super(code, annee, paysOrig, valFac);
	}
	public double vente(){
		double prix;
		prix = super.vente() * 2;
		return prix;
	}
	public String toString(){
		return "Timbre de code " +getCode() +" datant de " +getAnnee() +" (provenance " +getPays() +") ayant pour valeur faciale " +getValeurFaciale() +" francs"
				+"\nTimbre celebrant un evenement";
	}
}
	
/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

class Philatelie {

    public static void main(String[] args) {

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale,
        // nombre d'exemplaires
        Rare t1 = new Rare("Guarana-4574", 1960, "Mexique", 0.2, 98);

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale
        Commemoratif t2 = new Commemoratif("700eme-501", 2002, "Suisse", 1.5);
        Timbre t3 = new Timbre("Setchuan-302", 2004, "Chine", 0.2);

        Rare t4 = new Rare("Yoddle-201", 1916, "Suisse", 0.8, 3);


        ArrayList<Timbre> collection = new ArrayList<Timbre>();

        collection.add(t1);
        collection.add(t2);
        collection.add(t3);
        collection.add(t4);

        for (Timbre timbre : collection) {
            System.out.println(timbre);
            System.out.println("Prix vente : " + timbre.vente() + " francs");
            System.out.println();
        }
    }
}

