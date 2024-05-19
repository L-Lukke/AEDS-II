import java.io.*;
import java.net.*;

class Ex7 {
    public static String getHtml(String endereco) 
    {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(endereco);
            is = url.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            is.close();
        } catch (IOException ioe) {
            // nothing to see here

        }

        return resp;
    }
    public static void main(String[] args) 
    {
        String aux = "áéíóúàèìòùãõâêîôû";
        String endereco, res;
        String nomeSite;
        while (true) 
        {
            nomeSite = MyIO.readLine();
            if (nomeSite.equals("FIM")) 
            {
                break;
            }
            else
            endereco = MyIO.readLine();
            res = getHtml(endereco);
            vogal(res);
            vogagudo(res,aux);
            vogacento(res,aux);
            consoante(res);
            brtable(res);
            MyIO.println( nomeSite);    
        }
        

    }
    public static void vogal(String res) {
        int conta = 0;
        int conte = 0;
        int conti = 0;
        int conto = 0;
        int contu = 0;
        for (int i = 0; i < res.length() - 1; i++) 
        {
            switch (res.charAt(i)) 
            {
                case 'a':
                    conta++;
                    break;
                case 'e':;
                    conte++;
                    break;
                case 'i':;
                    conti++;
                    break;
                case 'o':;
                    conto++;
                    break;
                case 'u':;
                    contu++;
                    break;
            }
            
        }
      MyIO.print("a(" + conta +") ");
      MyIO.print("e(" + conte +") ");
      MyIO.print("i(" + conti +") ");
      MyIO.print("o(" + conto +") ");
      MyIO.print("u(" + contu +") ");
    }
    public static void vogagudo(String res, String aux) {
        int conta = 0;//á
        int conte = 0;//é
        int conti = 0;//í
        int conto = 0;//ó
        int contu = 0;//ú
        int conta2 = 0;//à
        int conte2 = 0;//è
        int conti2 = 0;//ì
        int conto2 = 0;//ò
        int contu2 = 0;//ù
        //á  é  í  ó  ú  à  é  ì  ò  ù  ã   õ   â   ê   î   ô  û
        //0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16 (índice das letras)

        for (int i = 0; i < res.length(); i++) 
        {
            if (res.charAt(i)==aux.charAt(0)) 
            {
                conta++;
            }
            else if (res.charAt(i)==aux.charAt(1)) 
            {
                conte++;
            }
            else if (res.charAt(i)==aux.charAt(2)) 
            {
                conti++;
            }
            else if (res.charAt(i)==aux.charAt(3)) 
            {
                conto++;
                
            }
            else if (res.charAt(i)==aux.charAt(4)) 
            {
                contu++;
            }
            if (res.charAt(i)==aux.charAt(5)) 
            {
                conta2++;
            }
            else if (res.charAt(i)==aux.charAt(6)) 
            {
                conte2++;
            }
            else if (res.charAt(i)==aux.charAt(7)) 
            {
                conti2++;
            }
            else if (res.charAt(i)==aux.charAt(8)) 
            {
                conto2++;
                
            }
            else if (res.charAt(i)==aux.charAt(9)) 
            {
                contu2++;
            }
        }
        MyIO.print("á(" + conta +") ");
        MyIO.print("é(" + conte +") ");
        MyIO.print("í(" + conti +") ");
        MyIO.print("ó("+ conto +") ");
        MyIO.print("ú(" + contu +") ");
        MyIO.print("à(" + conta2 +") ");
        MyIO.print("è(" + conte2 +") ");
        MyIO.print("ì(" + conti2 +") ");
        MyIO.print("ò(" + conto2 +") ");
        MyIO.print("ù(" + contu2 +") ");
    }
    public static void vogacento(String res,String aux) {
        int contatiu = 0;//ã
        int contotiu = 0;//õ
        int contahat = 0;//â
        int contehat = 0;//ê
        int contihat = 0;//î
        int contohat = 0;//ô
        int contuhat = 0;//û
        //á  é  í  ó  ú  à  é  ì  ò  ù  ã   õ   â   ê   î   ô  û
        //0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16 (índice das letras)
        for (int i = 0; i < res.length(); i++) 
        {
            if (res.charAt(i)==aux.charAt(10)) 
            {
                contatiu++;
            }
            else if (res.charAt(i)==aux.charAt(11)) 
            {
                contotiu++;
            }
            else if (res.charAt(i)==aux.charAt(12)) 
            {
                contahat++;
            }
            else if (res.charAt(i)==aux.charAt(13)) 
            {
                contehat++;
                
            }
            else if (res.charAt(i)==aux.charAt(14)) 
            {
                contihat++;
            }
            else if (res.charAt(i)==aux.charAt(15)) 
            {
                contohat++;
            }
            else if (res.charAt(i)==aux.charAt(16)) 
            {
                contuhat++;
            }
        }
        MyIO.print("ã(" + contatiu +") ");
        MyIO.print("õ(" + contotiu +") ");
        MyIO.print("â(" + contahat +") ");
        MyIO.print("ê(" + contehat +") ");
        MyIO.print("î(" + contihat +") ");
        MyIO.print("ô(" + contohat +") ");
        MyIO.print("û(" + contuhat +")");       
    }
    public static void consoante(String res) 
    {
        int cons = 0;
        for (int i = 0; i < res.length(); i++) 
        {
            if (res.charAt(i)=='a'||
            res.charAt(i)=='e'||
            res.charAt(i)=='i'||
            res.charAt(i)=='o'||
            res.charAt(i)=='u') {}
            else
                cons++;
        }
        
        MyIO.print(" consoante(" + cons +")");
    }
    public static void brtable(String res) 
   {
      int br = 0;
      int table = 0;
        for (int i = 0; i < res.length(); i++) 
        {
            if (res.charAt(i)== '<' && res.charAt(i+1)=='b'
            && res.charAt(i+2)=='r'&& res.charAt(i+3)=='>')
            {
                br++;
                
            }
            else if (res.charAt(i)== '<' && res.charAt(i+1)=='t'
            && res.charAt(i+2)=='a'&& res.charAt(i+3)=='b'
            && res.charAt(i+4)=='l'&& res.charAt(i+5)=='e'
            && res.charAt(i+6)=='>')
            {
                table++;
                
            }
            
        }
        MyIO.print(" <br>(" + br +") ");
        MyIO.print("<table>(" + table +") ");
      
   }
}