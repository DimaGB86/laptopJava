//import java.util.*;

import java.util.Map;

class Laptop {
    private String brand;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Laptop(String brand, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public boolean meetsCriteria(Map<String, Object> criteria) {
        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            switch (key) {
                case "RAM":
                    if (ram < (int) value) return false;
                    break;
                case "Storage":
                    if (storage < (int) value) return false;
                    break;
                case "OS":
                    if (!os.equals(value)) return false;
                    break;
                case "Color":
                    if (!color.equals(value)) return false;
                    break;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + ", RAM: " + ram + "GB, Storage: " + storage + "GB, OS: " + os + ", Color: " + color;
    }
}

