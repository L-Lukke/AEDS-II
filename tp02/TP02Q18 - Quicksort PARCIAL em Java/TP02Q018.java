import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class Node {
    public Player player;
    public Node next;

    public Node() { this(new Player()); }

    public Node(Player player) {
        this.player = player;
        this.next = null;
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
        last.next = new Node(player);
        last = last.next;
    }

    public Node getFirst() {
        return first;
    }

    public int size() {
        int size = 0;
        for (Node i = first.next; i != null; i = i.next , size++);
        return size;
    }

    public void printList() {
		for (Node i = first.next; i != null; i = i.next) i.player.printPlayer();
	}

    public void printList(int k) {
        int count = 0;
		for (Node i = first.next; i != null && count < k; i = i.next, count++) i.player.printPlayer();
	}

    public void partialMergeSort(int k) {
        if (k > 0) {
            first = mergeSort(first, k);
        }
    }

    private Node mergeSort(Node head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        
        // Split the list into two halves
        Node mid = findMiddle(head);
        Node nextOfMid = mid.next;
        mid.next = null;
        
        // Recursive sort the first half
        Node left = mergeSort(head, k);
        
        // Recursive sort the second half
        Node right = mergeSort(nextOfMid, k - 1);
        
        // Merge the sorted halves
        return merge(left, right);
    }

    private Node findMiddle(Node node) {
        Node slow = node;
        Node fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;
        
        if (left.player.getBirthState().compareTo(right.player.getBirthState()) <= 0) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
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


public class TP02Q018 {
    private static void writeMatricula(long totalTime, int movimentations) {
        String OUTPUT_FILE_NAME = "matricula_quicksort.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME))) {
            writer.write("Matrícula: 746733\tNumero de movimentações: " + movimentations
                    + "\tTempo de execucao: " + totalTime + "ms");
        } catch (Exception e) {
            System.out.println("Erro saida.txt " + e.getMessage());
        }
    }
        
    public static void main(String [] args) throws Exception {
        Player token = new Player();
        List playerList = new List();
        String aux;
        Scanner sc = new Scanner(System.in);
        aux = sc.nextLine();
        int k = 10;

        while(!(aux.contains("FIM"))) {
            token.ler(aux.trim());
            playerList.insert(token.clone());
            aux = sc.nextLine();
        }

        long startTime = System.currentTimeMillis();
        playerList.partialMergeSort(k);
        long endTime = System.currentTimeMillis();

        playerList.printList(k);
        writeMatricula(endTime - startTime, List.movimentations);
        sc.close();
    }
}


