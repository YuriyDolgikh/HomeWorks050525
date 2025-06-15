package lesson22.service;

import lesson22.config.CatalogConfig;
import lesson22.model.Product;
import lesson22.repository.ProductRepository;

public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public String addProduct(String catalogNumber, String brand, String category, String name, double price) {
        if (catalogNumber == null || brand == null || category == null || name == null) {
            return CatalogConfig.ERR_FIELD_IS_NULL;
        }
        if (catalogNumber.isBlank() || brand.isBlank() || category.isBlank() || name.isBlank()) {
            return CatalogConfig.ERR_FIELD_IS_BLANC;
        }
        if (price < 0) {
            return CatalogConfig.ERR_PRICE_IS_NOT_POSITIVE;
        }
        if (repository.findProductByCatalogNumber(catalogNumber) != null) {
            return CatalogConfig.ERR_ALREADY_EXISTS;
        }
        Product product = new Product(catalogNumber, brand, category, name, price);
        if (repository.addProduct(product)) {
            return CatalogConfig.MSG_SUCCESSFULLY;
        } else {
            return CatalogConfig.ERR_NOT_BE_ADDED;
        }

    }

    public Product findByCatalogNumber(String catalogNumber) {
        if (catalogNumber == null || catalogNumber.isBlank()) {
            return null;
        }
        return repository.findProductByCatalogNumber(catalogNumber);
    }

    public Product findByName(String name) {
        if (name == null || name.isBlank()) {
            return null;
        }
        return repository.findProductByName(name);
    }

    public Product[] findByBrand(String brand) {
        if (brand == null || brand.isBlank()) {
            return null;
        }
        return repository.findByBrand(brand);
    }

    public Product[] findByCategory(String category) {
        if (category == null || category.isBlank()) {
            return null;
        }
        return repository.findByCategory(category);
    }

    public Product[] findByBrandAndCategory(String brand, String category) {
        if (brand == null || brand.isBlank() || category == null || category.isBlank()) {
            return null;
        }
        return repository.findByBrandAndCategory(brand, category);
    }

    public Product[] findByPriceRange(double minPrice, double maxPrice) {
        if (minPrice < 0 || maxPrice < 0) {
            return null;
        }
        if (maxPrice < minPrice) {
            double temp = maxPrice;
            maxPrice = minPrice;
            minPrice = temp;
        }
        return repository.findProductsByPriceRange(minPrice, maxPrice);
    }

    public Product[] getAllProducts() {
        return repository.findAll();
    }

    public int getCurrentQuantity() {
        return repository.getCurrentQuantity();
    }

    public void fillSimpleProducts() {
        addProduct("A101", "Samsung", "Refrigerator", "SM-185NF", 512.00);
        addProduct("A102", "LG", "Refrigerator", "L-15D", 456.00);
        addProduct("A123", "Indesit", "Refrigerator", "iS-2378", 399.00);
        addProduct("P050", "Samsung", "Smartphone", "Galaxy A54s", 300.00);
        addProduct("P034", "Samsung", "Smartphone", "Galaxy S25", 1200.00);
        addProduct("P102", "Apple", "Smartphone", "iPhone 13", 700.00);
        addProduct("P112", "Apple", "Smartphone", "iPhone 16", 1480.00);
        addProduct("N123", "ASUS", "Laptop", "ASUS-i55121", 780.00);
    }
}
