package dao;

import entity.Artwork;
import entity.Artist;
import entity.Gallery;
import entity.User;

import java.util.List;

public interface IVirtualArtGallery {
	
    
    // Artwork Methods
    void addArtwork(Artwork artwork) throws Exception;
    void updateArtwork(Artwork artwork) throws Exception;
    void deleteArtwork(int artworkID) throws Exception;
    Artwork getArtwork(int artworkID) throws Exception;
    List<Artwork> getAllArtworks() throws Exception;

    // Artist Methods
    void addArtist(Artist artist) throws Exception;
    void updateArtist(Artist artist) throws Exception;
    void deleteArtist(int artistID) throws Exception;
    Artist getArtist(int artistID) throws Exception;
    List<Artist> getAllArtists() throws Exception;

    // Gallery Methods
    void addGallery(Gallery gallery) throws Exception;
    void updateGallery(Gallery gallery) throws Exception;
    void deleteGallery(int galleryID) throws Exception;
    Gallery getGallery(int galleryID) throws Exception;
    List<Gallery> getAllGalleries() throws Exception;

    // User Methods
    void addUser(User user) throws Exception;
    void updateUser(User user) throws Exception;
    void deleteUser(int userID) throws Exception;
    User getUser(int userID) throws Exception;
    List<User> getAllUsers() throws Exception;
    
    //Other Methods 
    void addArtworkToFavorite(int UserID, String artworkId) throws Exception;
    void removeArtworkFromFavorite(int UserID, String artworkId) throws Exception;
    List<String> getUserFavoriteArtworks(int UserID) throws Exception;
}
