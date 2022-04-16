package com.example.deliverable;

public class FlightDescription {

    private String flight_number;
    private String leg_number;
    private String dep_airport_code;
    private String dep_airport_name;
    private String dep_time;
    private String arr_airport_code;
    private String arr_airport_name;
    private String arr_time;
    private String fare;
    private String airplane_id;
    private String city;
    private String date;

    private FlightDescription(){
        this("","","","","","","","","","","","");
    }

    private static FlightDescription flightDescription = new FlightDescription();

    public static FlightDescription getInstance(){
        if(flightDescription==null)
            flightDescription = new FlightDescription();
        return flightDescription;
    }

    public FlightDescription(String flight_number, String leg_number, String dep_airport_code, String dep_airport_name, String dep_time, String arr_airport_code, String arr_airport_name, String arr_time, String fare, String airplane_id, String city, String date) {
        this.flight_number = flight_number;
        this.leg_number = leg_number;
        this.dep_airport_code = dep_airport_code;
        this.dep_airport_name = dep_airport_name;
        this.dep_time = dep_time;
        this.arr_airport_code = arr_airport_code;
        this.arr_airport_name = arr_airport_name;
        this.arr_time = arr_time;
        this.fare = fare;
        this.airplane_id = airplane_id;
        this.city = city;
        this.date = date;
    }
    DBHandler dbHandler = new DBHandler();
    public String seeSchedule(String city, String date) {
        return dbHandler.seeSchedule(city, date);
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public String getDep_airport_name() {
        return dep_airport_name;
    }

    public void setDep_airport_name(String dep_airport_name) {
        this.dep_airport_name = dep_airport_name;
    }

    public String getDep_airport_code() {
        return dep_airport_code;
    }

    public void setDep_airport_code(String dep_airport_code) {
        this.dep_airport_code = dep_airport_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAirplane_id() {
        return airplane_id;
    }

    public void setAirplane_id(String airplane_id) {
        this.airplane_id = airplane_id;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getLeg_number() {
        return leg_number;
    }

    public void setLeg_number(String leg_number) {
        this.leg_number = leg_number;
    }

    public String getDep_time() {
        return dep_time;
    }

    public void setDep_time(String dep_time) {
        this.dep_time = dep_time;
    }

    public String getArr_time() {
        return arr_time;
    }

    public void setArr_time(String arr_time) {
        this.arr_time = arr_time;
    }

    public String getArr_airport_name() {
        return arr_airport_name;
    }

    public void setArr_airport_name(String arr_airport_name) {
        this.arr_airport_name = arr_airport_name;
    }

    public String getArr_airport_code() {
        return arr_airport_code;
    }

    public void setArr_airport_code(String arr_airport_code) {
        this.arr_airport_code = arr_airport_code;
    }

    public String seeFare(String city, String date) {
        return dbHandler.seeFare(city,date);
    }

    public String issueTicket(String city, String date) {
        return dbHandler.issueTicket(city,date);
    }
}