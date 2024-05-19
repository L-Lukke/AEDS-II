import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class Player implements Comparable<Player> {

    private int id;
    private String name;
    private int height;
    private int weight;
    private String college;
    private int birthYear;
    private String birthCity;
    private String birthState;

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Player(int id, String name, int height, int weight, String college, int birthYear,
            String birthCity, String birthState) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.college = college;
        this.birthYear = birthYear;
        this.birthCity = birthCity;
        this.birthState = birthState;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public String getBirthState() {
        return birthState;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    public void imprimir() {
        System.out.println("[" + id + " ## " + name + " ## " + height + " ## " + weight + " ## "
                + birthYear + " ## " + college + " ## " + birthCity + " ## " + birthState + "]");
    }

    public void ler(String id) throws Exception {

        try {
            File file = new File("/tmp/players.csv");
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String[] line = sc.nextLine().split(",", -1);
                if (line[0].equals(id)) {
                    for (int i = 0; i < line.length; i++) {
                        if (line[i].equals("")) {
                            line[i] = "nao informado";
                        }
                    }
                    this.setId(Integer.parseInt(line[0]));
                    this.setName(line[1]);
                    this.setHeight(Integer.parseInt(line[2]));
                    this.setWeight(Integer.parseInt(line[3]));
                    this.setCollege(line[4]);
                    this.setBirthYear(Integer.parseInt(line[5]));
                    this.setBirthCity(line[6]);
                    this.setBirthState(line[7]);
                }
            }
            sc.close();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public int compareTo(Player otherPlayer) {
        return this.name.compareTo(otherPlayer.name);
    }

}

public class TP02Q09 {
    static final String OUTPUT_FILE_NAME = "matricula_heapsort.txt";
    static int comparisons = 0;
    static int movimentations = 0;

    public static void main(String[] args) throws Exception {
        lerAuxiliar();
    }

    public static void lerAuxiliar() throws Exception {
        Player[] playersVetor = new Player[5000];
        int playerCountControl = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine().trim();
            if (input.equals("FIM")) {
                break;
            }
            Player player = new Player();
            player.ler(input);
            playersVetor[playerCountControl] = player;
            playerCountControl++;
        }
        long startTime = System.currentTimeMillis();
        sortByHeight(playersVetor, playerCountControl);
        long endTime = System.currentTimeMillis();
        for (int i = 0; i < playerCountControl; i++) {
            playersVetor[i].imprimir();
        }
        writeMatricula(endTime - startTime);

        sc.close();

    }

    private static void writeMatricula(long executionTime) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME))) {
            writer.write("Matrícula: 746733\tNúmero de comparações: " + comparisons
                    + "\tNúmero de movimentações: " + movimentations
                    + "\tTempo de execução do algoritmo de ordenação: " + executionTime + "ms");
        } catch (Exception ex) {
            System.out.println("Erro saida.txt " + ex.getMessage());
        }
    }

    private static void sortByHeight(Player[] players, int playerCountControl) {
        buildMaxHeap(players, playerCountControl);

        for (int i = playerCountControl - 1; i >= 0; i--) {
            Player temp = players[0];
            players[0] = players[i];
            players[i] = temp;
            movimentations++;

            maxHeapify(players, 0, i);
        }
    }

    private static void buildMaxHeap(Player[] players, int playerCountControl) {
        for (int i = (playerCountControl / 2) - 1; i >= 0; i--) {
            maxHeapify(players, i, playerCountControl);
        }
    }

    private static void maxHeapify(Player[] players, int i, int playerCountControl) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < playerCountControl && players[leftChild].getHeight() > players[largest].getHeight()) {
            largest = leftChild;
        } else if (leftChild < playerCountControl && players[leftChild].getHeight() == players[largest].getHeight()
                && players[leftChild].getName().compareTo(players[largest].getName()) > 0) {
            largest = leftChild;
        }

        if (rightChild < playerCountControl && players[rightChild].getHeight() > players[largest].getHeight()) {
            largest = rightChild;
        } else if (rightChild < playerCountControl && players[rightChild].getHeight() == players[largest].getHeight()
                && players[rightChild].getName().compareTo(players[largest].getName()) > 0) {
            largest = rightChild;
        }

        if (largest != i) {
            Player temp = players[i];
            players[i] = players[largest];
            players[largest] = temp;
            maxHeapify(players, largest, playerCountControl);
        }
    }
}