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
  
  public int getID(){
    return busID;
  }

  public int getTime(){
    return runTime;
  }
}

public class Roster{
  /**
   *The main roster class. All interfaces to the roster library go here.
   **/

  List <bus> busList = new ArrayList<bus>();
  
  public addBus(int ID, int Time){
    /**
     *Add a bus to the internal list.
     **/
    bus newBus = new bus(ID, Time);
    busList.add(newBus);
    Collections.sort(busList, bytime());
  }

  public int getBus(){
    /**
     *Get the next bus to be used and remove it from the internal list.
     **/
    bus nextBus = busList.get(0);
    busList.remove(0);
    return nextBus.getID();
  }

  public boolean delBus(int ID){
    /**
     *Remove bus from internal list. Returns true if item found and removed.
     **/
    for (int i = 0; i < busList.size(); i++){
      if (busList[i].getID() == ID){
	busList.remove(i);
	return true;
      }
    }
    return false;
  }

  private class byTime implements java.util.Comparator {
    public int compare(bus first, bus second) {
      return (first.getTime() - second.getTime());
    }
  } 

}//class Roster