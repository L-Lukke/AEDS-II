class Ex10{

	public static boolean isFim(String word) {
		if (word.equals("FIM"))
			return false;
		else 
			return true;
	}

	public static boolean isPal(String word, int count, boolean answ) {
		if (count >= word.length()/2) 
			return answ;
		else if (word.charAt(count) == word.charAt((word.length() - 1) - count))
			return isPal(word, ++count, answ);
		else
			return isPal(word, word.length()-1, false);
	}

	public static void main(String[] args) {
		String word;

		word = MyIO.readLine();

		while(isFim(word)) {

			if(isPal(word, 0,  true))
				System.out.println("SIM");
			else
				System.out.println("NAO");

			word = MyIO.readLine();
		}
	}
}