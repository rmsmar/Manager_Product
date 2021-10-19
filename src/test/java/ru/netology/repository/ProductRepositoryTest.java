package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Product item1 = new Book(1, 200, "Harry Potter", "J.K.Rowling");
    private Product item2 = new Book(2, 400, "Mary Poppins", "Pamela Lyndon Travers");
    private Product item3 = new Smartphone(3, 1000, "Galaxy A31", "Samsung");
    private Product item4 = new Smartphone(4, 500, "А35", "Siemens");

    @BeforeEach
    public void setUp() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
    }

    @Test
    public void shouldGetAll() {
        Product[] expected = new Product[]{item1, item2, item3, item4};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        Product actual = repository.findById(1);
        Product expected = item1;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindById() {
        Product actual = repository.findById(5);
        assertNull(actual);
    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(1);
        Product[] actual = repository.findAll();
        Product[] expected = {
                item2,
                item3,
                item4,
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveById() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.removeById(5));
    }
}