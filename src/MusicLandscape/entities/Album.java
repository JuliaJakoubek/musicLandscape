package MusicLandscape.entities;


public class Album extends Release {
    private TrackListItem trackListHead;
    Track track;

    private class TrackListItem{
        TrackListItem next;
        Track track;
        TrackListItem(Track t){
            this.track = t;
        }
    }

    public Album(){
    }
    public Album(Album orig){
        super(orig);
    }
    public Album (String title, Artist artist, int year){
        super(title, artist, year);
    }
    public boolean addTrack(Track t){
        if(t == null)
            return false;
        TrackListItem neu = new TrackListItem(t);
        if(trackListHead == null){
            trackListHead = neu;
            return true;
        }

        else{
            TrackListItem cur;
            for (cur = trackListHead; cur.next != null ; cur = cur.next) {
            }
            cur.next = neu;
        }
            return true;
    }
    public Track removeTrack(int n){
        Track track;
        int pos = 0;
        if(n == 0){
            track = trackListHead.track;
            trackListHead = trackListHead.next;
            return track;
        }
        for (TrackListItem cur = this.trackListHead; cur != null ; cur = cur.next){
            pos++;
            if(n == pos){
                track = cur.next.track;
                cur.next = cur.next.next;
                return track;
            }
        }
    return null;
    }
    public int nrTracks(){
        int nr = 0;
        for (TrackListItem cur = trackListHead; cur != null ; cur = cur.next){
            nr++;
        }
        return nr;
    }
    public Track[] getTracks(){
        Track[] tracks = new Track[this.nrTracks()];
        if(trackListHead == null)
            return tracks;
        int pos = 0;
        for (TrackListItem cur = trackListHead; cur != null ; cur = cur.next){
            tracks[pos] = cur.track;
            pos++;
        }
        return tracks;
    }
    public int totalTime(){
        int time = 0;
        for (TrackListItem cur = trackListHead; cur != null ; cur = cur.next){
            time += cur.track.getDuration();
        }
        return time;
    }

    @Override
    public String toString() {
        String album = super.toString() + "\n" + "[";
                Track[] tmp = getTracks();
        for (Track t : tmp) {
            album += "[" + t.getTitle() + "]";
        }
        album += "]";
        return album;
    }
}

