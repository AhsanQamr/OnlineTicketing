package com.example.deliverable;

import java.sql.*;
import java.util.Objects;


public class DBHandler {


    String url = "jdbc:sqlite:testDB.sqlite";
    Connection conn = null;



    private void closeConnection() throws SQLException {

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void getConnection() throws SQLException {

        try {

            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public String signUp(String fullname, String username, String email, String password, String cnic, String age) {

        try{
            getConnection();

            if(Objects.equals(fullname, "") || Objects.equals(username, "") || Objects.equals(email, "") || Objects.equals(password, "") || Objects.equals(cnic, "") || Objects.equals(age,"")){
                return "Fields are empty";
            }

            //String q = "INSERT INTO Passenger(fullname, username, email, password, cnic, age) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement("INSERT INTO Passenger(fullname,username,email,password,cnic,age) VALUES (?,?,?,?,?,?)");
            statement.setString(1, fullname);
            statement.setString(2,username);
            statement.setString(3, email);
            statement.setString(4,password);
            statement.setString(5,cnic);
            statement.setString(6, age);

            int resultSet = statement.executeUpdate();
            if(resultSet>0){
                closeConnection();
                return "Success";
            }
            else{
                closeConnection();
                return "Username Already Taken";
            }

        }
        catch (Exception e){
            e.printStackTrace();
            try {
                closeConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return "Error connecting to database";
        }

    }


    public String login(String userName, String password) {
        try {

            if(Objects.equals(userName, "") || Objects.equals(password, "")){
                return "Fields are Empty";
            }

            getConnection();

            String q = "select * from Passenger where username=? and password=?";

            PreparedStatement statement = conn.prepareStatement(q);
            statement.setString(1, userName);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                Passenger P = Passenger.getInstance();
                P.setFullName(resultSet.getString("Fullname"));
                P.setUserName(resultSet.getString("Username"));
                P.setEmail(resultSet.getString("Email"));
                P.setPassword(resultSet.getString("Password"));
                P.setCnicNo(resultSet.getString("Cnic"));
                P.setAge(resultSet.getString("Age"));


                closeConnection();
                return "Success";
            }
            else{
                closeConnection();
                return "Invalid username or password";
            }
        }catch (SQLException e) {
            e.printStackTrace();
            try {
                closeConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return "Error connecting to database";
        }

    }

    public String seeSchedule(String city, String date) {
        try {

            if(Objects.equals(city, "") || Objects.equals(date, "")){
                return "Fields are Empty";
            }

            getConnection();

            String q;
            q = "select * from Flight INNER JOIN Airplane ON Flight.airplane_id = Airplane.airplane_id where city=? and date=?";

            PreparedStatement statement = conn.prepareStatement(q);
            statement.setString(1, city);
            statement.setString(2, date);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                FlightDescription flightDescription = FlightDescription.getInstance();
                AirplaneDescription airplaneDescription = AirplaneDescription.getInstance();

                airplaneDescription.setAirplane_id(resultSet.getString("Airplane_id"));
                airplaneDescription.setAirplane_company(resultSet.getString("Airplane_company"));
                airplaneDescription.setAirplane_type(resultSet.getString("Airplane_type"));
                airplaneDescription.setSeats(resultSet.getString("Seats"));
                flightDescription.setFlight_number(resultSet.getString("Flight_number"));
                flightDescription.setLeg_number(resultSet.getString("Leg_number"));
                flightDescription.setDep_airport_code(resultSet.getString("Dep_airport_code"));
                flightDescription.setDep_airport_name(resultSet.getString("Dep_airport_name"));
                flightDescription.setDep_time(resultSet.getString("Dep_time"));
                flightDescription.setArr_airport_code(resultSet.getString("Arr_airport_code"));
                flightDescription.setArr_airport_name(resultSet.getString("Arr_airport_name"));
                flightDescription.setArr_time(resultSet.getString("Arr_time"));
                flightDescription.setFare(resultSet.getString("Fare"));
                flightDescription.setAirplane_id(resultSet.getString("Airplane_id"));
                flightDescription.setCity(resultSet.getString("City"));
                flightDescription.setDate(resultSet.getString("Date"));

// continue


                closeConnection();
                return "Found";
            }
            else{
                closeConnection();
                return "No record Found";
            }
        }catch (SQLException e) {
            e.printStackTrace();
            try {
                closeConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return "Error connecting to database";
        }
    }

    public String seeFare(String city, String date) {
        try {

            if(Objects.equals(city, "") || Objects.equals(date, "")){
                return "Fields are Empty";
            }

            getConnection();

            String q;
            q = "select * from Flight INNER JOIN Airplane ON Flight.airplane_id = Airplane.airplane_id where city=? and date=?";

            PreparedStatement statement = conn.prepareStatement(q);
            statement.setString(1, city);
            statement.setString(2, date);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                FlightDescription flightDescription = FlightDescription.getInstance();
                AirplaneDescription airplaneDescription = AirplaneDescription.getInstance();

                airplaneDescription.setAirplane_id(resultSet.getString("Airplane_id"));
                airplaneDescription.setAirplane_company(resultSet.getString("Airplane_company"));
                airplaneDescription.setAirplane_type(resultSet.getString("Airplane_type"));
                flightDescription.setDep_airport_name(resultSet.getString("Dep_airport_name"));
                flightDescription.setArr_airport_name(resultSet.getString("Arr_airport_name"));
                flightDescription.setFare(resultSet.getString("Fare"));

                closeConnection();
                return "Found";
            }
            else{
                closeConnection();
                return "No record Found";
            }
        }catch (SQLException e) {
            e.printStackTrace();
            try {
                closeConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return "Error connecting to database";
        }
    }

    public String issueTicket(String city, String date) {
        try {

            if(Objects.equals(city, "") || Objects.equals(date, "")){
                return "Fields are Empty";
            }

            getConnection();

            String q;
            q = "select * from Flight INNER JOIN Airplane ON Flight.airplane_id = Airplane.airplane_id where city=? and date=?";

            PreparedStatement statement = conn.prepareStatement(q);
            statement.setString(1, city);
            statement.setString(2, date);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                FlightDescription flightDescription = FlightDescription.getInstance();
                AirplaneDescription airplaneDescription = AirplaneDescription.getInstance();

                airplaneDescription.setAirplane_id(resultSet.getString("Airplane_id"));
                airplaneDescription.setAirplane_company(resultSet.getString("Airplane_company"));
                airplaneDescription.setAirplane_type(resultSet.getString("Airplane_type"));
                airplaneDescription.setSeats(resultSet.getString("Seats"));
                flightDescription.setFlight_number(resultSet.getString("Flight_number"));
                flightDescription.setLeg_number(resultSet.getString("Leg_number"));
                flightDescription.setDep_airport_code(resultSet.getString("Dep_airport_code"));
                flightDescription.setDep_airport_name(resultSet.getString("Dep_airport_name"));
                flightDescription.setDep_time(resultSet.getString("Dep_time"));
                flightDescription.setArr_airport_code(resultSet.getString("Arr_airport_code"));
                flightDescription.setArr_airport_name(resultSet.getString("Arr_airport_name"));
                flightDescription.setArr_time(resultSet.getString("Arr_time"));
                flightDescription.setFare(resultSet.getString("Fare"));
                flightDescription.setAirplane_id(resultSet.getString("Airplane_id"));
                flightDescription.setCity(resultSet.getString("City"));
                flightDescription.setDate(resultSet.getString("Date"));

                closeConnection();
                return "Found";
            }
            else{
                closeConnection();
                return "No record Found";
            }
        }catch (SQLException e) {
            e.printStackTrace();
            try {
                closeConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return "Error connecting to database";
        }
    }

    public String validateAtIssuance(String cnic){

        try {

            if(Objects.equals(cnic, "") ){
                return "Fields are Empty";
            }

            getConnection();

            String q = "select * from Booking where Cnic=?";

            PreparedStatement statement = conn.prepareStatement(q);
            statement.setString(1, cnic);


            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                closeConnection();
                return "Success";
            }
            else{
                closeConnection();
                return "Ticket Already Issued";
            }
        }catch (SQLException e) {
            e.printStackTrace();
            try {
                closeConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return "Error connecting to database";
        }
    }



    public String addBooking(String name, String cnic, String FlightNumber, String fare, String dep_airport, String dep_time, String arr_airport, String arr_time, String seatno, int ticketno) {
        try{
            getConnection();

           // validateAtIssuance(cnic);

            PreparedStatement statement = conn.prepareStatement("INSERT INTO Booking (name,cnic,FlightNumber,fare,dep_airport,dep_time,arr_airport,arr_time,seatno,ticketno) VALUES (?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1, name);
            statement.setString(2,cnic);
            statement.setString(3, FlightNumber);
            statement.setString(4,fare);
            statement.setString(5,dep_airport);
            statement.setString(6, dep_time);
            statement.setString(7, arr_airport);
            statement.setString(8, arr_time);
            statement.setString(9, seatno);
            statement.setString(10, String.valueOf(Integer.parseInt(String.valueOf(ticketno))));



            int resultSet = statement.executeUpdate();
            if(resultSet>0){
                closeConnection();
                return "Success";
            }
            else{
                closeConnection();
                return "Ticket Already Issued";
            }

        }
        catch (Exception e){
            e.printStackTrace();
            try {
                closeConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return "Error connecting to database";
        }
    }

    public String seeBooking(String cnic) {

        try {

            if(Objects.equals(cnic, "") ){
                return "Fields are Empty";
            }

            getConnection();

            String q = "select * from Booking where Cnic=?";

            PreparedStatement statement = conn.prepareStatement(q);
            statement.setString(1, cnic);


            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                Reservation reservation = Reservation.getInstance();
                reservation.setName(resultSet.getString("name"));
                reservation.setCnic(resultSet.getString("Cnic"));
                reservation.setFlight_number(resultSet.getString("FlightNumber"));
                reservation.setFare(resultSet.getString("Fare"));
                reservation.setDep_airport(resultSet.getString("Dep_airport"));
                reservation.setDep_time(resultSet.getString("Dep_time"));
                reservation.setArr_airport(resultSet.getString("Arr_airport"));
                reservation.setArr_time(resultSet.getString("Arr_time"));
                reservation.setSeatno(resultSet.getString("SeatNo"));
                reservation.setTicket_number(resultSet.getInt("TicketNo"));

                closeConnection();
                return "Success";
            }
            else{
                closeConnection();
                return "Booking Not Found";
            }
        }catch (SQLException e) {
            e.printStackTrace();
            try {
                closeConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return "Error connecting to database";
        }

    }

    public String cancelBooking(String cnic) {
        try {

            if(Objects.equals(cnic, "") ){
                return "Fields are Empty";
            }

            getConnection();

            String q = "select * from Booking where Cnic=?";

            PreparedStatement statement = conn.prepareStatement(q);
            statement.setString(1, cnic);


            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                closeConnection();
                return "Success";
            }
            else{
                closeConnection();
                return "No Ticket Found";
            }
        }catch (SQLException e) {
            e.printStackTrace();
            try {
                closeConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return "Error connecting to database";
        }
    }

    public String deleteTicket(String cnic) {

        try {

            getConnection();

            PreparedStatement statement = conn.prepareStatement("DELETE FROM Booking WHERE cnic=?");
            statement.setString(1, cnic);

            int resultSet = statement.executeUpdate();
            if(resultSet>0){
                closeConnection();
                return "Success";
            }
            else{
                closeConnection();
                return "No Ticket Found";
            }


        }catch (SQLException e) {
            e.printStackTrace();
            try {
                closeConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return "Error connecting to database";
        }

    }
}
