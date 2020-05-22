package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Offers;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OffersRepository {

    private Offers[] tickets = new Offers[0];

    public void save(Offers item) {
        int length = tickets.length + 1;
        Offers[] tmp = new Offers[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        tickets = tmp;
    }

    public Offers[] findAll() {
        return tickets;
    }

    public Offers findById(int id) {
        for (Offers offers : tickets) {
            if (offers.getId() == id) {
                return offers;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = tickets.length - 1;
        Offers[] tmp = new Offers[length];
        int index = 0;
        for (Offers film : tickets) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        tickets = tmp;
    }

    public void removeAll() {
        tickets = new Offers[0];
    }
}
