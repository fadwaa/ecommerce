package Beans;

public class Article {
	int id_article;
	String nom_a;
	double prix;
	String description;
	int quantite;
	String image;

	public Article()
	{
		
	}
	public int getId_article() {
		return id_article;
	}
	public void setId_article(int id_article) {
		this.id_article = id_article;
	}
	public String getNom_a() {
		return nom_a;
	}
	public void setNom_a(String nom_a) {
		this.nom_a = nom_a;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Article [id_article=" + id_article + ", nom_a=" + nom_a
				+ ", prix=" + prix + ", description=" + description
				+ ", quantité=" + quantite + "]";
	}
	
	

}
