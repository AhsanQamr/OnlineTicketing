package com.example.deliverable;

public class AirplaneDescription {
    private String airplane_id;
    private String airplane_company;
    private String airplane_type;
    private String seats;

    private AirplaneDescription(){
        this("","","","");
    }

    private static AirplaneDescription airplaneDescription = new AirplaneDescription();

    public static AirplaneDescription getInstance(){
        if(airplaneDescription == null){
            airplaneDescription = new AirplaneDescription();
        }
        return airplaneDescription;
    }

    public AirplaneDescription(String airplane_id,String airplane_company,String airplane_type,String seats){
        this.airplane_id=airplane_id;
        this.airplane_company=airplane_company;
        this.airplane_type=airplane_type;
        this.seats=seats;
    }

    public void setAirplane_id(String airplane_id){
        this.airplane_id=airplane_id;
    }
    public void setAirplane_company(String airplane_company){
        this.airplane_company=airplane_company;
    }
    public void setAirplane_type(String airplane_type){
        this.airplane_type=airplane_type;
    }
    public void setSeats(String seats){
        this.seats=seats;
    }

    public String getAirplane_id(){
        return airplane_id;
    }
    public String getAirplane_company(){
        return airplane_company;
    }
    public String getAirplane_type(){
        return airplane_type;
    }
    public  String getSeats(){
        return seats;
    }

}
