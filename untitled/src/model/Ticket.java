package model;

public class Ticket {
    private Client client;
    private Showtime showtime;
    private int seatNumber;

    public Ticket(Client client, Showtime showtime, int seatNumber) {
        this.client = client;
        this.showtime = showtime;
        this.seatNumber = seatNumber;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public Client getClient() {
        return client;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void showResume() {
        System.out.println("Cliente: " + client.getName());
        System.out.println("Película: " + showtime.getMovie().getTitle());
        System.out.println("Horario: " + showtime.getTimetable());
        System.out.println("Asiento: " + seatNumber);
    }
}
