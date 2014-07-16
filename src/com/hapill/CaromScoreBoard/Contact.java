package com.hapill.CaromScoreBoard;

public class Contact { 
    
    int id; 
    String name; 
    int threeBall, fourBall;
   
    public int getFourBall() {
		return fourBall;
	}
	public void setFourBall(int fourBall) {
		this.fourBall = fourBall;
	}
	public int getThreeBall() {
		return threeBall;
	}
	public void setThreeBall(int threeBall) {
		this.threeBall = threeBall;
	}
	public Contact(){ 
   
    } 
    public Contact(int id, String name, int tb, int fb){
        this.id = id; 
        this.threeBall = tb;
        this.fourBall = fb;
        this.name = name; 
    } 
   
    public Contact(String name, int tb, int fb){ 
        this.name = name; 
        this.threeBall = tb;
        this.fourBall = fb;
    } 
     
    public int getID(){ 
        return this.id; 
    } 
   
    public void setID(int id){ 
        this.id = id; 
    } 
   
    public String getName(){ 
        return this.name; 
    } 
   
    public void setName(String name){ 
        this.name = name; 
    } 
   
}