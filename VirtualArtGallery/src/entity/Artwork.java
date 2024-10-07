package entity;

import java.time.LocalDate;

public class Artwork {
    private int artworkID;  // Primary key
    private String title;
    private String description;
    private LocalDate creationDate; // Change to LocalDate
    private String medium;
    private String imageURL;
    private int artistID; // Reference to the Artist ID

    // Constructor for adding artwork
    public Artwork(String title, String description, LocalDate creationDate, String medium, String imageURL, int artistID) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate; // Set the creation date
        this.medium = medium;
        this.imageURL = imageURL;
        this.artistID = artistID; // Set the artist ID
    }

    // Constructor for updating artwork
    public Artwork(int artworkID, String title, String description, LocalDate creationDate, String medium, String imageURL, int artistID) {
        this.artworkID = artworkID;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate; // Set the creation date
        this.medium = medium;
        this.imageURL = imageURL;
        this.artistID = artistID; // Set the artist ID
    }

    // Getters and Setters
    public int getArtworkID() {
        return artworkID;
    }

    public void setArtworkID(int artworkID) {
        this.artworkID = artworkID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate; // Return LocalDate
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate; // Setter for creationDate
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getArtistID() {
        return artistID; // Getter for artistID
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID; // Setter for artistID
    }

    @Override
    public String toString() {
        return "\n" +
                "\nArtworkID=" + artworkID +
                ", \nTitle='" + title + '\'' +
                ", \nDescription='" + description + '\'' +
                ", \nCreationDate=" + creationDate + // Include creationDate in the toString
                ", \nMedium='" + medium + '\'' +
                ", \nImageURL='" + imageURL + '\'' +
                ", \nArtistID=" + artistID // Include artistID in the toString
          ;
    }
}
