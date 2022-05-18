package MusicLandscape.entities;

public abstract class Release {
    private Artist artist = new Artist();
    private String title = null;
    private int year = 1900;

    public Release(){
        this.artist = artist;
        this.title = title;
        this.year = year;
    }
    public Release(Release orig){
        this.artist = new Artist(orig.getArtist());
        this.title = orig.getTitle();
        this.year = orig.getYear();
    }
    public Release(String title, Artist artist, int year){
        this.title = title;
        this.artist = artist;
        this.year = year;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getTitle() {
        if(title == null)
            return "unknown";
        return title;
    }

    public int getYear() {
        if(year == 0)
            return 0;
        return year;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        if(title == null || title.isBlank())
            this.title = "unknown";
        this.title = title;
    }

    public void setYear(int year) {
        if(year < 0)
            return;
        this.year = year;
    }

    @Override
    public String toString() {
        return  getTitle() + "-" +
                getArtist() + "-" +
                (getYear() == 0 ? "unknown" : getYear()) + "-" +
                totalTime();
    }
    public abstract int totalTime();
}
