package service;

import model.Client;
import model.Ticket;
import model.Showtime;
import model.Movie;
import model.Person;
import util.InputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CinemaService {
    private List<Person> people;
    private List<Showtime> showtimes;
    private Scanner scanner;

    public CinemaService() {
        this.people = new ArrayList<>();
        this.showtimes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        loadInitialShowtime();
    }

    public void start() {
        int option;

        do {
            showMenu();
            option = InputUtil.readInt(scanner, "Seleccione una opción: ");

            switch (option) {
                case 1 -> createClient();
                case 2 -> seeShowTime();
                case 3 -> buyTicket();
                case 4 -> viewCustomerTickets();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }

        } while (option != 0);
    }

    private void showMenu() {
        System.out.println("\n========== CINE APP ==========");
        System.out.println("1) Crear cliente");
        System.out.println("2) Ver cartelera");
        System.out.println("3) Comprar entrada");
        System.out.println("4) Ver entradas del cliente");
        System.out.println("0) Salir");
        System.out.println("==============================");
    }

    private void createClient() {
        String name = InputUtil.readText(scanner, "Ingrese el nombre del Cliente");

        if (searchClientByName(name) != null) {
            System.out.println("Ya existe un cliente con ese nombre");
            return; // 🔥 IMPORTANTE
        }

        Client client = new Client(name);
        people.add(client);

        System.out.println("Cliente creado correctamente");
    }

    private void seeShowTime() {
        if (showtimes.isEmpty()) {
            System.out.println("No hay funciones disponibles.");
            return;
        }

        System.out.println("\n=== Cartelera ===");
        for (int i = 0; i < showtimes.size(); i++) {
            System.out.print((i + 1) + ") ");
            showtimes.get(i).showInformation();
        }
    }

    private void buyTicket() {
        Client client = selectClient();
        if (client == null) return;

        Showtime showtime = selectShow();
        if (showtime == null) return;

        if (!showtime.isAvailableSeats()) {
            System.out.println("No hay asientos disponibles para esta función.");
            return;
        }

        int seat = InputUtil.readInt(scanner,
                "Ingrese número de asiento (1 a " + showtime.getCinemaRoomCapacity() + "): ");

        if (!showtime.validSeat(seat)) {
            System.out.println("Número de asiento fuera de rango.");
            return;
        }

        if (showtime.seatSold(seat)) {
            System.out.println("Ese asiento ya fue vendido.");
            return;
        }

        Ticket ticket = new Ticket(client, showtime, seat);

        boolean successfulSale = showtime.sellTicket(ticket);

        if (successfulSale) {
            client.addTicket(ticket);
            System.out.println("Entrada comprada correctamente.");
            System.out.println("\nResumen de la entrada:");
            ticket.showResume();
        } else {
            System.out.println("No fue posible realizar la compra.");
        }
    }

    private void viewCustomerTickets() {
        Client client = selectClient();
        if (client == null) return;

        client.showTickets();
    }

    private Client selectClient() {
        if (people.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return null;
        }

        List<Client> clients = obtainClient();

        if (clients.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return null;
        }

        System.out.println("\n=== Clientes ===");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println((i + 1) + ") " + clients.get(i).getName());
        }

        int option = InputUtil.readInt(scanner, "Seleccione un Cliente: ");

        if (option < 1 || option > clients.size()) {
            System.out.println("Cliente inválido");
            return null;
        }

        return clients.get(option - 1);
    }

    private Showtime selectShow() {
        if (showtimes.isEmpty()) {
            System.out.println("No hay funciones disponibles.");
            return null;
        }

        System.out.println("\n=== Funciones disponibles ===");
        for (int i = 0; i < showtimes.size(); i++) {
            System.out.print((i + 1) + ") ");
            showtimes.get(i).showInformation();
        }

        int option = InputUtil.readInt(scanner, "Seleccione una función: ");

        if (option < 1 || option > showtimes.size()) {
            System.out.println("Función inválida");
            return null;
        }

        return showtimes.get(option - 1);
    }

    private Client searchClientByName(String name) {
        for (Person person : people) {
            if (person instanceof Client client &&
                    client.getName().equalsIgnoreCase(name)) {
                return client;
            }
        }
        return null;
    }

    private List<Client> obtainClient() {
        List<Client> clients = new ArrayList<>();

        for (Person person : people) {
            if (person instanceof Client client) {
                clients.add(client);
            }
        }

        return clients;
    }

    private void loadInitialShowtime() {
        Movie pelicula1 = new Movie("Avengers: Endgame", "Fantasy", 181);
        Movie pelicula2 = new Movie("Interstellar", "Sci-fi", 169);
        Movie pelicula3 = new Movie("El Rey León", "Animation", 118);

        showtimes.add(new Showtime(pelicula1, "15:00", 10));
        showtimes.add(new Showtime(pelicula2, "18:30", 8));
        showtimes.add(new Showtime(pelicula3, "21:00", 12));
    }
}