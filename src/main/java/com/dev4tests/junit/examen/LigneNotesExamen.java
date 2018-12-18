package com.dev4tests.junit.examen;

public class LigneNotesExamen {

	private String nom;
	private String cours;
	private String examen;
	private String niveau;
	private String idEtudiant;
	private Evaluateur evaluateur;
	
	public LigneNotesExamen(String nom, String cours, String examen, String idEtudiant, Evaluateur evaluateur ) throws Exception {
		super();
		this.nom = nom;
		this.cours = cours;
		this.examen = examen;
		this.idEtudiant = idEtudiant;
		this.evaluateur = evaluateur;
		this.niveau = evaluateur.evaluerNiveau( cours , examen);
	}
	
	public String getNom() {
		return nom;
	}
	
	public Evaluateur getEvaluateur() {
		return evaluateur;
	}
	
	public String getCours() {
		return cours;
	}
	
	public String getNiveau() {
		return niveau;
	}
	
	public String getExamen() {
		return examen;
	}
	
	
	public String getIdEtudiant() {
		return idEtudiant;
	}
	
	public String toString() {
		return "Examen de " + nom + " - cours : " + cours + " - examen : " + examen + " - niveau : " + niveau;
	}

}
