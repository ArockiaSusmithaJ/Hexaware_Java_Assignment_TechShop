package main;

import dao.VirtualArtGalleryDAO;
import entity.Artwork;
import entity.Artist;
import entity.Gallery;
import entity.User;
import exception.*;
import util.DBConnUtil;
import util.DBPropertyUtil;
import dao.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainModule {
    private static final Scanner scanner = new Scanner(System.in);
    private static final VirtualArtGalleryDAO galleryDAO = new VirtualArtGalleryDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("**************************************************************************************************************************");
            System.out.println("                                                  Welcome to the VIRTUAL ART GALLERY!                                     ");
            System.out.println("**************************************************************************************************************************");
            System.out.println("                                                                 MENU");
            System.out.println("**************************************************************************************************************************\n");
            System.out.println("              1. Add Artwork                 11. Add Gallery                21. Add Artwork to Favorite");
            System.out.println("              2. Update Artwork              12. Update Gallery             22. Remove Artwork from Favorite");
            System.out.println("              3. Delete Artwork              13.Delete Gallery              23. Get User Favorite Artworks");
            System.out.println("              4. Get Artwork                 14. Get Gallery                24. Exit");
            System.out.println("              5. Get All Artworks            15. Get All Galleries");
            System.out.println("              6. Add Artist                  16. Add User");
            System.out.println("              7. Update Artist               17. Update User");
            System.out.println("              8. Delete Artist               18. Delete User");
            System.out.println("              9. Get Artist                  19. Get User");
            System.out.println("              10. Get All Artists            20. Get All Users\n");
            System.out.println("**************************************************************************************************************************");
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    addArtwork();
                    break;
                case 2:
                    updateArtwork();
                    break;
                case 3:
                    deleteArtwork();
                    break;
                case 4:
                    getArtwork();
                    break;
                case 5:
                    getAllArtworks();
                    break;
                case 6:
                    addArtist();
                    break;
                case 7:
                    updateArtist();
                    break;
                case 8:
                    deleteArtist();
                    break;
                case 9:
                    getArtist();
                    break;
                case 10:
                    getAllArtists();
                    break;
                case 11:
                    addGallery();
                    break;
                case 12:
                    updateGallery();
                    break;
                case 13:
                    deleteGallery();
                    break;
                case 14:
                    getGallery();
                    break;
                case 15:
                    getAllGalleries();
                    break;
                case 16:
                    addUser();
                    break;
                case 17:
                    updateUser();
                    break;
                case 18:
                    deleteUser();
                    break;
                case 19:
                    getUser();
                    break;
                case 20:
                    getAllUsers();
                    break;
                case 21:
                    addArtworkToFavorite();
                    break;
                case 22:
                    removeArtworkFromFavorite();
                    break;
                case 23:
                    getUserFavoriteArtworks();
                    break;
                case 24:	
                    System.out.println("Exiting...");
                    System.out.println("Thank You! Visit Again:)");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addArtwork() {
        System.out.println("Enter Artwork Title:");
        String title = scanner.nextLine();
        System.out.println("Enter Artwork Description:");
        String description = scanner.nextLine();
        System.out.println("Enter Creation Date (YYYY-MM-DD):");
        LocalDate creationDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter Medium:");
        String medium = scanner.nextLine();
        System.out.println("Enter Image URL:");
        String imageURL = scanner.nextLine();
        System.out.println("Enter Artist ID:");
        int artistID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Artwork artwork = new Artwork(title, description, creationDate, medium, imageURL, artistID);
        try {
            galleryDAO.addArtwork(artwork);
            System.out.println("Artwork added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding artwork: " + e.getMessage());
        }
    }

    private static void updateArtwork() {
        System.out.println("Enter Artwork ID to update:");
        int artworkID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new Artwork Title:");
        String title = scanner.nextLine();
        System.out.println("Enter new Artwork Description:");
        String description = scanner.nextLine();
        System.out.println("Enter new Creation Date (YYYY-MM-DD):");
        LocalDate creationDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter new Medium:");
        String medium = scanner.nextLine();
        System.out.println("Enter new Image URL:");
        String imageURL = scanner.nextLine();
        System.out.println("Enter new Artist ID:");
        int artistID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Artwork artwork = new Artwork(artworkID, title, description, creationDate, medium, imageURL, artistID);
        try {
            galleryDAO.updateArtwork(artwork);
            System.out.println("Artwork updated successfully!");
        } catch (Exception e) {
            System.out.println("Error updating artwork: " + e.getMessage());
        }
    }

    private static void deleteArtwork() {
        System.out.println("Enter Artwork ID to delete:");
        int artworkID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            galleryDAO.deleteArtwork(artworkID);
            System.out.println("Artwork deleted successfully!");
        } catch (Exception e) {
            System.out.println("Error deleting artwork: " + e.getMessage());
        }
    }

    private static void getArtwork() {
        System.out.println("Enter Artwork ID to retrieve:");
        int artworkID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            Artwork artwork = galleryDAO.getArtwork(artworkID);
            if (artwork != null) {
                System.out.println("Artwork Details: " + artwork);
            } else {
                System.out.println("Artwork not found.");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving artwork: " + e.getMessage());
        }
    }

    private static void getAllArtworks() {
        try {
            List<Artwork> artworks = galleryDAO.getAllArtworks();
            if (artworks.isEmpty()) {
                System.out.println("No artworks found.");
            } else {
                artworks.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving artworks: " + e.getMessage());
        }
    }

    private static void addArtist() {
        System.out.println("Enter Artist Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Artist Biography:");
        String biography = scanner.nextLine();

        System.out.println("Enter Artist Birth Date (YYYY-MM-DD):");
        String birthDate = scanner.nextLine(); // Keeping birthDate as a String

        System.out.println("Enter Artist Nationality:");
        String nationality = scanner.nextLine();

        System.out.println("Enter Artist Website:");
        String website = scanner.nextLine();

        System.out.println("Enter Artist Contact Information:");
        String contactInfo = scanner.nextLine();

        Artist artist = new Artist(name, biography, birthDate, nationality, website, contactInfo);
        try {
            galleryDAO.addArtist(artist);
            System.out.println("Artist added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding artist: " + e.getMessage());
        }
    }


    private static void updateArtist() {
        System.out.println("Enter Artist ID to update:");
        int artistID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new Artist Name:");
        String name = scanner.nextLine();
        System.out.println("Enter new Artist Biography:");
        String biography = scanner.nextLine();
        System.out.println("Enter new Artist Birth Date (YYYY-MM-DD):");
        String birthDate = scanner.nextLine();
        System.out.println("Enter new Artist Nationality:");
        String nationality = scanner.nextLine();
        System.out.println("Enter new Artist Website:");
        String website = scanner.nextLine();
        System.out.println("Enter new Artist Contact Information:");
        String contactInfo = scanner.nextLine();
        //artistID, String name, String biography, String birthDate, String nationality, String website, String contactInformation)
        Artist artist = new Artist(artistID, name, biography, birthDate, nationality, website, contactInfo);
        try {
            galleryDAO.updateArtist(artist);
            System.out.println("Artist updated successfully!");
        } catch (Exception e) {
            System.out.println("Error updating artist: " + e.getMessage());
        }
    }

    private static void deleteArtist() {
        System.out.println("Enter Artist ID to delete:");
        int artistID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            galleryDAO.deleteArtist(artistID);
            System.out.println("Artist deleted successfully!");
        } catch (Exception e) {
            System.out.println("Error deleting artist: " + e.getMessage());
        }
    }

    private static void getArtist() {
        System.out.println("Enter Artist ID to retrieve:");
        int artistID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            Artist artist = galleryDAO.getArtist(artistID);
            if (artist != null) {
                System.out.println("Artist Details: " + artist);
            } else {
                System.out.println("Artist not found.");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving artist: " + e.getMessage());
        }
    }

    private static void getAllArtists() {
        try {
            List<Artist> artists = galleryDAO.getAllArtists();
            if (artists.isEmpty()) {
                System.out.println("No artists found.");
            } else {
                artists.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving artists: " + e.getMessage());
        }
    }

    private static void addGallery() {
        System.out.println("Enter Gallery Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Gallery Description:");
        String description = scanner.nextLine();
        System.out.println("Enter Gallery Location:");
        String location = scanner.nextLine();
        System.out.println("Enter Curator (Artist ID):");
        int curatorID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Opening Hours:");
        String openingHours = scanner.nextLine();

        Gallery gallery = new Gallery(name, description, location, curatorID, openingHours);
        try {
            galleryDAO.addGallery(gallery);
            System.out.println("Gallery added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding gallery: " + e.getMessage());
        }
    }

    private static void updateGallery() {
        System.out.println("Enter Gallery ID to update:");
        int galleryID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new Gallery Name:");
        String name = scanner.nextLine();
        System.out.println("Enter new Gallery Description:");
        String description = scanner.nextLine();
        System.out.println("Enter new Gallery Location:");
        String location = scanner.nextLine();
        System.out.println("Enter new Curator (Artist ID):");
        int curatorID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter new Opening Hours:");
        String openingHours = scanner.nextLine();

        Gallery gallery = new Gallery(galleryID, name, description, location, curatorID, openingHours);
        try {
            galleryDAO.updateGallery(gallery);
            System.out.println("Gallery updated successfully!");
        } catch (Exception e) {
            System.out.println("Error updating gallery: " + e.getMessage());
        }
    }

    private static void deleteGallery() {
        System.out.println("Enter Gallery ID to delete:");
        int galleryID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            galleryDAO.deleteGallery(galleryID);
            System.out.println("Gallery deleted successfully!");
        } catch (Exception e) {
            System.out.println("Error deleting gallery: " + e.getMessage());
        }
    }

    private static void getGallery() {
        System.out.println("Enter Gallery ID to retrieve:");
        int galleryID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            Gallery gallery = galleryDAO.getGallery(galleryID);
            if (gallery != null) {
                System.out.println("Gallery Details: " + gallery);
            } else {
                System.out.println("Gallery not found.");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving gallery: " + e.getMessage());
        }
    }

    private static void getAllGalleries() {
        try {
            List<Gallery> galleries = galleryDAO.getAllGalleries();
            if (galleries.isEmpty()) {
                System.out.println("No galleries found.");
            } else {
                galleries.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving galleries: " + e.getMessage());
        }
    }

    private static void addUser() {
    	//System.out.println("Enter UserID:");
        //int userID = scanner.nextInt();
        System.out.println("Enter Username:");
        String username = scanner.nextLine();
        System.out.println("Enter Password:");
        String password = scanner.nextLine();
        System.out.println("Enter Email:");
        String email = scanner.nextLine();
        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter Date of Birth (YYYY-MM-DD):");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Enter Profile Picture URL:");
        String profilePicture = scanner.nextLine();

        User user = new User(username, password, email, firstName, lastName, dateOfBirth, profilePicture);
        try {
            galleryDAO.addUser(user);
            System.out.println("User added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }

    private static void updateUser() {
        System.out.println("Enter User ID to update:");
        int userID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new Username:");
        String username = scanner.nextLine();
        System.out.println("Enter new Password:");
        String password = scanner.nextLine();
        System.out.println("Enter new Email:");
        String email = scanner.nextLine();
        System.out.println("Enter new First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter new Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter new Date of Birth (YYYY-MM-DD):");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Enter new Profile Picture URL:");
        String profilePicture = scanner.nextLine();

        User user = new User(userID, username, password, email, firstName, lastName, dateOfBirth, profilePicture);
        try {
            galleryDAO.updateUser(user);
            System.out.println("User updated successfully!");
        } catch (Exception e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
    }

    private static void deleteUser() {
        System.out.println("Enter User ID to delete:");
        int userID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            galleryDAO.deleteUser(userID);
            System.out.println("User deleted successfully!");
        } catch (Exception e) {
            System.out.println("Error deleting user: " + e.getMessage());
        }
    }

    private static void getUser() {
        System.out.println("Enter User ID to retrieve:");
        int userID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            User user = galleryDAO.getUser(userID);
            if (user != null) {
                System.out.println("User Details: " + user);
            } else {
                System.out.println("User not found.");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving user: " + e.getMessage());
        }}
        private static void getAllUsers() {
            try {
                List<User> users = galleryDAO.getAllUsers();
                if (users.isEmpty()) {
                    System.out.println("No users found.");
                } else {
                    System.out.println("Users:");
                    for (User user : users) {
                        System.out.println("Username: " + user.getUsername() + ", Name: " + user.getFirstName() + " " + user.getLastName());
                    }
                }
            } catch (Exception e) {
                System.out.println("Error fetching users: " + e.getMessage());
            }
        }

        // Method to add artwork to favorite
        private static void addArtworkToFavorite() {
            System.out.println("Enter UserID:");
            int UserID = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.println("Enter Artwork ID to add to favorites:");
            String artworkId = scanner.nextLine();
            
            // Validate input
            if (artworkId.isEmpty() || !artworkId.matches("\\d+")) {
                System.out.println("Invalid Artwork ID. Please enter a valid number.");
                return;
            }

           // int artworkID = Integer.parseInt(artworkIdInput);
            
            try {
                galleryDAO.addArtworkToFavorite(UserID, artworkId);
                System.out.println("Artwork added to favorites successfully!");
            } catch (Exception e) {
                System.out.println("Error adding artwork to favorites: " + e.getMessage());
            }
        }


        // Method to remove artwork from favorite
        private static void removeArtworkFromFavorite() {
            System.out.println("Enter UserID:");
            int userID = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.println("Enter Artwork ID to remove from favorites:");
            String artworkId = scanner.nextLine(); // Now this will correctly read the user input

            // Validate the artworkId
            if (artworkId.isEmpty() || !artworkId.matches("\\d+")) {
                System.out.println("Invalid Artwork ID. Please enter a valid number.");
                return;
            }

            try {
                // Convert artworkId to integer before passing to the DAO method
                
                galleryDAO.removeArtworkFromFavorite(userID, artworkId);
                System.out.println("Artwork removed from favorites successfully!");
            } catch (Exception e) {
                System.out.println("Error removing artwork from favorites: " + e.getMessage());
            }
        }

        // Method to get user's favorite artworks
        private static void getUserFavoriteArtworks() {
            System.out.println("Enter UserID:");
            int UserID = scanner.nextInt();

            try {
                List<String> favoriteArtworks = galleryDAO.getUserFavoriteArtworks(UserID);
                if (favoriteArtworks.isEmpty()) {
                    System.out.println("No favorite artworks found for this user.");
                } else {
                    System.out.println("Favorite Artworks for " + UserID + ":");
                    for (String artworkId : favoriteArtworks) {
                        System.out.println("Artwork ID: " + artworkId);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error fetching favorite artworks: " + e.getMessage());
            }
        }
    
    
}
