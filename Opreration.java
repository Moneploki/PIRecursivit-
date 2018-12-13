/**
 * La classe Operation définit un jeu de méthodes statiques qui permettent de
 * réaliser des opérations binaires simples.
 * 
 * Une opération binaire est composée de deux opérandes (respectivement opérande
 * gauche et opérande droite) qui définissent les valeurs d'entrée de
 * l'opération, ainsi qu'un opérateur qui définit le type de l'opération (+ - *
 * ou /).
 * 
 * Par exemple, l'opération 123 + 456 a pour opérande gauche 123, pour opérateur
 * +, et pour opérande droite 456.
 * 
 * Opérandes et opérateurs seront respectivement représentés par les types int
 * et char de Java.
 *
 */
class Operation {

	/**
	 * Précise si le caractère donné représente ou non un opérateur valide, à
	 * savoir + - * ou /.
	 * @param caractere le caractère à tester
	 * @return true si le caractère vaut '+', '-', '*' ou '/', false sinon
	 */
	static boolean estOperateur(char caractere) {
		return caractere == '+' || caractere == '-' || caractere == '*' || caractere == '/';
	}

	/**
	 * Réalise le calcul d'une opération ayant les opérandes et l'opérateur
	 * donnés, puis renvoie le résultat de ce calcul sous forme entière.
	 * 
	 * Si l'opérateur n'est pas un opérateur valide (+ - * ou /), une erreur est
	 * déclenchée.
	 * 
	 * Si l'opérande droite vaut zéro et que l'opéreteur est la division, une
	 * erreur est également déclenchée.
	 * 
	 * 
	 * @param operandeGauche l'opérande gauche de l'opération à calculer
	 * @param operateur l'opérateur de l'opération à calculer
	 * @param operandeDroite l'opérande droite de l'opération à calculer
	 * @return le résultat du calcul
	 */
	static int calcule(int operandeGauche, char operateur, int operandeDroite) {
		if(operateur == '+')
			return operandeGauche + operandeDroite;
		if(operateur == '-')
			return operandeGauche - operandeDroite;
		if(operateur == '*')
			return operandeGauche * operandeDroite;
		if(operateur == '/'){
			if(operandeDroite == 0)
				throw new Error("On ne peut pas diviser par Zéro Malheureux !");
			return operandeGauche / operandeDroite;
		}
		throw new Error("l'Opérateur :" +operateur + " n'est pas pris en compte");
	}

}
