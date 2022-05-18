package MusicLandscape.entities;

import MusicLandscape.entities.Track;

import java.util.Arrays;

public class Concert extends Event{
    private int nextIdx = 0;
    private Track[] setList = new Track[0];

    public Concert(){
    }
    public Track[] getSetList(){
        Track[] copy = new Track[setList.length];
        for (int i = 0; i < setList.length; i++) {
            copy[i] = new Track(setList[i]);
        }
        return copy;
    }

    public boolean addTrack(Track t){
        if(t == null){
            return false;
        }
        else{
            ensureCapacity(setList.length + 1);
            setList[nextIdx] = t;
            nextIdx++;
        }
        return true;
    }
    public void ensureCapacity(int length){
        Track[] temp = new Track[length];
        for (int i = 0; i < nextIdx; i++) {
            temp[i] = setList[i];
        }
        setList = temp;
    }
    public int duration(){
        int duration = 0;
        if (setList != null){
            for (int i = 0; i < setList.length; i++) {
                int d = setList[i].getDuration();
                duration += d;
            }
        }
        return duration;
    }
    public int impact(){
        int d = duration();
        int a = getAttendees();
        int factor = 1 + (d / 1800);
        int impact = a * factor;
        return impact;
    }
    public int nrTracks(){
        return nextIdx;
    }
    public void resetSetList(){
        for (int i = 0; i < setList.length; i++) {
            setList[i] = null;
            nextIdx--;
        }

    }
    public void setSetList(Track[] tracks){
        resetSetList();
        for (int i = 0; i < tracks.length; i++) {
            if(tracks[i]==null)
                continue;
            else
                addTrack(new Track(tracks[i]));
        }

    }

    public String toString() {
        String event = super.toString();
        int sec = duration();
        int hours = sec / 3600;
        int min = (sec % 3600) / 60;
        return  event + "\n" +
                nextIdx + " tracks played, " +
                "total duration 0" + hours + ":" + min + ".";
    }



}
