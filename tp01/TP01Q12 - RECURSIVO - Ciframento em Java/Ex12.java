class Ex12 {
    public static boolean isFim(String word) {
		if (word.equals("FIM"))
			return false;
		else 
			return true;
	}

    public static String cypher(String word, String scrambled, int count) {
        if (count == word.length())
            return scrambled;
        else
            scrambled += (char)((int)word.charAt(count) + 3);
            return cypher(word, scrambled, ++count);
    }

	public static void main(String[] args) {
        
        String word;
        String scrambled = "";
        
        word = MyIO.readLine();

        while (isFim(word)) {

            scrambled = cypher(word, scrambled, 0);

            MyIO.println(scrambled);

            scrambled = "";

            word = MyIO.readLine();
        }
    }
}
