import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Storage storage1 = new Storage();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n    Система управления складом");
            System.out.println("1. Добавить товар");
            System.out.println("2. Показать все товары");
            System.out.println("3. Найти товар");
            System.out.println("4. Выйти");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите название товара: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите количество: ");
                    int amount = scanner.nextInt();
                    storage1.addItem(name, amount);
                    break;
                case 2:
                    storage1.printItems();
                    break;
                case 3:
                    System.out.print("Введите название товара: ");
                    String searchName = scanner.nextLine();
                    storage1.findItem(searchName);
                    break;
                case 4:
                    System.out.println("Выход из программы");
                    return;
                default:
                    System.out.println("Неверная опция");
            }
        }
    }
}
