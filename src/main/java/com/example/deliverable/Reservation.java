package com.example.deliverable;

import java.util.Random;

public class Reservation {

    private String seatno;
    Random random= new Random();
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    private int ticket_number = getRandomNumber(0,9999);


    private static Reservation reservation = new Reservation();

    public Reservation() {}

    public static Reservation getInstance(){
        if(reservation == null)
            reservation = new Reservation();
        return reservation;
    }

    Passenger passenger = Passenger.getInstance();
    FlightDescription flightDescription = FlightDescription.getInstance();

    public String getName() {
        return passenger.getFullName();
    }

    public void setName(String name) {
        passenger.setFullName(name);
    }

    public String getCnic() {
        return passenger.getCnicNo();
    }

    public void setCnic(String cnic) {
        passenger.setCnicNo(cnic);
    }

    public String getFlight_number() {
        return flightDescription.getFlight_number();
    }

    public void setFlight_number(String flight_number) {
        flightDescription.setFlight_number(flight_number);
    }

    public int getTicket_number() {
        return ticket_number;

    }

    public void setTicket_number(int ticket_number) {
        this.ticket_number = ticket_number;
    }

    public String getFare() {
        return flightDescription.getFare();
    }

    public void setFare(String fare) {
        flightDescription.setFare(fare);
    }

    public String getDep_airport() {
        return flightDescription.getDep_airport_name();
    }

    public void setDep_airport(String dep_airport) {
        flightDescription.setDep_airport_name(dep_airport);
    }

    public String getArr_airport() {
        return flightDescription.getArr_airport_name();
    }

    public void setArr_airport(String arr_airport) {
        flightDescription.setArr_airport_name(arr_airport);
    }

    public String getDep_time() {
        return flightDescription.getDep_time();
    }

    public void setDep_time(String dep_time) {
        flightDescription.setDep_time(dep_time);
    }

    public String getArr_time() {
        return flightDescription.getArr_time();
    }

    public void setArr_time(String arr_time) {
        flightDescription.setArr_time(arr_time);
    }

    public String getSeatno() {
        return seatno;
    }

    public void setSeatno(String seatno) {
        this.seatno = seatno;
    }


    DBHandler dbHandler = new DBHandler();
    public String generateBooking() {
        System.out.println(ticket_number);

        return dbHandler.addBooking(passenger.getFullName(),passenger.getCnicNo(),flightDescription.getFlight_number(),
                flightDescription.getFare(),flightDescription.getDep_airport_name(),flightDescription.getDep_time()
                ,flightDescription.getArr_airport_name(),flightDescription.getArr_time(),seatno= getSeatno(),ticket_number = getTicket_number() );
    }

    public String deleteTicket(String cnicno) {
        return dbHandler.deleteTicket(reservation.getCnic());
    }
}
