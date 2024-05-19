class Ex1{

	public static boolean isFim(String word) {
		if (word.equals("FIM"))
			return false;
		else 
			return true;
	}

	public static void invert(String word, char[] inverseChar) {
		int tmp = word.length()-1;
		for (int i = 0; i < word.length(); i++, tmp--) {
			inverseChar[tmp] = word.charAt(i);
		}
	}

	public static boolean isPal(String word, char[] inverseChar) {
		boolean resp = true;
		for (int i = 0; i < word.length(); i++) {
			if (!(inverseChar[i] == word.charAt(i)))
			resp = false;
		}
		if (resp)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		String word;
		char[] inverseChar;

		word = MyIO.readLine();

		while(isFim(word)) {

			inverseChar = new char[word.length()];

			invert(word, inverseChar);

			if(isPal(word, inverseChar))
				System.out.println("SIM");
			else
				System.out.println("NAO");

			word = MyIO.readLine();
		}
	}
}