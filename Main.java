import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Asus", 8, 512, "Windows10", "Black"));
        laptops.add(new Laptop("HP", 16, 256, "Linux", "Silver"));
        laptops.add(new Laptop("Apple", 16, 1024, "macOS", "Space Gray"));
        laptops.add(new Laptop("Lenovo", 64, 1024, "Windows11", "white"));

        Map<String, Object> filterCriteria = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите критерии фильтра: ");
        System.out.println("1. Объем опретивной памяти:");
        System.out.println("2. Объем ЖД:");
        System.out.println("3. Операционная система:");
        System.out.println("4. Цвет:");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Введите минимальный требуемый объем оперативной памяти: ");
                int minRam = scanner.nextInt();
                filterCriteria.put("RAM", minRam);
                break;
            case 2:
                System.out.print("Введите минимальный требуемый объем ЖД: ");
                int minStorage = scanner.nextInt();
                filterCriteria.put("Storage", minStorage);
                break;
            case 3:
                System.out.print("Введите необходимую ОС: ");
                String requiredOS = scanner.next();
                filterCriteria.put("OS", requiredOS);
                break;
            case 4:
                System.out.print("Введите нужный цвет: ");
                String requiredColor = scanner.next();
                filterCriteria.put("Color", requiredColor);
                break;
            default:
                System.out.println("Неверный выбор.");
        }

        Set<Laptop> filteredLaptops = new HashSet<>();
        for (Laptop laptop : laptops) {
            if (laptop.meetsCriteria(filterCriteria)) {
                filteredLaptops.add(laptop);
            }
        }

        System.out.println("\nОтфильтрованные ноутбуки:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }
    }
}