import java.io.File;
import java.util.Scanner;

class Player {
    private int id;
    private String name;
    private int height;
    private int weight;
    private String college;
    private int birthYear;
    private String birthCity;
    private String birthState;



    public Player() {}


    public Player(int id, String name, int height, int weight,
    String college, int birthYear, String birthCity, String birthState) {
                
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.college = college;
        this.birthYear = birthYear;
        this.birthCity = birthCity;
        this.birthState = birthState;
    }



    public int getId() { return id; }

    public String getName() { return name; }

    public int getHeight() { return height; }

    public int getWeight() { return weight;}

    public String getCollege() { return college; }

    public int getBirthYear() { return birthYear; }

    public String getBirthCity() { return birthCity; }

    public String getBirthState() { return birthState; }


    public void setId(int id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setHeight(int height) { this.height = height; }

    public void setWeight(int weight) { this.weight = weight; }

    public void setCollege(String college) { this.college = college; }

    public void setBirthYear(int birthYear) { this.birthYear = birthYear; }

    public void setBirthCity(String birthCity) { this.birthCity = birthCity; }

    public void setBirthState(String birthState) { this.birthState = birthState; }



    public Player clone() {
        Player cloned = new Player();

        cloned.id = this.id;
        cloned.name = this.name;
        cloned.height = this.height;
        cloned.weight = this.weight;
        cloned.college = this.college;
        cloned.birthYear = this.birthYear;
        cloned.birthCity = this.birthCity;
        cloned.birthState = this.birthState;

        return cloned;
    }




    public void imprimir() {
        System.out.println("[" + id + " ## " + name + " ## " + height + " ## " + weight + 
        " ## " + birthYear + " ## " + college + " ## " + birthCity + " ## " + birthState + "]");
    }




    public void ler(String id) throws Exception {
        try {
            File file = new File("/tmp/players.csv");
            Scanner sc = new Scanner(file);
            String[] aux;

            do {
                String line = sc.nextLine();
                aux = line.split(",", -1);
            } while (!aux[0].equals(id));

            for(int i = 0; i < 8; i++) if (aux[i].equals("")) aux[i] = "nao informado";
            
            setId(Integer.parseInt(aux[0]));
            setName(aux[1]);
            setHeight(Integer.parseInt(aux[2]));
            setWeight(Integer.parseInt(aux[3]));
            setCollege(aux[4]);
            setBirthYear(Integer.parseInt(aux[5]));
            setBirthCity(aux[6]);
            setBirthState(aux[7]);
            
            sc.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }    
    }
}






public class TP02Q01 {
    public static void main(String [] args) throws Exception {    
        Player token = new Player();
        String id;
        Scanner sc = new Scanner(System.in);
        id = sc.nextLine();

        while(!(id.contains("FIM"))) {
            token.ler(id.trim());
            token.imprimir();
            id = sc.nextLine();
        }

        sc.close();
    }
}