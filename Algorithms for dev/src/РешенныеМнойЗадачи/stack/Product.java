package РешенныеМнойЗадачи.stack;

public class Product {

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    private int price;
    private String name;

    public Product(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
