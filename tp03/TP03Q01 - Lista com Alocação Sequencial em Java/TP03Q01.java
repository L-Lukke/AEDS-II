
import java.util.Scanner;
import java.io.File;

class Player {
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

    public void imprimir2(int index) {
        System.out.println("[" + index + "]" + " ## " + name + " ## " + height + " ## " + weight + " ## "
                + birthYear + " ## " + college + " ## " + birthCity + " ## " + birthState + " ##");
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

}

class Node {
    Player Player;
    Node next;

    public Node(Player Player) {
        this.Player = Player;
        this.next = null;
    }
}

class ListaPlayeres {
    private Node head;

    public int tamanho() {
        int tamanho = 0;
        Node current = head;
        while (current != null) {
            tamanho++;
            current = current.next;
        }
        return tamanho;
    }

    public ListaPlayeres() {
        this.head = null;
    }

    public void inserirInicio(Player Player) {
        Node newNode = new Node(Player);
        newNode.next = head;
        head = newNode;
    }

    public void inserir(Player player, int posicao) {
        if (posicao < 0 || posicao > tamanho()) {
            System.out.println("Posição inválida para inserção.");
            return;
        }

        Node newNode = new Node(player);

        if (posicao == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        Node previous = null;

        for (int i = 0; i < posicao && current != null; i++) {
            previous = current;
            current = current.next;
        }

        newNode.next = current;
        previous.next = newNode;
    }

    public void inserirFim(Player Player) {
        Node newNode = new Node(Player);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public Player removerInicio() {
        if (head == null) {
            System.out.println("Lista vazia. Não é possível remover.");
            return null;
        }

        Node removedNode = head;
        head = head.next;
        return removedNode.Player;
    }

    public Player remover(int posicao) {
        if (head == null) {
            System.out.println("Lista vazia. Não é possível remover.");
            return null;
        }

        if (posicao == 0) {
            return removerInicio();
        }

        Node current = head;
        for (int i = 0; i < posicao - 1 && current.next != null; i++) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Posição inválida para remoção.");
            return null;
        }

        Node removedNode = current.next;
        current.next = current.next.next;
        return removedNode.Player;
    }

    public Player removerFim() {
        if (head == null) {
            System.out.println("Lista vazia. Não é possível remover.");
            return null;
        }

        if (head.next == null) {
            Node removedNode = head;
            head = null;
            return removedNode.Player;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        Node removedNode = current.next;
        current.next = null;
        return removedNode.Player;
    }

    public void imprimir() {
        Node current = head;
        int index = 0;

        while (current != null) {
            current.Player.imprimir2(index);
            current = current.next;
            index++;
        }
    }
}

public class TP03Q01 {
    public static void main(String[] args) throws Exception {
        lerAuxiliar();
    }

    public static void lerAuxiliar() throws Exception {
        ListaPlayeres lista = new ListaPlayeres();
        Scanner sc = new Scanner(System.in);

        String id = sc.next();

        while (!id.contains("FIM")) {
            Player token = new Player(); // Criar uma nova instância de Player a cada iteração
            token.ler(id.trim());
            lista.inserirFim(token);
            id = sc.next();
        }

        int numOperacoes = sc.nextInt();
        sc.nextLine(); // Consumir a quebra de linha após o número de operações

        for (int i = 0; i < numOperacoes; i++) {
            String comando = sc.next(); // Modificado para ler apenas a palavra de comando

            switch (comando) {
                case "I":
                    Player playerFim = new Player();
                    playerFim.ler(sc.next());
                    lista.inserirFim(playerFim);
                    break;
                case "R":
                    Player removidoFim = lista.removerFim();
                    if (removidoFim != null) System.out.println("(R) " + removidoFim.getName());
                    break;
                default:
                    System.out.println("Comando inválido.");
            }
        }
        lista.imprimir();

        sc.close();
    }
}