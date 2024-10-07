package entity;

import java.time.LocalDate;

public class User {
	private int userID;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String dateOfBirth; // Change to LocalDate
    private String profilePicture; // URL or path to the profile picture

    // Constructor
    public User(int userID,String username, String password, String email, String firstName, String lastName, String dateOfBirth, String profilePicture) {
        this.userID=userID;
    	this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth; // Set the date of birth
        this.profilePicture = profilePicture; // Set the profile picture
    }
    public User(String username, String password, String email, String firstName, String lastName, String dateOfBirth, String profilePicture) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth; // Keep as String
        this.profilePicture = profilePicture;
        
    }
    // Getters and Setters
    public int getUserID() {
    	return userID;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth; // Getter for dateOfBirth
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth; // Setter for dateOfBirth
    }

    public String getProfilePicture() {
        return profilePicture; // Getter for profilePicture
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture; // Setter for profilePicture
    }

    @Override
    public String toString() {
        return "\n" +"\nUserID='" + userID + '\''+
                "\nUsername='" + username + '\'' +
                ", \nEmail='" + email + '\'' +
                ", \nFirstName='" + firstName + '\'' +
                ", \nLastName='" + lastName + '\'' +
                ", \nDateOfBirth=" + dateOfBirth + // Include dateOfBirth in the toString
                ", \nProfilePicture='" + profilePicture  + // Include profilePicture in the toString
                '}';
    }
}
