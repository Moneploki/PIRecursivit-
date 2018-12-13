/**
 * Arbre binaire d'entiers.
 */
class Arbre {

	int element ;
	Arbre filsGauche ;
	Arbre filsDroit ;
	Operation op = new Operation();
	/**
	 * Constante représentant l'arbre vide.
	 */
	static final Arbre VIDE = new Arbre(0, null, null);

	/**
	 * 
	 * Construit un nouvel arbre ayant l'élément, le fils gauche et le fils
	 * droit donnés.
	 * 
	 * @param element l'élément
	 * @param filsGauche le fils gauche
	 * @param filsDroit le fils droit
	 */
	Arbre(int element, Arbre filsGauche, Arbre filsDroit) {
		this.element = element;
		this.filsGauche= filsGauche;
		this.filsDroit = filsDroit;
	}

	/**
	 * Retourne l'élément de l'arbre.
	 * 
	 * @return l'élément de l'arbre
	 */
	int getElement() {
		return this.element;
	}

	/**
	 * Retourne le fils gauche de l'arbre.
	 * 
	 * @return le fils gauche de l'arbre
	 */
	Arbre getFilsGauche() {

		return this.filsGauche;
	}

	/**
	 * Retourne le fils droit de l'arbre.
	 * 
	 * @return le fils droit de l'arbre
	 */
	Arbre getFilsDroit() {
		return this.filsDroit;
	}

	/**
	 * Indique si l'arbre est vide ou non.
	 * 
	 * @return true si l'arbre est vide, false sinon
	 */
	boolean estVide() {
		return this == VIDE ;
	}

	/**
	 * Indique si l'arbre est une feuille ou non.
	 * 
	 * @return true si l'arbre est une feuille, false sinon
	 */
	boolean estFeuille() {
		if(this.estVide())
			return false;
		else
			return this.getFilsDroit().estVide() && this.getFilsGauche().estVide();
	}

	/**
	 * Renvoie le nombre d'éléments de l'arbre.
	 * 
	 * @return le nombre d'éléments de l'arbre
	 */
	int getTaille() {
		if(this.estVide())
			return 0;
		else
			return 1 + this.getFilsDroit().getTaille() + this.getFilsGauche().getTaille();
	}

	/**
	 * Renvoie la hauteur de l'arbre.
	 * 
	 * @return la hauteur de l'arbre
	 */
	int getHauteur() {
		if(this.estVide())
			return 0;
		else
			return 1 + Math.max(this.getFilsDroit().getHauteur(), this.getFilsGauche().getHauteur());
	}

	/**
	 * Renvoie le nombre de feuilles de l'arbre.
	 * 
	 * @return le nombre de feuilles de l'arbre
	 */
	int getNbFeuilles() {
		if(!this.estVide()){
			if(this.estFeuille())
				return 1;
			else
				return this.getFilsDroit().getNbFeuilles() + this.getFilsGauche().getNbFeuilles() ;
		}else 
			return 0;
	}

	/**
	 * Crée une représentation textuelle de l'arbre adaptée aux expressions
	 * arithmétiques.
	 * 
	 * L'arbre vide est représenté par la chaîne "()".
	 * 
	 * L'arbre qui est une feuille représente une opérande: la représentation
	 * est cette opérande (nombre entier) convertie en une chaîne de caractères.
	 * 
	 * L'arbre qui n'est pas une feuille représente une opération. Par exemple,
	 * l'expression simple 1 + 2 a est représentée par la chaîne "(1+2)".
	 * 
	 * @return une représentation textuelle de l'arbre
	 */
	String versChaine() {
		String elem = "";
		if(this.estVide())
			return "()";
		else{
			if(!this.estFeuille()){
				elem = Character.toString((char)(this.element));
				return "(" + this.getFilsGauche().versChaine() + elem + this.getFilsDroit().versChaine() + ")" ;
			}else{
				elem = Integer.toString(this.element);
				return elem ;
			}
			
			
		}
	}

	/**
	 * Indique si un élément est présent ou non dans l'arbre.
	 * 
	 * @param element l'élément à rechercher
	 * @return true si l'élément est présent, false sinon
	 */
	boolean contient(int element) {
		// à compléter/modifier
		return false;
	}

	/**
	 * Renvoie une copie de l'arbre this.
	 * @return la copie de l'arbre this
	 */
	Arbre copie() {
		if(this.estVide())
			return VIDE;
		if(this.estFeuille())
			return new Arbre(this.element,VIDE,VIDE);
		else 
			return new Arbre(this.element,this.getFilsGauche().copie(),this.getFilsDroit().copie());
		
	}

	/**
	 * Détermine si l'arbre this possède le même contenu (égalité par valeur)
	 * que l'arbre donné ou non.
	 * @param arbre l'arbre à comparer à l'arbre this
	 * @return true si l'arbre this possède le même contenu que l'arbre donné,
	 *         false sinon
	 */
	boolean egale(Arbre arbre) {
		if(arbre.estVide())
			return this.estVide();
		if(this.estFeuille())
			return this.element == arbre.element;
		else 
			return this.getFilsGauche().egale(arbre.getFilsGauche()) && this.element == arbre.element && this.getFilsDroit().egale(arbre.getFilsDroit()) ;
	}

	/**
	 * Evalue la valeur de l'expression arithmétique stockée dans l'arbre.
	 * 
	 * Si l'arbre est vide, une erreur est déclenchée (car l'arbre vide ne
	 * représente pas une expression arithmétique valide).
	 * 
	 * Si l'arbre est une feuille, l'élément stocké dans la feuille représente
	 * une opérande représentant un entier
	 * 
	 * Sinon, l'arbre représente une opération dont l'élément de sa racine est
	 * un opérateur.
	 * 
	 * @return la valeur de l'expression arithmétique stockée dans l'arbre
	 */
	int calcule() {
		if(this.estVide())
			throw new Error("tu essaye de rien faire là Bonhomme !");
		if(this.estFeuille())
			return this.element;
		else
			return op.calcule(this.getFilsGauche().calcule(),(char)this.element,this.getFilsDroit().calcule());
	}

}
