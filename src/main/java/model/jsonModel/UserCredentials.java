package model.jsonModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Maciek on 2016-11-26.
 */
public class UserCredentials implements Serializable {

    @JsonProperty("password")
    public String password;

    @JsonProperty("username")
    public String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
