package entity;

public class Gallery {
    private int galleryID;  // Primary key
    private String name;
    private String description;
    private String location;
    private int curatorID;  // Reference to the Artist
    private String openingHours;

    // Constructor for adding gallery
    public Gallery(String name, String description, String location, int curatorID, String openingHours) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.curatorID = curatorID;
        this.openingHours = openingHours;
    }

    // Constructor for updating gallery
    public Gallery(int galleryID, String name, String description, String location, int curatorID, String openingHours) {
        this.galleryID = galleryID;
        this.name = name;
        this.description = description;
        this.location = location;
        this.curatorID = curatorID;
        this.openingHours = openingHours;
    }

    // Getters and Setters
    public int getGalleryID() {
        return galleryID;
    }

    public void setGalleryID(int galleryID) {
        this.galleryID = galleryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCuratorID() {
        return curatorID;
    }

    public void setCuratorID(int curatorID) {
        this.curatorID = curatorID;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    @Override
    public String toString() {
        return "\n" +
                "\nGalleryID=" + galleryID +
                ", \nName='" + name + '\'' +
                ", \nDescription='" + description + '\'' +
                ", \nLocation='" + location + '\'' +
                ", \nCuratorID=" + curatorID +
                ", \nOpeningHours='" + openingHours + '\'' ;
    }
}
