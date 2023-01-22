package myButik.projeсt;

public class Product {
    private String name;
    private double price;
    private String manufacturer;
    private int quantity;
    public RatingProduct ratingProduct = new RatingProduct();

    private final int code;

    public Product(String name, int price, String manufacturer, int quantity) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        code = ArticleNumber.get().getArticle();

    }

    @Override
    public String toString() {
        String rating;
        if (ratingProduct.getRating() == 0) {
            rating = "Отзывов о данном товаре нет";
        } else rating = Double.toString(ratingProduct.getRating());
        return "______________\n" +
                "Наименование товара: '" + name + '\'' + "\n" +
                "Цена: " + price + "\n" +
                "Производитель: '" + manufacturer + '\'' + "\n" +
                "Есть в наличии: " + quantity + " шт." + "\n" +
                "Ретинг: " + rating + "\n" +
                "Код товара: " + code + "\n";
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
