package javaBasicCourse.lesson09.goods;

public class Goods {
    private String goodsName;
    private Category goodsCategory;
    private double price;
    private int quantity;

    public Goods(String goodsName, Category goodsCategory, double price, int quantity) {
        this.goodsName = goodsName;
        this.goodsCategory = goodsCategory;
        this.price = price;
        this.quantity = quantity;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public Category getGoodsCategory() {
        return goodsCategory;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", goodsCategory=" + goodsCategory +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
