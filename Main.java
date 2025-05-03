public class Main {
    public static void main(String[] args) {
        LotteryBox box = new LotteryBox();
        box.putToy("1 2 konstructor");
        box.putToy("2 2 robot");
        box.putToy("3 6 doll");
        box.getAndSave10("results.txt");
    }
}
