package javaBasicCourse.lesson09.goods;

import utils.UserInput;

public class GoodsService {

    public Category createCategory() {
        UserInput userInput = new UserInput();
        String categoryName = userInput.inputText("Enter category name");
        String categoryDescription = userInput.inputText("Enter category description");
        return new Category(categoryName, categoryDescription);
    }

    public Goods createGoods(Category category) {
        UserInput userInput = new UserInput();
        String goodsName = userInput.inputText("Enter goods name");
        double goodsPrice = userInput.inputDouble("Enter goods price");
        int goodsQuantity = userInput.inputInt("Enter goods quantity");
        return new Goods(goodsName, category, goodsPrice, goodsQuantity);
    }
}
