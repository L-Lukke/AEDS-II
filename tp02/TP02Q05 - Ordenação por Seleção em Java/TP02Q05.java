import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class Node {
    public Player player;
    public Node prox;

    public Node() { this(new Player()); }

    public Node(Player player) {
        this.player = player;
        this.prox = null;
    }
}


class List {
    private Node first;
    private Node last;
    static int movimentations = 0;

    public List() {
        first = new Node();
        last = first;
    }

    public void insert(Player player) {
        last.prox = new Node(player);
        last = last.prox;
    }

    public boolean searchName(String name) {
        boolean answ = false;
        for (Node i = first.prox; i != null; i = i.prox) {
            if (i.player.getName().equals(name)) {
                answ = true;
                i = last;
            }
        }
        return answ;
    }

    public void printList() {
		for (Node i = first.prox; i != null; i = i.prox) i.player.printPlayer();
	}

    public void sortByName() {
        Node current = first.prox;
        while (current != null) {
            Node min = current;
            Node next = current.prox;

            while (next != null) {
                if (next.player.getName().compareTo(min.player.getName()) < 0) min = next;
                next = next.prox;
            }

            if (min != current) {
                Player temp = current.player;
                current.player = min.player;
                min.player = temp;
                movimentations++; 
            }

            current = current.prox;
        }
    }
}


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

    public void printPlayer() {
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

            for(int i = 0; i < 8; i++) if (aux[i].contains("*")) aux[i].replace("*", "");

            for(int i = 0; i < 8; i++) aux[i].trim();
            
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




public class TP02Q05 {
    private static void writeMatricula(long totalTime, int movimentations) {
        String OUTPUT_FILE_NAME = "matrícula_selecao.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME))) {
            writer.write("Matrícula: 746733\tNumero de movimentações: " + movimentations
                    + "\tTempo de execucao: " + totalTime + "ms");
        } catch (Exception e) {
            System.out.println("Erro saida.txt " + e.getMessage());
        }
    }
        
    public static void main(String [] args) throws Exception {    
        long totalTime = 0;
        Player token = new Player();
        List playerList = new List();
        String aux;
        Scanner sc = new Scanner(System.in);
        aux = sc.nextLine();

        while(!(aux.contains("FIM"))) {
            token.ler(aux.trim());
            playerList.insert(token.clone());
            aux = sc.nextLine();
            playerList.sortByName();
        }

        playerList.printList();
        writeMatricula(totalTime, List.movimentations);
        sc.close();
    }
}