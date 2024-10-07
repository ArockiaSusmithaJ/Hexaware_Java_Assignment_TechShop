package dao;
import java.time.LocalDate;
import entity.Artwork;
import entity.Artist;
import entity.Gallery;
import entity.User;
import util.DBConnUtil;

import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class VirtualArtGalleryDAO implements IVirtualArtGallery {
    // Add Artwork
    @Override
    public void addArtwork(Artwork artwork) throws Exception {
        String query = "INSERT INTO Artwork (Title, Description, CreationDate, Medium, ImageURL, ArtistID) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, artwork.getTitle());
            preparedStatement.setString(2, artwork.getDescription());
            preparedStatement.setDate(3, Date.valueOf(artwork.getCreationDate()));
            preparedStatement.setString(4, artwork.getMedium());
            preparedStatement.setString(5, artwork.getImageURL());
            preparedStatement.setInt(6, artwork.getArtistID());
            preparedStatement.executeUpdate();
        }
    }

    // Update Artwork
    @Override
    public void updateArtwork(Artwork artwork) throws Exception {
        String query = "UPDATE Artwork SET Title=?, Description=?, CreationDate=?, Medium=?, ImageURL=?, ArtistID=? WHERE ArtworkID=?";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, artwork.getTitle());
            preparedStatement.setString(2, artwork.getDescription());
            preparedStatement.setDate(3, Date.valueOf(artwork.getCreationDate()));
            preparedStatement.setString(4, artwork.getMedium());
            preparedStatement.setString(5, artwork.getImageURL());
            preparedStatement.setInt(6, artwork.getArtistID());
            preparedStatement.setInt(7, artwork.getArtworkID());
            preparedStatement.executeUpdate();
        }
    }

    // Delete Artwork
    @Override
    public void deleteArtwork(int artworkID) throws Exception {
        String query = "DELETE FROM Artwork WHERE ArtworkID=?";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, artworkID);
            preparedStatement.executeUpdate();
        }
    }

    // Get Artwork
    @Override
    public Artwork getArtwork(int artworkID) throws Exception {
        String query = "SELECT * FROM Artwork WHERE ArtworkID=?";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, artworkID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Artwork(
                    resultSet.getInt("ArtworkID"),
                    resultSet.getString("Title"),
                    resultSet.getString("Description"),
                    resultSet.getDate("CreationDate").toLocalDate(),
                    resultSet.getString("Medium"),
                    resultSet.getString("ImageURL"),
                    resultSet.getInt("ArtistID")
                );
            }
        }
        return null; // Artwork not found
    }

    // Get All Art works
    @Override
    public List<Artwork> getAllArtworks() throws Exception {
        List<Artwork> artworks = new ArrayList<>();
        String query = "SELECT * FROM Artwork";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                artworks.add(new Artwork(
                    resultSet.getInt("ArtworkID"),
                    resultSet.getString("Title"),
                    resultSet.getString("Description"),
                    resultSet.getDate("CreationDate").toLocalDate(),
                    resultSet.getString("Medium"),
                    resultSet.getString("ImageURL"),
                    resultSet.getInt("ArtistID")
                ));
            }
        }
        return artworks;
    }

    

    // Add Artist
    @Override
    public void addArtist(Artist artist) throws Exception {
        String query = "INSERT INTO Artist (Name, Biography, BirthDate, Nationality, Website, ContactInformation) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, artist.getName());
            preparedStatement.setString(2, artist.getBiography());
            preparedStatement.setString(3, artist.getBirthDate());
            preparedStatement.setString(4, artist.getNationality());
            preparedStatement.setString(5, artist.getWebsite());
            preparedStatement.setString(6, artist.getContactInformation());
            preparedStatement.executeUpdate();
        }
    }

    // Update Artist
    @Override
    public void updateArtist(Artist artist) throws Exception {
        String query = "UPDATE Artist SET Name=?, Biography=?, BirthDate=?, Nationality=?, Website=?, ContactInformation=? WHERE ArtistID=?";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, artist.getName());
            preparedStatement.setString(2, artist.getBiography());
            preparedStatement.setString(3, artist.getBirthDate());
            preparedStatement.setString(4, artist.getNationality());
            preparedStatement.setString(5, artist.getWebsite());
            preparedStatement.setString(6, artist.getContactInformation());
            preparedStatement.setInt(7, artist.getArtistID());
            preparedStatement.executeUpdate();
        }
    }

    // Delete Artist
    @Override
    public void deleteArtist(int artistID) throws Exception {
        String query = "DELETE FROM Artist WHERE ArtistID=?";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, artistID);
            preparedStatement.executeUpdate();
        }
    }

    // Get Artist
    @Override
    public Artist getArtist(int artistID) throws Exception {
        String query = "SELECT * FROM Artist WHERE ArtistID=?";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, artistID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Artist(
                    resultSet.getInt("ArtistID"),
                    resultSet.getString("Name"),
                    resultSet.getString("Biography"),
                    resultSet.getString("BirthDate"),
                    resultSet.getString("Nationality"),
                    resultSet.getString("Website"),
                    resultSet.getString("ContactInformation")
                );
            }
        }
        return null; // Artist not found
    }

    // Get All Artists
    @Override
    public List<Artist> getAllArtists() throws Exception {
        List<Artist> artists = new ArrayList<>();
        String query = "SELECT * FROM Artist";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                artists.add(new Artist(
                    resultSet.getInt("ArtistID"),
                    resultSet.getString("Name"),
                    resultSet.getString("Biography"),
                    resultSet.getString("BirthDate"),
                    resultSet.getString("Nationality"),
                    resultSet.getString("Website"),
                    resultSet.getString("ContactInformation")
                ));
            }
        }
        return artists;
    }

    // Add Gallery
    @Override
    public void addGallery(Gallery gallery) throws Exception {
        String query = "INSERT INTO Gallery (Name, Description, Location, Curator, OpeningHours) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, gallery.getName());
            preparedStatement.setString(2, gallery.getDescription());
            preparedStatement.setString(3, gallery.getLocation());
            preparedStatement.setInt(4, gallery.getCuratorID());
            preparedStatement.setString(5, gallery.getOpeningHours());
            preparedStatement.executeUpdate();
        }
    }

    // Update Gallery
    @Override
    public void updateGallery(Gallery gallery) throws Exception {
        String query = "UPDATE Gallery SET Name=?, Description=?, Location=?, Curator=?, OpeningHours=? WHERE GalleryID=?";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, gallery.getName());
            preparedStatement.setString(2, gallery.getDescription());
            preparedStatement.setString(3, gallery.getLocation());
            preparedStatement.setInt(4, gallery.getCuratorID());
            preparedStatement.setString(5, gallery.getOpeningHours());
            preparedStatement.setInt(6, gallery.getGalleryID());
            preparedStatement.executeUpdate();
        }
    }

    // Delete Gallery
    @Override
    public void deleteGallery(int galleryID) throws Exception {
        String query = "DELETE FROM Gallery WHERE GalleryID=?";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, galleryID);
            preparedStatement.executeUpdate();
        }
    }

    // Get Gallery
    @Override
    public Gallery getGallery(int galleryID) throws Exception {
        String query = "SELECT * FROM Gallery WHERE GalleryID=?";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, galleryID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Gallery(
                    resultSet.getInt("GalleryID"),
                    resultSet.getString("Name"),
                    resultSet.getString("Description"),
                    resultSet.getString("Location"),
                    resultSet.getInt("Curator"),
                    resultSet.getString("OpeningHours")
                );
            }
        }
        return null; // Gallery not found
    }

    // Get All Galleries
    @Override
    public List<Gallery> getAllGalleries() throws Exception {
        List<Gallery> galleries = new ArrayList<>();
        String query = "SELECT * FROM Gallery";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                galleries.add(new Gallery(
                    resultSet.getInt("GalleryID"),
                    resultSet.getString("Name"),
                    resultSet.getString("Description"),
                    resultSet.getString("Location"),
                    resultSet.getInt("Curator"),
                    resultSet.getString("OpeningHours")
                ));
            }
        }
        return galleries;
    }

    // Add User
    @Override
    public void addUser(User user) throws Exception {
        String query = "INSERT INTO User (Username, Password, Email, FirstName, LastName, DateOfBirth, ProfilePicture) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setString(6, user.getDateOfBirth().toString());
            preparedStatement.setString(7, user.getProfilePicture());
            preparedStatement.executeUpdate();
        }
    }

    // Update User
    @Override
    public void updateUser(User user) throws Exception {
        String query = "UPDATE User SET Username=?, Password=?, Email=?, FirstName=?, LastName=?, DateOfBirth=?, ProfilePicture=? WHERE UserID=?";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setString(6, user.getDateOfBirth().toString());
            preparedStatement.setString(7, user.getProfilePicture());
            preparedStatement.setInt(8, user.getUserID());
            preparedStatement.executeUpdate();
        }
    }

    // Delete User
    @Override
    public void deleteUser(int userID) throws Exception {
        String query = "DELETE FROM User WHERE UserID=?";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userID);
            preparedStatement.executeUpdate();
        }
    }

    // Get User
    @Override
    
    public User getUser(int userID) throws Exception {
        String query = "SELECT * FROM User WHERE UserID=?";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // Retrieve DateOfBirth as java.sql.Date and convert to LocalDate
                Date sqlDate = resultSet.getDate("DateOfBirth");
                LocalDate dateOfBirth = (sqlDate != null) ? sqlDate.toLocalDate() : null; // Handle possible null value

                return new User(
                    resultSet.getInt("UserID"),
                    resultSet.getString("Username"),
                    resultSet.getString("Password"),
                    resultSet.getString("Email"),
                    resultSet.getString("FirstName"),
                    resultSet.getString("LastName"),
                    resultSet.getString("DateOfBirth"), // Use the converted LocalDate
                    resultSet.getString("ProfilePicture")
                    // new ArrayList<>() // Uncomment if needed for favoriteArtworks
                );
            }
        }
        return null; // User not found
    }



 // Get All Users
    @Override
    public List<User> getAllUsers() throws Exception {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM User";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                // Retrieve DateOfBirth as java.sql.Date and convert to LocalDate
                Date sqlDate = resultSet.getDate("DateOfBirth");
                LocalDate dateOfBirth = (sqlDate != null) ? sqlDate.toLocalDate() : null; // Handle possible null value

                users.add(new User(
                    resultSet.getInt("UserID"),
                    resultSet.getString("Username"),
                    resultSet.getString("Password"),
                    resultSet.getString("Email"),
                    resultSet.getString("FirstName"),
                    resultSet.getString("LastName"),
                    resultSet.getString("DateOfBirth"),
                    resultSet.getString("ProfilePicture")
                    // new ArrayList<>() // Uncomment if needed for favoriteArtworks
                ));
            }
        }
        return users;
    }
    @Override
    public void addArtworkToFavorite(int UserID, String artworkId) throws Exception {
        String query = "INSERT INTO User_Favorite_Artwork (UserID, ArtworkID) VALUES (?, ?)";
        
        try (Connection conn = DBConnUtil.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, UserID);
            pstmt.setString(2, artworkId);
            pstmt.executeUpdate();
        }
    }

    @Override
    public void removeArtworkFromFavorite(int UserID, String artworkId) throws Exception {
        String query = "DELETE FROM User_Favorite_Artwork WHERE UserID = ? AND ArtworkID = ?";
        
        try (Connection conn = DBConnUtil.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, UserID);
            pstmt.setString(2, artworkId);
            pstmt.executeUpdate();
        }
    }

    @Override
    public List<String> getUserFavoriteArtworks(int UserID) throws Exception {
        List<String> favoriteArtworks = new ArrayList<>();
        String query = "SELECT ArtworkID FROM User_Favorite_Artwork WHERE UserID = ?";
        
        try (Connection conn = DBConnUtil.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, UserID);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                favoriteArtworks.add(rs.getString("ArtworkID"));
            }
        }
        return favoriteArtworks;
    }    
}