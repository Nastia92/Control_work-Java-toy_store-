import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LotteryBox {
    private PriorityQueue<Toy> toyQueue = new PriorityQueue<>();
    private Random random = new Random();

    public void putToy(String input) {
        String[] parts = input.split(" ");
        int id = Integer.parseInt(parts[0]);
        int weight = Integer.parseInt(parts[1]);
        String name = parts[2];
        toyQueue.add(new Toy(id, name, weight));
    }

    public Toy getRandomToy() {
        List<Toy> toys = new ArrayList<>(toyQueue); // копируем элементы
        int totalWeight = toys.stream().mapToInt(t -> t.weight).sum();
        int rand = random.nextInt(totalWeight);
        for (Toy toy : toys) {
            rand -= toy.weight;
            if (rand < 0) {
                return toy;
            }
        }
        return null;
    }

    public void getAndSave10(String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            for (int i = 0; i < 10; i++) {
                Toy prize = getRandomToy();
                writer.write(prize.toString() + "\n");
                System.out.println("Выдано: " + prize);
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл.");
        }
    }
}