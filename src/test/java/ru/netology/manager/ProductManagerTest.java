package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    private Product item1 = new Book(1, 200, "Harry Potter", "J.K.Rowling");
    private Product item2 = new Book(2, 400, "Mary Poppins", "Pamela Lyndon Travers");
    private Product item3 = new Smartphone(3, 1000, "Galaxy A31", "Samsung");
    private Product item4 = new Smartphone(4, 500, "А35", "Siemens");

    @BeforeEach
    void setUp() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
    }

    @Test
    public void shouldGetAll() {
        Product[] expected = new Product[]{item1, item2, item3, item4};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        Product[] expected = new Product[]{item2};
        Product[] actual = manager.searchBy("Pamela Lyndon Travers");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookName() {
        Product[] expected = new Product[]{item1};
        Product[] actual = manager.searchBy("Harry Potter");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByPhoneName() {
        Product[] expected = new Product[]{item3};
        Product[] actual = manager.searchBy("Galaxy A31");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturer() {
        Product[] expected = new Product[]{item4};
        Product[] actual = manager.searchBy("Siemens");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthorNegative() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Victor Pelevin");
        assertArrayEquals(expected, actual);
    }
}