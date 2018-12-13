public class ProgArbre {

	public static void main(String[] args) {
		ProgArbre testContientArbre = new ProgArbre();
		testContientArbre.testArbreVide();
		testContientArbre.testArbre1();
		testContientArbre.testArbre2();
	}

	void testArbreVide() {
		Test.assertFalse(Arbre.VIDE.contient(0), "L'arbre vide ne contient pas 0");
	}

	void testArbre1() {
		Arbre arbre = Exemples.creeArbre1();
		Test.assertFalse(arbre.contient(0), "L'arbre 1 ne contient pas 0");
		Test.assertTrue(arbre.contient(1), "L'arbre 1 contient 1");
	}

	void testArbre2() {
		Arbre arbre = Exemples.creeArbre2();
		Test.assertFalse(arbre.contient(0), "L'arbre 1 ne contient pas 0");
		Test.assertTrue(arbre.contient(2), "L'arbre 1 contient 2");
		Test.assertTrue(arbre.contient(3), "L'arbre 1 contient 3");
	}



}
