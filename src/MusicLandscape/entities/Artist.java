package MusicLandscape.entities;

public class Artist {
    private String name;

    public Artist(){
        setName("unknown");
    }
    public Artist(String name){
        this.name = name;
    }
    public Artist(Artist a){
        this.name = a.name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            return;
        }
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public String toString(){
        if(getName() == null){
            return "unknown";
        }
        return name;
    }

}
