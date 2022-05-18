package MusicLandscape.entities;

import MusicLandscape.Date;
import MusicLandscape.Venue;

public class TVShow extends Event {
    private String name;
    private int viewers;

  public TVShow(){
  }
  public TVShow(Event e){
      super(e);
  }
    public TVShow(TVShow tvs){
      super(tvs);
      this.name = tvs.getName();
      this.viewers = tvs.getViewers();
    }

    public String getName() {
        return name;
    }
    public int getViewers(){
      return viewers;
    }
    public int impact(){
      int impact = (getViewers() + getAttendees()) * 2;
      return impact;
    }
    public void setName(String name){
      if(name == null || name.isBlank())
          return;
      this.name = name;
    }
    public void setViewers(int v){
      if(v <= 0)
          return;
      this.viewers = v;
    }
    public String toString(){
      return  getArtist().toString() +
              (getVenue() == null ? " @ unknown" : " @ " + name) +
              " on " + getDate() + "\n" +
              getDescription() + "\n" +
              "(" + (getAttendees()+getViewers()) +
              " attending (" + impact() + "))";
    }
}
