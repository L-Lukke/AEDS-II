class Ex3 {

    public static boolean isFim(String word) {
		if (word.equals("FIM"))
			return false;
		else 
			return true;
	}

    public static String cypher(String word) {
        String scrambled = "";
		for(int i = 0; i < word.length(); i++){
			scrambled += (char)((int)word.charAt(i) + 3);
		}
		return scrambled;
    }

	public static void main(String[] args) {
        
        String word;
        String scrambled;
        
        word = MyIO.readLine();

        while (isFim(word)) {

            scrambled = cypher(word);

            MyIO.println(scrambled);

            word = MyIO.readLine();
        }
    }
}