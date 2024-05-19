class Ex15{

    public static boolean isFim(String word) {
		if (word.equals("FIM"))
			return false;
		else 
			return true;
	}

    public static boolean isVowel(String word, int count, boolean answ) {
        if (count == 0)
            return answ;
        else if(!(word.charAt(count) == 'a' || word.charAt(count) == 'e' || word.charAt(count) == 'i' || word.charAt(count) == 'o' || word.charAt(count) == 'u'))
            return isVowel(word, 0, false);
        else
            return isVowel(word, --count, answ);
    }

    public static boolean isConsonant(String word, int count, boolean answ) {
        if (count == 0)
            return answ;
        else if(!((word.charAt(count) <= 90 && word.charAt(count) >= 65) || (word.charAt(count) <= 122 && word.charAt(count) >= 97) && (!(word.charAt(count) == 'a' || word.charAt(count) == 'e' || word.charAt(count) == 'i' || word.charAt(count) == 'o' || word.charAt(count) == 'u'))))
            return isConsonant(word, 0, false);
        else
            return isConsonant(word, --count, answ);
    }

    public static boolean isInt(String word, int count, boolean answ) {
        if (count == 0)
            return answ;
        else if(word.charAt(count) < 48 || word.charAt(count) > 57)
            return isInt(word, 0, false);
        else
            return isInt(word, --count, answ);
    }

    public static boolean isReal(String word, int count, boolean answ) {
        int test = 0;

        if(word.charAt(count) == 44 || word.charAt(count) == 46)
            test++;
        if (count == 0)
            return answ;
        else if((word.charAt(count) < 48 && word.charAt(count) != 44 && word.charAt(count) != 46) || word.charAt(count) > 57 || test > 1)
            return isReal(word, 0, false);
        else
            return isReal(word, --count, answ);
    }

    public static void main(String[] args) {
		String word= MyIO.readLine();

		while(isFim(word)) {
            int count = word.length()-1;

			if(isVowel(word, count, true))
				System.out.print("SIM ");
			else
				System.out.print("NAO ");

            if(isConsonant(word, count, true))
				System.out.print("SIM ");
			else
				System.out.print("NAO ");

            if(isInt(word, count, true))
				System.out.print("SIM ");
			else
				System.out.print("NAO ");

            if(isReal(word, count, true))
				System.out.println("SIM");
			else
				System.out.println("NAO");

			word = MyIO.readLine();
		}
	}

}
