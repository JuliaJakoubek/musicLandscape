package MusicLandscape.entities;

public class MusicVideo extends Release{
    private Track track;

    public  MusicVideo(){
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
    public int totalTime(){
        if(getTrack() == null)
            return 0;
        int time = getTrack().getDuration();
        return time;
    }

    @Override
    public String toString() {
        return super.toString() + "-(Video)";
    }
}
