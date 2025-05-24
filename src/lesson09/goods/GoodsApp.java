package lesson09.goods;

public class GoodsApp {
    public static void main(String[] args) {
        GoodsService goodsService = new GoodsService();
        Category category1 = goodsService.createCategory();
        Category category2 = goodsService.createCategory();
        Goods goods1 = goodsService.createGoods(category1);
        Goods goods2 = goodsService.createGoods(category1);
        Goods goods3 = goodsService.createGoods(category2);
        System.out.println(goods1);
        System.out.println(goods2);
        System.out.println(goods3);
    }
}
