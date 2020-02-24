package com.l30.labproj;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter

public class Flight {

  private String estDepartureAirport;
  private String estArrivalAirport;
  private String firstSeen;
  private String lastSeen;
  
  public Flight(){

  }

  public String getestDepartureAirport(){
    return this.estDepartureAirport;
  }

  public void setestDepartureAirport(String estDepartureAirport){
    this.estDepartureAirport = estDepartureAirport;
  }

  public String getestArrivalAirport(){
    return this.estArrivalAirport;
  }

  public void setestArrivalAirport(String estArrivalAirport){
    this.estArrivalAirport = estArrivalAirport;
  }

  public String getfirstSeen(){
    return this.firstSeen;
  }

  public void setfirstSeen(String firstSeen){
    this.firstSeen = firstSeen;
  }

  public String getlastSeen(){
    return this.lastSeen;
  }

  public void setlastSeen(String lastSeen){
    this.lastSeen = lastSeen;
  }
  // public Flight(String estDepartureAirport, String estArrivalAirport, String firstSeen, String lastSeen) {
  //   this.estDepartureAirport = estDepartureAirport;
  //   this.estArrivalAirport = estArrivalAirport;
  //   this.firstSeen = firstSeen;
  //   this.lastSeen = lastSeen;
  // }

  @Override
  public String toString() {

    return "Flight from " + this.estDepartureAirport + " at " + this.firstSeen + " to " + this.estArrivalAirport + " at " + this.lastSeen;
  }
}