package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exeption.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();

    Product item1 = new Book(1,"War And Peace", 200, "Lev Tolstoy");
    Product item2 = new Book(2,"The Lost World", 300, "Conan Doyle");
    Product item3 = new Smartphone(3,"Iphone10", 100, "Apple");
    Product item4 = new Smartphone(4,"Redmi10", 150, "Xiaomi");
    Product item5 = new Book(5,"The Green Mile", 200, "Stephen King");

    @BeforeEach
    void setUp()
    {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);

    }

    @Test
    void shouldDeleteById(){

        repository.removeById(3);
        Product[] expected = {new Book(1, "War And Peace", 200, "Lev Tolstoy"),
                new Book(2, "The Lost World", 300, "Conan Doyle"),
                new Smartphone(4, "Redmi10", 150, "Xiaomi"),
                new Book(5, "The Green Mile", 200, "Stephen King")
        };
        assertArrayEquals(expected, repository.findAll());

    }

    @Test
    void shouldNotDeleteByNoExistId(){

        assertThrows(NotFoundException.class, () -> repository.removeById(0));

    }
}