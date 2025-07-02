package javaBasicCourse.lesson22.repository;

import javaBasicCourse.lesson22.model.Product;

import java.util.Arrays;

public class ProductRepository {
    private Product[] catalog;
    private int currentCatalogSize;

    public ProductRepository(int catalogCapacity) {
        this.catalog = new Product[catalogCapacity];
        this.currentCatalogSize = 0;
    }

    public boolean addProduct(Product product) {
        if (currentCatalogSize >= catalog.length) {
            return false;
        }
        catalog[currentCatalogSize++] = product;
        return true;
    }


    public Product findProductByCatalogNumber(String catalogNumber) {
        for (int i = 0; i < currentCatalogSize; i++) {
            Product currentProductFromCatalog = catalog[i];
            if (currentProductFromCatalog.getCatalogNumber().equalsIgnoreCase(catalogNumber)) {
                return currentProductFromCatalog;
            }
        }
        return null;
    }

    public Product[] findByBrand(String brand) {
        int productsByBrandCounter = 0;

        for (int i = 0; i < currentCatalogSize; i++) {
            if (catalog[i].getBrand().equalsIgnoreCase(brand)) {
                productsByBrandCounter++;
            }
        }

        Product[] productsByBrand = new Product[productsByBrandCounter];
        int index = 0;

        for (int i = 0; i < currentCatalogSize; i++) {
            if (catalog[i].getBrand().equalsIgnoreCase(brand)) {
                productsByBrand[index++] = catalog[i];
            }
        }
        return productsByBrand;
    }

    public Product[] findByCategory(String category) {
        int productsByCategoryCounter = 0;

        for (int i = 0; i < currentCatalogSize; i++) {
            if (catalog[i].getCategory().equalsIgnoreCase(category)) {
                productsByCategoryCounter++;
            }
        }

        Product[] productsByCategory = new Product[productsByCategoryCounter];
        int index = 0;

        for (int i = 0; i < currentCatalogSize; i++) {
            if (catalog[i].getCategory().equalsIgnoreCase(category)) {
                productsByCategory[index++] = catalog[i];
            }
        }
        return productsByCategory;
    }

    public Product[] findByBrandAndCategory(String brand, String category) {
        int productsCounter = 0;

        for (int i = 0; i < currentCatalogSize; i++) {
            if (catalog[i].getCategory().equalsIgnoreCase(category) && catalog[i].getBrand().equalsIgnoreCase(brand)) {
                productsCounter++;
            }
        }
        Product[] productsByBrandAndCategory = new Product[productsCounter];
        int index = 0;

        for (int i = 0; i < currentCatalogSize; i++) {
            if (catalog[i].getCategory().equalsIgnoreCase(category) && catalog[i].getBrand().equalsIgnoreCase(brand)) {
                productsByBrandAndCategory[index++] = catalog[i];
            }
        }
        return productsByBrandAndCategory;
    }

    public Product findProductByName(String name) {
        for (int i = 0; i < currentCatalogSize; i++) {
            Product currentProductFromCatalog = catalog[i];
            if (currentProductFromCatalog.getName().equalsIgnoreCase(name)) {
                return currentProductFromCatalog;
            }
        }
        return null;
    }

    public Product[] findProductsByPriceRange(double minPrice, double maxPrice) {
        if(minPrice < 0 || maxPrice < 0) {
            return null;
        }
        int productsByPriceRangeCounter = 0;
        for (int i = 0; i < currentCatalogSize; i++) {
            if (catalog[i].getPrice() >= minPrice && catalog[i].getPrice() <= maxPrice) {
                productsByPriceRangeCounter++;
            }
        }
        Product[] productsByPriceRange = new Product[productsByPriceRangeCounter];
        int index = 0;
        for (int i = 0; i < currentCatalogSize; i++) {
            if (catalog[i].getPrice() >= minPrice && catalog[i].getPrice() <= maxPrice) {
                productsByPriceRange[index++] = catalog[i];
            }
        }
        return productsByPriceRange;
    }

    public Product[] findAll(){
        return Arrays.copyOf(catalog, currentCatalogSize);
    }

    public int getCurrentQuantity() {
        return currentCatalogSize;
    }
}
