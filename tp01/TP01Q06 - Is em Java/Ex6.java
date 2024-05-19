class Ex6{

    public static boolean isFim(String word) {
		if (word.equals("FIM"))
			return false;
		else 
			return true;
	}

    public static boolean isVowel(String word) {
        boolean resp = true;
        for(int i = 0; i < word.length(); i++)
            if(!(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u'))
                resp = false;

        return resp;
    }

    public static boolean isConsonant(String word) {
        boolean resp = true;
        for(int i = 0; i < word.length(); i++)
            if(!((word.charAt(i) <= 90 && word.charAt(i) >= 65) || (word.charAt(i) <= 122 && word.charAt(i) >= 97) && (!(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u'))))
                resp = false;
                
        return resp;
    }

    public static boolean isInt(String word) {
        boolean resp = true;
        for(int i = 0; i < word.length(); i++)
            if(word.charAt(i) < 48 || word.charAt(i) > 57)
                resp = false;
                
        return resp;
    }

    public static boolean isReal(String word) {
        boolean resp = true;
        int cont = 0;
        for(int i = 0; i < word.length(); i++) {
            if((word.charAt(i) < 48 && word.charAt(i) != 44 && word.charAt(i) != 46) || word.charAt(i) > 57)
                resp = false;
            if(word.charAt(i) == 44 || word.charAt(i) == 46)
                cont++;
        }

        if(cont > 1)
            resp = false;

        return resp;
    }

    public static void main(String[] args) {
		String word= MyIO.readLine();

		while(isFim(word)) {
			if(isVowel(word))
				System.out.print("SIM ");
			else
				System.out.print("NAO ");

            if(isConsonant(word))
				System.out.print("SIM ");
			else
				System.out.print("NAO ");

            if(isInt(word))
				System.out.print("SIM ");
			else
				System.out.print("NAO ");

            if(isReal(word))
				System.out.println("SIM");
			else
				System.out.println("NAO");

			word = MyIO.readLine();
		}
	}

}
