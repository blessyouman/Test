import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Storage storage = Storage.loadFromFile("storage.dat");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n    Система управления складом");
            System.out.println("1. Добавить товар");
            System.out.println("2. Показать все товары");
            System.out.println("3. Найти товар");
            System.out.println("4. Сохранить склад в файл");
            System.out.println("5. Выйти");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Введите название товара: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите количество: ");
                    int amount = scanner.nextInt();
                    storage.addItem(name, amount);
                }
                case 2 -> storage.printItems();
                case 3 -> {
                    System.out.print("Введите название товара: ");
                    String searchName = scanner.nextLine();
                    storage.findItem(searchName);
                }
                case 4 -> storage.saveToFile("storage.dat");
                case 5 -> {
                    System.out.println("Выход из программы.");
                    return;
                }
                default -> System.out.println("Неверная опция");
            }
        }
    }
}
