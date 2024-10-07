package dao;

import entity.Artwork;
import entity.Artist;
import entity.Gallery;
import entity.User;

import java.util.List;

public class VirtualArtGalleryServiceImpl implements IVirtualArtGallery {
    
    private final IVirtualArtGallery virtualArtGalleryDAO;

    public VirtualArtGalleryServiceImpl(IVirtualArtGallery virtualArtGalleryDAO) {
        this.virtualArtGalleryDAO = virtualArtGalleryDAO;
    }

    @Override
    public void addArtwork(Artwork artwork) throws Exception {
        virtualArtGalleryDAO.addArtwork(artwork);
    }

    @Override
    public void updateArtwork(Artwork artwork) throws Exception {
        virtualArtGalleryDAO.updateArtwork(artwork);
    }

    @Override
    public void deleteArtwork(int artworkID) throws Exception {
        virtualArtGalleryDAO.deleteArtwork(artworkID);
    }

    @Override
    public Artwork getArtwork(int artworkID) throws Exception {
        return virtualArtGalleryDAO.getArtwork(artworkID);
    }

    @Override
    public List<Artwork> getAllArtworks() throws Exception {
        return virtualArtGalleryDAO.getAllArtworks();
    }

    @Override
    public void addArtist(Artist artist) throws Exception {
        virtualArtGalleryDAO.addArtist(artist);
    }

    @Override
    public void updateArtist(Artist artist) throws Exception {
        virtualArtGalleryDAO.updateArtist(artist);
    }

    @Override
    public void deleteArtist(int artistID) throws Exception {
        virtualArtGalleryDAO.deleteArtist(artistID);
    }

    @Override
    public Artist getArtist(int artistID) throws Exception {
        return virtualArtGalleryDAO.getArtist(artistID);
    }

    @Override
    public List<Artist> getAllArtists() throws Exception {
        return virtualArtGalleryDAO.getAllArtists();
    }

    @Override
    public void addGallery(Gallery gallery) throws Exception {
        virtualArtGalleryDAO.addGallery(gallery);
    }

    @Override
    public void updateGallery(Gallery gallery) throws Exception {
        virtualArtGalleryDAO.updateGallery(gallery);
    }

    @Override
    public void deleteGallery(int galleryID) throws Exception {
        virtualArtGalleryDAO.deleteGallery(galleryID);
    }

    @Override
    public Gallery getGallery(int galleryID) throws Exception {
        return virtualArtGalleryDAO.getGallery(galleryID);
    }

    @Override
    public List<Gallery> getAllGalleries() throws Exception {
        return virtualArtGalleryDAO.getAllGalleries();
    }

    @Override
    public void addUser(User user) throws Exception {
        virtualArtGalleryDAO.addUser(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        virtualArtGalleryDAO.updateUser(user);
    }

    @Override
    public void deleteUser(int userID) throws Exception {
        virtualArtGalleryDAO.deleteUser(userID);
    }

    @Override
    public User getUser(int userID) throws Exception {
        return virtualArtGalleryDAO.getUser(userID);
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        return virtualArtGalleryDAO.getAllUsers();
    }
    
    public void addArtworkToFavorite(int UserID, String artworkId) throws Exception {
        virtualArtGalleryDAO.addArtworkToFavorite(UserID, artworkId);
    }

    public void removeArtworkFromFavorite(int UserID, String artworkId) throws Exception {
        virtualArtGalleryDAO.removeArtworkFromFavorite(UserID, artworkId);
    }

    public List<String> getUserFavoriteArtworks(int UserID) throws Exception {
        return virtualArtGalleryDAO.getUserFavoriteArtworks(UserID);
    }
}
