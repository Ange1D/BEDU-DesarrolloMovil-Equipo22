fun main() {
    val smartPhone = SmartPhone("Motorola", "G8", "Falcon", 5000f)
    println("El precio del ${smartPhone.name}  ${smartPhone.model} es: $${smartPhone.price}.")

    Stock.addArticles(10)
    println(Stock.getStock())
    Stock.removeArticles(2)
    println(Stock.getStock())
    Stock.addArticles(5)
    println(Stock.getStock())
}

public class Stock {
    protected static int stock = 0;

    public static void addArticles(int articles) {
        stock += articles;
    }

    public static void removeArticles(int articles) {
        stock--;
    }

    public static String getStock() {
        return "Stock disponible: " + stock;
    }
}

public class SmartPhone {
    private String name, model, processor;
    private float price;

    public SmartPhone(String name, String model, String processor, float price) {
        this.name = name;
        this.model = model;
        this.processor = processor;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public float getPrice() {
        return price;
    }
}
