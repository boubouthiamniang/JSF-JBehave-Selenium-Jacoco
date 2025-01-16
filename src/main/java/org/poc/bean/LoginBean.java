package org.poc.bean;


import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@SessionScoped
public class LoginBean implements Serializable {
    private String username;
    private String password;

    private String newUsername;  // New username for update
    private String newPassword;

    private static final Map<String, String> users = new HashMap<>();
    private String selectedUser=null; // Store the selected user for update

    static {
        users.put("admin", "password");
        users.put("bob", "zik");
        users.put("tony", "1245");
        users.put("root", "super");
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

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(String selectedUser) {
        this.selectedUser = selectedUser;
    }

    public String login() {
        // Simple validation logic (replace with your actual logic)
        if ("admin".equals(username) && "password".equals(password)) {
            return "welcome.xhtml?faces-redirect=true"; // Redirect to a welcome page
        } else {
            return null; // Stay on the login page
        }
    }

    public String logout() {
        // Invalidate the session and return to login page
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login.xhtml?faces-redirect=true";
    }

    public String registration() {
        if (users.containsKey(username)) {
            // Username already exists
            FacesContext.getCurrentInstance().addMessage(null,
                    new jakarta.faces.application.FacesMessage("Username already exists"));
            return null;
        } else {
            users.put(username, password);
            return "login.xhtml?faces-redirect=true"; // Redirect to login page
        }
    }

    public List<String> getAllUsers() {
        return new ArrayList<>(users.keySet());
    }

    public String goToUpdatePage() {
        if (selectedUser == null || selectedUser.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new jakarta.faces.application.FacesMessage("Please select a user to update."));
            //return null;
            //TODO - Fix selectedUser empty and remove this to keep return null
            return "update-user.xhtml?faces-redirect=true";
        }
        //TODO - Unreachable before Fixing selectedUser empty problem
        return "update-user.xhtml?faces-redirect=true";
    }

    public String updateUser() {
        //TODO - Fix selectedUser empty and remove assignation
        selectedUser="tony";
        if (newUsername == null || newPassword == null || newUsername.isEmpty() || newPassword.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new jakarta.faces.application.FacesMessage("Both username and password are required."));
            return null;
        }

        if (users.containsKey(selectedUser)) {
            users.remove(selectedUser);
            users.put(newUsername, newPassword);
        }

        return "welcome.xhtml?faces-redirect=true";
    }

    public String deleteUser() {
        if (selectedUser == null || selectedUser.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new jakarta.faces.application.FacesMessage("Please select a user to update."));

            //return null;
            //TODO - Fix selectedUser empty and remove this to keep return null
            users.remove("tony");
            return "welcome.xhtml?faces-redirect=true";
        }
        //TODO - Unreachable before Fixing selectedUser empty problem
        return "welcome.xhtml?faces-redirect=true";
    }
}
