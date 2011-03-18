/**
 *Title: Roster
 *Desription: A library of methods required to roster.
 *Auther: James Sandford
 *Last updated: 18/3/11
 *Updated by: James Sandford
 *Current state: Untested
 *Known bugs: NONE
 **/

import java.util.*;

class bus{
  int busID;
  int runTime;

  public bus(int ID, int Time){
    /**
     *Takes the bus ID as the first argument and the time it has spent running
     *in the past as the second.
     */
    busID = ID;
    runTime = Time;
  }
}

public class Roster{

  List <bus> busList = new ArrayList<bus>();
  
  public addBus(int ID, int Time){
    bus newBus = new bus(ID, Time);
    busList.add(newBus);
    Collections.sort(busList, bytime());
  }

  public int getBus(){
    bus nextBus = busList.get(0);
    busList.remove(0);
  }

  private class byTime implements java.util.Comparator {
    public int compare(bus first, bus second) {
      return (first.runTime - second.runTime);
    }
  } 

}//class Roster