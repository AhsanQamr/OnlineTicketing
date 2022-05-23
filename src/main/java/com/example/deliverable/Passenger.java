package com.example.deliverable;

public class Passenger {

    private String fullName;
    private String userName;
    private String email;
    private String password;
    private String cnicNo;
    private String age;



    private Passenger(){
        this("","","","","","");
    }

    private static Passenger P1 = new Passenger();

    public static Passenger getInstance(){
        if(P1==null)
            P1 = new Passenger();
        return P1;
    }

    public Passenger(String FullName,String UserName,String Email,String Password,String CnicNo, String Age){
        setFullName(FullName);
        setUserName(UserName);
        setEmail(Email);
        setPassword(Password);
        setCnicNo(CnicNo);
        setAge(Age);
    }

    public void setFullName(String fullName){
        this.fullName= fullName;
    }
    public void setUserName(String userName){
        this.userName= userName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setCnicNo(String cnicNo){
        this.cnicNo = cnicNo;
    }
    public void setAge(String age){
        this.age = age;
    }

    public String getFullName(){
        return fullName;
    }
    public String getUserName(){
        return userName;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getCnicNo(){
        return cnicNo;
    }
    public String getAge(){
        return age;
    }

    DBHandler dbHandler = new DBHandler();


    public String signUp() {
        return dbHandler.signUp(fullName,userName,email,password,cnicNo,age);
    }

    public String login(String userName, String password) {
        return dbHandler.login(userName,password);
    }


}
