package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Offers;

import static org.junit.jupiter.api.Assertions.*;

class OffersRepositoryTest {
    OffersRepository repository = new OffersRepository();
    Offers offers1 = new Offers(1, 1000, "VKO", "LED", 80);
    Offers offers2 = new Offers(2, 1500, "LED", "VKO", 80);
    Offers offers3 = new Offers(3, 3000, "DME", "KZN", 90);
    Offers offers4 = new Offers(4, 3500, "VKO", "LED", 95);

    @Test
    void shouldSave() {
        repository.save(offers1);
        Offers[] expected = new Offers[]{offers1};
        Offers[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturn() {
        repository.save(offers2);
        repository.save(offers3);
        Offers[] expected = new Offers[]{offers2, offers3};
        Offers[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindIfExist() {
        repository.save(offers4);
        int idToFind = 4;
        repository.findById(idToFind);
        Offers expected = offers4;
        Offers actual = repository.findById(idToFind);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotFindByNotExist() {
        int idToFind = 3;
        repository.findById(idToFind);
        Offers actual = repository.findById(idToFind);
        assertNull(actual);
    }

    @Test
    void shouldRemoveIfExist() {
        repository.save(offers1);
        repository.save(offers2);
        int idToRemove = 2;
        repository.removeById(idToRemove);
        Offers[] expected = new Offers[]{offers1};
        Offers[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

}