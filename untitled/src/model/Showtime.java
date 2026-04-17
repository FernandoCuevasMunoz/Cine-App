package model;

import java.util.ArrayList;
import java.util.List;

public class Showtime {

    private Movie movie;
    private String timeTable;
    private int cinemaRoomCapacity;
    private List<Ticket> soldTickets;

    public Showtime(Movie movie, String timetable, int cinemaRoomCapacity) {
        this.movie = movie;
        this.timeTable = timetable;
        this.cinemaRoomCapacity = cinemaRoomCapacity;
        this.soldTickets = new ArrayList<>();

    }

    public Movie getMovie() {
        return movie;
    }

    public String getTimetable(){
        return timeTable;
    }

    public int getCinemaRoomCapacity(){
        return cinemaRoomCapacity;
    }

    public List<Ticket> getSoldTickets(){
        return soldTickets;
    }

    public int getAvailableSeats(){
        return cinemaRoomCapacity - soldTickets.size();
    }

    public boolean isAvailableSeats(){
        return getAvailableSeats() > 0;
    }

    public boolean seatSold(int seatNumber) {
        for (Ticket ticket : soldTickets){
            if(ticket.getSeatNumber() == seatNumber){
                return true;
            }
        }
        return false;
    }

    public boolean validSeat(int seatNumber){
        return seatNumber >= 1 && seatNumber <= cinemaRoomCapacity;
    }

    public boolean sellTicket(Ticket ticket) {
        if (!isAvailableSeats()){
            return false;
        }
        if (!validSeat(ticket.getSeatNumber())) {
            return false;
        }
        if (seatSold(ticket.getSeatNumber())) {
            return false;
        }
        soldTickets.add(ticket);
        return true;
    }
    public void showInformation() {
        System.out.println("Película: " + movie.getTitle()
                + " | Horario: " + timeTable
                + " | Capacidad: " + cinemaRoomCapacity
                + " | Asientos Disponibles: " + getAvailableSeats());
    }
}
