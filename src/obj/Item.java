package obj;

public class Item {
    private String name;
    private double price;
    private double saleprice;
    private String type;
    private String style;

    public Item() {
    }

    public Item(String name, double price, double saleprice, String type, String style) {
        this.name = name;
        this.price = price;
        this.saleprice = saleprice;
        this.type = type;
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(double saleprice) {
        this.saleprice = saleprice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", price=" + price + ", saleprice=" + saleprice + ", type=" + type + ", style=" + style + '}';
    }
    
}
