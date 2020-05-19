package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Offers implements Comparable<Offers> {
    private int id;
    private int price;
    private String from;
    private String to;
    private int time;

    @Override
    public int compareTo(Offers o){
     return price - o.price;
    }
}
