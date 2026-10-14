package ma.ClassesAbstraites.ex1;

public class Entreprise {

	private Employe[] employes;

	private int nb;

	public Entreprise() {
		this.employes = new Employe[4];
		this.nb = 0;
	}

	public void ajouterEmploye(Employe e) {
		if (nb == employes.length) {
			Employe[] tmp = new Employe[employes.length * 2]; // cree un tableau 2 fois plus grand
			System.arraycopy(employes, 0, tmp, 0, employes.length); // copie les anciens elet dedans
			employes = tmp; // replace l'ancien tab par le nouveau tab double
		}
		employes[nb++] = e; // ajout de l'employe dans la position actuelle 'nb ' et incrementation de 'nb'
							// de 1
	}

	public void afficherPaie() {
		System.out.println("=== Bulletin de paie ===");
		for (int i = 0; i < nb; i++) {
			System.out.println(employes[i]);
		}
		System.out.println("\nMasse salariale totale : " + String.format("%.2f", masseSalariale()) + "€");
	}

	public double masseSalariale() {
        double somme = 0;
        for (int i = 0; i < nb; i++) {
            somme += employes[i].calculerSalaire(); // ajout de salaire pour chaque employe calcule dynamiquement en appelant la bonne version de la methode calculerSalaire()   
        }
        return somme;
    }
	
}
