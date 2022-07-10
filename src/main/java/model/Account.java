package model;

public class Account 
{
    private String username;
    private String password;
    private String fullname;
    private boolean role;
    private boolean status;

    public Account() {
    }

    public Account(String username, String password, String fullname, boolean role, boolean status) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
        this.status = status;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
