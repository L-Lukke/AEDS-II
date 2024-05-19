import java.util.Random;

class Ex4 {

    public static boolean isFim(String phrase) {
		if (phrase.equals("FIM"))
			return false;
		else 
			return true;
	}

    public static char randomLetter() {
        Random random = new Random();
        random.setSeed(4);
        char randomizedCharacter = (char) ('a' + random.nextInt()%26);

        return randomizedCharacter;
    }

    public static String tradeLetters(String phrase) {
        char letter1 = randomLetter();
        char letter2 = randomLetter();
        String randPhrase = "";        

        for(int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == letter1) {
                randPhrase += letter2;
            }
            else {
                randPhrase += phrase.charAt(i);
            }
        }

        return randPhrase;
    }
    public static void main(String[] args) {
		String phrase;
        String randPhrase;

		phrase = MyIO.readLine();

		while(isFim(phrase)) {
			randPhrase = tradeLetters(phrase);
			MyIO.println(randPhrase);

			phrase = MyIO.readLine();
		}
	}
}