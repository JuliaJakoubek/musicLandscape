package MusicLandscape.entities;
import MusicLandscape.util.ConsoleScanable;

import java.util.Scanner;

public class Track implements ConsoleScanable {
    private Artist performer;
    private String title;
    private Artist writer;
    private int year;
    private int duration;


    //Constructor
    public Track() {
        this.title = null;
        this.duration = 0;
        this.year = 1900;
        this.performer = new Artist();
        this.writer = new Artist();
    }

    public Track(String title) {
        if (title == null || title.isBlank()) {
            return;
        }
        this.title = title;
        //Rest default?
    }

    public Track(Track t) {
        this.performer = new Artist(t.getPerformer());
        this.title = t.getTitle();
        this.writer = new Artist(t.getWriter());
        this.year = t.getYear();
        this.duration = t.getDuration();
    }


    //Getter Methoden
    public int getDuration() {
        return duration;
    }

    public Artist getPerformer() {
        return performer;
    }

    public Artist getWriter() {
        return writer;
    }

    public int getYear() {
        return year;
    }

    public String getString() {
        String title;
        String writer;
        String performer;
        int sec = getDuration();
        int sec2 = sec % 60;
        int min = sec / 60;


        if (this.title == null) {
            title = "unknown";
        } else {
            title = this.title;
        }
        if (this.writer == null || this.writer.getName() == null) {
            writer = "unknown";
        } else {
            writer = this.writer.getName();
        }
        if (this.performer == null || this.performer.getName() == null) {
            performer = "unknown";
        } else {
            performer = this.performer.getName();
        }
        String formated = String.format("%10.10s by %10.10s performed by %10.10s (%02d:%02d)", title, writer, performer, min, sec2);
        return formated;
    }

    public String getTitle() {
        if (title == null) {
            title = "unknown title";
        }
        return title;
    }


    //Setter Methoden
    public void setPerformer(Artist performer) {
        if (performer == null)
            return;
        // Artist performer1 = new Artist(performer.getName());
        this.performer = performer;
    }

    public void setDuration(int duration) {
        if (duration < 0)
            return;
        if (duration == 0) {
            System.out.printf("unknown duration");
        }
        if (duration < 0) {
            return;
        }
        this.duration = duration;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            this.title = "unknown";
        } else
            this.title = title;
    }

    public void setWriter(Artist writer) {
        if (writer == null || writer.getName().isBlank()) {
            this.writer.setName("unknown");
        } else {
            this.writer = writer;
        }
    }

    public void setYear(int year) {
        if (year < 1900 || year > 2999)
            return;
        this.year = year;
    }

    public boolean writerIsKnown() {
        if (writer == null || writer.getName() == null) {
            return false;
        }
        if (writer != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return getString();
    }

    public boolean scan() {
        boolean fieldChanged = false, objectChanged = false;
        Scanner sc = new Scanner(System.in);
        String input;
        String inputDur;
        // scanning title
        do {
            System.out.printf("current title: %s\n", this.title);
            System.out.printf("enter new title (leave empty to keep):");
            input = sc.nextLine();
            if (input.length() == 0) { // keep old value?
                fieldChanged = false;
                break;
            }

            fieldChanged = true;
            break;
        } while (true);
        if (fieldChanged) {
            setTitle(input);
        }
        objectChanged = objectChanged || fieldChanged;
        fieldChanged = false; // set up for next field

        // scan next field(s)
        do {
            System.out.println("Duration: " + this.duration);
            System.out.printf("enter new Duration (enter 0 to keep):");
            inputDur = sc.nextLine();
            if (inputDur.isBlank()) { // keep old value?
                fieldChanged = false;
                break;
            }
            int duration = Integer.parseInt(inputDur);
            if(duration < 0){
                fieldChanged = false;
                continue;
            }
            fieldChanged = true;
            break;
        } while (true);
        if (fieldChanged) {
            int duration = Integer.parseInt(inputDur);
            setDuration(duration);
        }
        objectChanged = objectChanged || fieldChanged;


        return objectChanged;
    }
}

