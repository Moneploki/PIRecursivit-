/**
 * La classe Exemples fournit différents exemples d'arbres binaires via un
 * ensemble de méthodes statiques.
 */
public class Exemples {

	/**
	 * 	Renvoie l'arbre 1 suivant :
	 * 
	 *        1
	 *       / \
	 *       
	 */
	public static Arbre creeArbre1() {
		return new Arbre(1, Arbre.VIDE, Arbre.VIDE);
	}


	/**
	 * 	Renvoie l'arbre 2 suivant :
	 * (
	 *        +
	 *       / \
	 *      2   3
	 *     / \ / \
	 *     
	 */
	public static Arbre creeArbre2() {
		return
			new Arbre('+', 
				new Arbre(2, Arbre.VIDE, Arbre.VIDE), 
				new Arbre(3, Arbre.VIDE, Arbre.VIDE)
			);
	}

	/**
	 * 	Renvoie l'arbre 3 suivant :
	 * 
	 *         +
	 *       /   \
	 *      *     4
	 *     / \   / \
	 *    2   3
	 *   / \ / \
	 *     
	 */
	public static Arbre creeArbre3() {
		return
		new Arbre('+', 
				new Arbre('*',
					new Arbre(2, Arbre.VIDE, Arbre.VIDE),
					new Arbre(3, Arbre.VIDE, Arbre.VIDE)),
				 
				new Arbre(4, Arbre.VIDE, Arbre.VIDE)
			);

	}


	/**
	 * 	Renvoie l'arbre 4 suivant :
	 * 
	 *         /
	 *       /   \
	 *      4     /
	 *     / \   / \
	 *          2   3
	 *         / \ / \
	 *     
	 */
	public static Arbre creeArbre4() {
		return
		new Arbre('/', 
				new Arbre(4,Arbre.VIDE, Arbre.VIDE), 
				
				new Arbre('/',
					new Arbre(2,Arbre.VIDE, Arbre.VIDE),
					new Arbre(3,Arbre.VIDE, Arbre.VIDE) )
			);
	}

	/**
	 * 	Renvoie l'arbre 5 suivant :
	 * 
	 *          +
	 *       /     \
	 *      *       -
	 *     / \     / \
	 *    2   3   5   4
	 *   / \ / \ / \ / \
	 *     
	 */
	public static Arbre creeArbre5() {
		return
		new Arbre('+', 
				new Arbre('*',
					new Arbre(2,Arbre.VIDE, Arbre.VIDE),
					new Arbre(3,Arbre.VIDE, Arbre.VIDE) ),
				
				new Arbre('-',
					new Arbre(5,Arbre.VIDE, Arbre.VIDE),
					new Arbre(4,Arbre.VIDE, Arbre.VIDE) )
			);
	}

}
