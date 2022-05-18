package MusicLandscape.entities;


import MusicLandscape.Date;
import MusicLandscape.Venue;

public class Event {
    private Artist artist = new Artist();
    private int attendees = 0;
    private Date date;
    private String description = "";
    private Venue venue = null;

    public Event(){
    }
    public Event(Event e){
        this.artist = new Artist();
        this.attendees = e.attendees;
        this.date = new Date();
        this.description = e.description;
        this.venue = new Venue(e.venue);
    }
    public Artist getArtist(){
        return artist;
    }
    public int getAttendees() {
        return attendees;
    }

    public Date getDate() {
        //copy constructor von date
        if(date == null)
            return null;
        Date d = new Date(date);
        return d;
    }

    public String getDescription() {
        return description;
    }

    public Venue getVenue() {
        return venue;
    }
    public int impact(){
        int impact = getAttendees() * 2;
        return impact;
    }
    public void setArtist(Artist artist) {
        if(artist == null)
            return;
        this.artist = artist;
    }

    public void setAttendees(int attendees) {
        if(attendees < 0)
            return;
        this.attendees = attendees;
    }

    public void setDate(Date date) {
        if(date == null)
            this.date = null;
        else
            this.date = new Date(date);
    }
    public void setDescription(String description) {
        if(description == null || description.isBlank())
            return;
        this.description = description;
    }
    public void setVenue(Venue venue) {
        this.venue = venue;
    }
    public String toString() {
        return  artist.toString() +
                (venue == null ? " @ unknown" : " @ " + venue.getName()) +
                " on " + date + "\n" +
                description + "\n" +
                "(" + attendees +
                " attending (" + impact() + "))";
    }
}
