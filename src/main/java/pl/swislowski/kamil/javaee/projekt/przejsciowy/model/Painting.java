package pl.swislowski.kamil.javaee.projekt.przejsciowy.model;

public class Painting {
    private static final double PI = 3.14;
    private String title;
    private String author;
    private String height;
    private String width;
    private String radius;
    private String nonCircleField;
    private String circleField;
    private String weight;
    private String price;
    private String category;

    public Painting() {
    }

    public Painting(String title, String author, String radius, String circleField, String weight, String price, String category) {
        this.title = title;
        this.author = author;
        this.radius = radius;
        this.circleField = circleField;
        this.weight = weight;
        this.price = price;
        this.category = category;
    }

    public Painting(String title, String author, String height, String width, String nonCircleField, String weight, String price, String category) {
        this.title = title;
        this.author = author;
        this.height = height;
        this.width = width;
        this.nonCircleField = nonCircleField;
        this.weight = weight;
        this.price = price;
        this.category = category;
    }

    public static double getPI() {
        return PI;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getNonCircleField() {
        return nonCircleField;
    }

    public void setNonCircleField(String nonCircleField) {
        this.nonCircleField = nonCircleField;
    }

    public String getCircleField() {
        return circleField;
    }

    public void setCircleField(String circleField) {
        this.circleField = circleField;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Painting{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", height='" + height + '\'' +
                ", width='" + width + '\'' +
                ", radius='" + radius + '\'' +
                ", nonCircleField='" + nonCircleField + '\'' +
                ", circleField='" + circleField + '\'' +
                ", weight='" + weight + '\'' +
                ", price='" + price + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
