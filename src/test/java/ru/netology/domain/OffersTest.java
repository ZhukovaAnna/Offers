package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OffersTest {
Offers offers1=new Offers(1,1000,"VKO","LED",85);
Offers offers2=new Offers(2,1500,"VKO","LED",90);
Offers offers3=new Offers(3,2000,"DME","LED",90);

    @Test
    void shouldSortByPrice() {
        Offers[] expected = new Offers[] {offers1, offers2, offers3};
        Offers[] actual = new Offers[] {offers3, offers2, offers1};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }


}