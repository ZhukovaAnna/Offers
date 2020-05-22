package ru.netology.domain;

import java.util.Comparator;

public class OffersByTimeAscComparator implements Comparator<Offers> {

    @Override
    public int compare(Offers o1, Offers o2) {
        return o1.getTime() - o2.getTime();
    }
}

