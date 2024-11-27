package org.poc.bean;


import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable {
    private String username;
    private String password;

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
}