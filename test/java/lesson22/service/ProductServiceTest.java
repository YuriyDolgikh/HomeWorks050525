package lesson22.service;

import javaBasicCourse.lesson22.model.Product;
import javaBasicCourse.lesson22.repository.ProductRepository;
import javaBasicCourse.lesson22.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;
    private ProductService productServiceSmall;

    @BeforeEach
    void setUp() {
        ProductRepository productRepository = new ProductRepository(10);
        productService = new ProductService(productRepository);
        ProductRepository productRepositorySmall = new ProductRepository(1);
        productServiceSmall = new ProductService(productRepositorySmall);
        productService.fillSimpleProducts();
    }

    @Test
    void testAddProductCommonCase() {
        String result = productServiceSmall.addProduct("P050", "Samsung", "Smartphone", "Galaxy A54s", 300.00);
        assertEquals("Product added successfully", result);
    }

    @Test
    void testAddProductNoFreeSpace() {
        String resultOk = productServiceSmall.addProduct("P050", "Samsung", "Smartphone", "Galaxy A54s", 300.00);
        String resultBad = productServiceSmall.addProduct("P034", "Samsung", "Smartphone", "Galaxy S25", 1200.00);
        assertEquals("Product added successfully", resultOk);
        assertEquals("Product could not be added, catalog is full", resultBad);
    }

    @Test
    void testAddProductSomeFieldsIsNull() {
        String result = productServiceSmall.addProduct("P050", "Samsung", null, "Galaxy A54s", 300.00);
        assertEquals("One of the fields is null", result);
    }

    @Test
    void testAddProductSomeFieldsIsBlanc() {
        String result = productServiceSmall.addProduct("P050", "    ", "Smartphone", "", 300.00);
        assertEquals("One of the fields is blank", result);
    }

    @Test
    void testAddProductPriceIsNegative() {
        String result = productServiceSmall.addProduct("P050", "Samsung", "Smartphone", "Galaxy A54s", -300.00);
        assertEquals("Price must be a positive number", result);
    }

    @Test
    void testAddProductAlreadyExists() {
        int quantityBevor = productService.getCurrentQuantity();
        String result = productService.addProduct("P050", "Brand", "Category", "Name", 10.00);
        int quantityAfter = productService.getCurrentQuantity();
        assertEquals("Product with this catalog number already exists", result);
        assertEquals(quantityBevor, quantityAfter);
    }

    @Test
    void testFindByCatalogNumberProductExists() {
        Product product = new Product("P034", "Samsung", "Smartphone", "Galaxy S25", 1200.00);
        assertEquals(product, productService.findByCatalogNumber("P034"));
    }

    @Test
    void testFindByCatalogNumberProductNotExists() {
        assertNull(productService.findByCatalogNumber("P111"));
    }

    @Test
    void testFindByCatalogNumberWhenNumberIsNull() {
        assertNull(productService.findByCatalogNumber(null));
    }

    @Test
    void testFindByCatalogNumberWhenNumberIsBlanc() {
        assertNull(productService.findByCatalogNumber(""));
    }

    @Test
    void testFindByNameProductExists() {
        Product product = new Product("P034", "Samsung", "Smartphone", "Galaxy S25", 1200.00);
        assertEquals(product, productService.findByName("galaxy s25"));
    }

    @Test
    void testFindByNameProductNotExists() {
        assertNull(productService.findByName("Galaxy S20"));
    }

    @Test
    void testFindByNameWhenNameIsNull() {
        assertNull(productService.findByName(null));
    }

    @Test
    void testFindByNameWhenNameIsBlanc() {
        assertNull(productService.findByName(""));
    }

    @Test
    void testFindByBrandProductExists() {
        Product product1 = new Product("A101", "Samsung", "Refrigerator", "SM-185NF", 512.00);
        Product product2 = new Product("P050", "Samsung", "Smartphone", "Galaxy A54s", 300.00);
        Product product3 = new Product("P034", "Samsung", "Smartphone", "Galaxy S25", 1200.00);
        Product[] products = {product1, product2, product3};
        assertArrayEquals(products, productService.findByBrand("Samsung"));
    }

    @Test
    void testFindByBrandProductNotExists() {
        Product[] products = {};
        assertArrayEquals(products, productService.findByBrand("Nokia"));
    }

    @Test
    void testFindByBrandWhenBrandIsNull() {
        assertNull(productService.findByBrand(null));
    }

    @Test
    void testFindByBrandWhenBrandIsBlanc() {
        assertNull(productService.findByBrand(""));
    }

    @Test
    void testFindByCategoryProductExists() {
        Product product1 = new Product("P050", "Samsung", "Smartphone", "Galaxy A54s", 300.00);
        Product product2 = new Product("P034", "Samsung", "Smartphone", "Galaxy S25", 1200.00);
        Product product3 = new Product("P102", "Apple", "Smartphone", "iPhone 13", 700.00);
        Product product4 = new Product("P112", "Apple", "Smartphone", "iPhone 16", 1480.00);
        Product[] products = {product1, product2, product3, product4};
        assertArrayEquals(products, productService.findByCategory("Smartphone"));
    }

    @Test
    void testFindByCategoryProductNotExists() {
        Product[] products = {};
        assertArrayEquals(products, productService.findByCategory("Tablet"));
    }

    @Test
    void testFindByCategoryWhenBrandIsNull() {
        assertNull(productService.findByCategory(null));
    }

    @Test
    void testFindByCategoryWhenBrandIsBlanc() {
        assertNull(productService.findByCategory(""));
    }

    @Test
    void testFindByBrandAndCategoryProductExists() {
        Product product1 = new Product("P102", "Apple", "Smartphone", "iPhone 13", 700.00);
        Product product2 = new Product("P112", "Apple", "Smartphone", "iPhone 16", 1480.00);
        Product[] products = {product1, product2};
        assertArrayEquals(products, productService.findByBrandAndCategory("Apple", "Smartphone"));
    }

    @Test
    void testFindByBrandAndCategoryNotExists() {
        Product[] products = {};
        assertArrayEquals(products, productService.findByBrandAndCategory("Nokia", "Smartphone"));
        assertArrayEquals(products, productService.findByBrandAndCategory("Samsung", "Tablet"));
    }

    @Test
    void testFindByBrandAndCategoryWhenSomethingIsNull() {
        assertNull(productService.findByBrandAndCategory(null, "Smartphone"));
        assertNull(productService.findByBrandAndCategory("Apple", null));
    }

    @Test
    void testFindByBrandAndCategoryWhenSomethingIsBlanc() {
        assertNull(productService.findByBrandAndCategory("", "Smartphone"));
        assertNull(productService.findByBrandAndCategory("Apple", "      "));
    }

    @Test
    void testFindByPriceRangeProductExists() {
        Product product1 = new Product("A101", "Samsung", "Refrigerator", "SM-185NF", 512.00);
        Product product2 = new Product("P102", "Apple", "Smartphone", "iPhone 13", 700.00);
        Product product3 = new Product("N123", "ASUS", "Laptop", "ASUS-i55121", 780.00);
        Product[] products = {product1, product2, product3};
        assertArrayEquals(products, productService.findByPriceRange(1000, 500));
    }

    @Test
    void testFindByPriceRangeNotExists() {
        Product[] products = {};
        assertArrayEquals(products, productService.findByPriceRange(0, 100));
    }

    @Test
    void testFindByPriceRangeWhenSomethingBelowZero() {
        assertNull(productService.findByPriceRange(-50, 800));
        assertNull(productService.findByPriceRange(500, -100));
    }

    @Test
    void testGetAllCars() {
        Product product1 = new Product("A101", "Samsung", "Refrigerator", "SM-185NF", 512.00);
        Product product2 = new Product("A102", "LG", "Refrigerator", "L-15D", 456.00);
        Product product3 = new Product("A123", "Indesit", "Refrigerator", "iS-2378", 399.00);
        Product product4 = new Product("P050", "Samsung", "Smartphone", "Galaxy A54s", 300.00);
        Product product5 = new Product("P034", "Samsung", "Smartphone", "Galaxy S25", 1200.00);
        Product product6 = new Product("P102", "Apple", "Smartphone", "iPhone 13", 700.00);
        Product product7 = new Product("P112", "Apple", "Smartphone", "iPhone 16", 1480.00);
        Product product8 = new Product("N123", "ASUS", "Laptop", "ASUS-i55121", 780.00);
        Product[] products = {product1, product2, product3, product4, product5, product6, product7, product8};
        assertArrayEquals(products, productService.getAllProducts());
    }

    @Test
    void testFillSimpleProducts() {
        ProductRepository thisProductRepository = new ProductRepository(10);
        ProductService thisProductService = new ProductService(thisProductRepository);
        int sizeOfArrayBevor = thisProductService.getCurrentQuantity();
        thisProductService.fillSimpleProducts();
        int sizeOfArrayAfter = thisProductService.getCurrentQuantity();
        assertEquals(0, sizeOfArrayBevor);
        assertEquals(8, sizeOfArrayAfter);
    }

    @Test
    void testGetCurrentQuantity() {
        ProductRepository testProductRepository = new ProductRepository(5);
        ProductService testProductService = new ProductService(testProductRepository);
        assertEquals(0, testProductService.getCurrentQuantity());
        testProductService.addProduct("num1", "Brand1", "Category1", "Name1", 1000);
        testProductService.addProduct("num2", "Brand2", "Category2", "Name2", 2000);
        assertEquals(2, testProductService.getCurrentQuantity());
    }
}