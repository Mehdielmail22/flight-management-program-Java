package exam_final;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		System.out.println("bismlah");
		Scanner clavier=new Scanner(System.in);
		System.out.println("bonjour monsieur l'administrateur");
		System.out.println("vous devez creer une agence donnez son nom:");
		String nom_ag=clavier.next();
		System.out.println("Ajoutez des offrs:");
		System.out.println("choisissez le nombre d'offre que vous voulez ajouter");
		int d=clavier.nextInt();
		Agence ag=new Agence("nom_ag",d);
		

		for(int i=0;i<ag.getD();i++) {
			System.out.println("rempli l'offre "+i+1);
			System.out.println("la ville de depart");
			String depart=clavier.next();
			System.out.println("la ville d'arriver");
			String arriver=clavier.next();
			System.out.println("le nombre de place disponible pour l'offre");
			int nb_places=clavier.nextInt();
			System.out.println("le prix");
			double prix=clavier.nextDouble();
			ag.getOffre()[i]=new Offre(nb_places,depart,arriver,prix);
			
		}
		System.out.println("bonjour monsieur le client");
		System.out.println("donnez votre nom :");
		String nom=clavier.next();
		System.out.println("donnez votre solde");
		double solde=clavier.nextDouble();
		Client client=new Client(solde,nom);
		for(int i=0;i<5;i++) {
			
		
		System.out.println("chercher l'offre");
		System.out.println("donnez la ville de depart");
		String depart=clavier.next();
		System.out.println("donnez la ville d'arriver");
		String arriver=clavier.next();
		Offre result=ag.find(depart, arriver);
		if(result!=null&& result.getPrix()<client.getSolde()) {
			client.setSolde(client.getSolde()-result.getPrix());
			System.out.println("filicitation votre achat est effectué");
			System.out.println("votre solde maintenant est : "+client.getSolde());
			ag.Supprimer(result);
			break;
		}
		
		}
		System.out.println("les offres qui sont disponible maintenant sont :");
		for(int i=0;i<ag.getOffre().length;i++) {
			if(ag.getOffre()[i]!=null) {
				System.out.println("depart : "+ag.getOffre()[i].getDepart()+" l'arrive : "+ag.getOffre()[i].getArrive()+" prix : "+ag.getOffre()[i].getPrix()+" nbr place : "+ag.getOffre()[i].getNbr_places());
			}
		}
		
		
		
		

	}

}
class Offre{
	public int getNbr_places() {
		return nbr_places;
	}
	public void setNbr_places(int nbr_places) {
		this.nbr_places = nbr_places;
	}
	private int nbr_places;
	private String depart;
	private String arrive;
	private double prix;
	public Offre() {}
	public Offre(int nbr_places,String depart,String arrive,double prix) {
		this.nbr_places=nbr_places;
		this.depart=depart;
		this.arrive=arrive;
		this.prix=prix;
		
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getArrive() {
		return arrive;
	}
	public void setArrive(String arrive) {
		this.arrive = arrive;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
}
class Client{
	

	private double solde;
	private String nom_cli;
	private Offre offre_achete;

	public Client() {}
	public Client(double solde,String nom_cli) {
		this.solde=solde;
		this.nom_cli=nom_cli;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getNom_cli() {
		return nom_cli;
	}
	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
	}
	public Offre getOffre_achete() {
		return offre_achete;
	}
	public void setOffre_achete(Offre offre_achete) {
		this.offre_achete = offre_achete;
	}
}
class Agence{


	private String nom_ag;
	private int d;
	private Offre [] offre;
	public Agence() {}
	public Agence(String nom_ag,int d) {
		this.d=d;
		this.offre=new Offre[this.d];
		
	}
	public String getNom_ag() {
		return nom_ag;
		
	}
	public void setNom_ag(String nom_ag) {
		this.nom_ag = nom_ag;

	}
	
	public Offre[] getOffre() {
		return offre;
	}
	public void setOffre(Offre[] offre) {
		this.offre = offre;
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	public Offre find(String depart,String arriver) {
		Offre a=new Offre();
		for(int i=0;i<offre.length;i++) {
			if(this.offre[i]!=null) {
				if(this.offre[i].getDepart().equals(depart)&&this.offre[i].getArrive().equals(arriver)) {
					a= this.offre[i];
					break;
				}
			}
		}
		return a;
	}
	public void Supprimer(Offre a) {
		for(int i=0;i<this.offre.length;i++) {
			if(this.offre[i]==a)
			{
				this.offre[i]=null;
			}
		}
	}
}
