package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OffersByTimeAscComparator implements Comparator<Offers> {
    private int id;
    private int price;
    private String from;
    private String to;
    private int time;

    @Override
    public int compare(Offers o1, Offers o2) {
        return o1.getTime() - o2.getTime();
    }
}

