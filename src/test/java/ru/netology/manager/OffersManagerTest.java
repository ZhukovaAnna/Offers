package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Offers;
import ru.netology.domain.OffersByTimeAscComparator;
import ru.netology.repository.OffersRepository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class OffersManagerTest {
    OffersRepository repository = new OffersRepository();
    OffersManager manager = new OffersManager(repository);

    Offers offers1 = new Offers(1, 1000, "VKO", "LED", 80);
    Offers offers2 = new Offers(2, 1500, "LED", "VKO", 80);
    Offers offers3 = new Offers(3, 3000, "DME", "KZN", 90);
    Offers offers4 = new Offers(4, 3500, "VKO", "LED", 95);
    Offers offers5 = new Offers(5, 4500, "LED", "VKO", 100);

    @Test
    void shouldReturnEmptyIfNoTicket() {
        manager = new OffersManager(repository);
        Offers[] expected = new Offers[0];
        Offers[] actual = manager.findAll("VKO", "LED");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnTicketIfFind() {
        manager = new OffersManager(repository);
        manager.offersAdd(offers1);
        manager.offersAdd(offers2);
        Offers[] expected = new Offers[]{offers1};
        Offers[] actual = manager.findAll("VKO", "LED");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSortTicketIfFind() {
        manager = new OffersManager(repository);
        manager.offersAdd(offers1);
        manager.offersAdd(offers2);
        manager.offersAdd(offers3);
        manager.offersAdd(offers4);
        Offers[] expected = new Offers[]{offers1, offers4};
        Offers[] actual = manager.findAll("VKO", "LED");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyIfNotContain() {
        manager = new OffersManager(repository);
        manager.offersAdd(offers1);
        manager.offersAdd(offers2);
        Offers[] expected = new Offers[0];
        Offers[] actual = manager.findAll("DME", "KZN");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSortTicketsByTimeIfContains() {
        Comparator comparator = new OffersByTimeAscComparator();
        manager = new OffersManager(repository);
        manager.offersAdd(offers1);
        manager.offersAdd(offers2);
        manager.offersAdd(offers3);
        manager.offersAdd(offers4);
        manager.offersAdd(offers5);
        Offers[] expected = new Offers[]{offers2, offers5};
        Offers[] actual = manager.findAllSortByComparator("LED", "VKO", comparator);
        assertArrayEquals(expected, actual);
    }

}