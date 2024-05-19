import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
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
    static HashMap<Integer, Player> playersHash = new HashMap<>();

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

    public Player(int id, String name, int height, int weight, String college, int birthYear, String birthCity,
            String birthState) {
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
        System.out.println("[" + id + " ## " + name + " ## " + height + " ## " + weight +
                " ## " + birthYear + " ## " + college + " ## " + birthCity + " ## " + birthState + "]");
    }

    public static void ler() {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("/tmp/players.csv"));
            bf.readLine();
            String linha;
            while ((linha = bf.readLine()) != null) {
                String[] arr = linha.split(",", -1);
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].equals("")) {
                        arr[i] = "nao informado";
                    }
                }
                Player player = new Player(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]),
                        Integer.parseInt(arr[3]), arr[4], Integer.parseInt(arr[5]), arr[6], arr[7]);
                player.setName(player.getName().replace("*", ""));
                Player.playersHash.put(player.getId(), player);
                Player.playersHash.put(player.getId(), player);
            }
            bf.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

public class Q1 {
    public static void main(String[] args) {
        Player.ler();
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();
        while (!entrada.equals("FIM")) {
            int key = Integer.parseInt(entrada);
            Player player = Player.playersHash.get(key);
            if (player != null) {
                player.imprimir();
            } else {
                System.out.println("Player with ID " + key + " not found.");
            }
            entrada = scanner.nextLine();
        }
        scanner.close();
    }
}