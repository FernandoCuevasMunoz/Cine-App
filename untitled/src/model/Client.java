package model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Client extends Person {

    private List<Ticket> purchasedTickets;

    public Client(String name) {
        super(name);
        this.purchasedTickets = new ArrayList<>();
    }

    public List<Ticket> getpurchasedTickets() {
        return purchasedTickets;
    }

    public void addTicket(Ticket ticket) {
        purchasedTickets.add(ticket);
    }

    public void showTickets() {
        if (purchasedTickets.isEmpty()) {
            System.out.println("El cliente " + getName() + " no tiene entradas compradas");
            return;
        }
        System.out.printf("Entradas de " + getName());
        for (Ticket ticket : purchasedTickets) {
            ticket.showResume();
            System.out.println("--------------------");

        }
    }
}