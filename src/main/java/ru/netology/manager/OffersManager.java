package ru.netology.manager;

import ru.netology.domain.Offers;
import ru.netology.repository.OffersRepository;

import java.util.Arrays;
import java.util.Comparator;

public class OffersManager {
    private OffersRepository repository;

    public OffersManager(OffersRepository repository) {
        this.repository = repository;
    }

    public void offersAdd(Offers ticket) {
        repository.save(ticket);
    }

    public Offers[] findAll(String from, String to) {
        Offers[] result = new Offers[0];
        for (Offers ticket : repository.findAll()) {
            if (ticket.getFrom().equalsIgnoreCase(from) && ticket.getTo().equalsIgnoreCase(to)) {
                Offers[] tmp = new Offers[result.length+1];
                System.arraycopy (result,0, tmp,0, result.length);
                tmp[tmp.length-1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Offers[] findAllSortByTime(String from, String to, Comparator<Offers> comparator) {
        Offers[] result = new Offers[0];
        for (Offers ticket : repository.findAll()) {
            if (ticket.getFrom().equalsIgnoreCase(from) && ticket.getTo().equalsIgnoreCase(to)) {
                Offers[] tmp = new Offers[result.length+1];
                System.arraycopy (result,0, tmp,0, result.length);
                tmp[tmp.length-1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result,comparator);
        return result;
    }
}