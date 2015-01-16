package edu.tutorial.web.bean;

import java.util.Map;

/**
 * Created by vladimirkr on 1/16/2015.
 */
public class UserData {
    private final int id;
    private final String firstName;
    private final String secondName;
    private final String username;
    private final String password;
    private final String email;
    private final int sexId;
    private final int professionId;
    private final int languageId;

    private UserData(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.secondName = builder.secondName;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.sexId = builder.sexId;
        this.professionId = builder.professionId;
        this.languageId = builder.languageId;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public int getProfessionId() {
        return professionId;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getSexId() {
        return sexId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (id != userData.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "email='" + email + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sexId=" + sexId +
                ", professionId=" + professionId +
                ", languageId=" + languageId +
                '}';
    }

    public static class Builder {
        private int id;
        private String firstName;
        private String secondName;
        private String username;
        private String password;
        private String email;
        private int sexId;
        private int professionId;
        private int languageId;

        public Builder() {
        }

        public Builder(UserData userData) {
            this.id = userData.id;
            this.firstName = userData.firstName;
            this.secondName = userData.secondName;
            this.username = userData.username;
            this.password = userData.password;
            this.email = userData.email;
            this.sexId = userData.sexId;
            this.professionId = userData.professionId;
            this.languageId = userData.languageId;
        }

        public Builder(Map<String, String[]> userData) {
            this.id = -1;//userData.get("id")[0];
            this.firstName = userData.get("firstName")[0];
            this.secondName = userData.get("secondName")[0];
            this.username = userData.get("username")[0];
            this.password = userData.get("password")[0];
            this.email = userData.get("email")[0];
            this.sexId = Integer.parseInt(userData.get("sexId")[0]);
            this.professionId = Integer.parseInt(userData.get("professionId")[0]);
            this.languageId = Integer.parseInt(userData.get("languageId")[0]);
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setProfessionId(int professionId) {
            this.professionId = professionId;
            return this;
        }

        public Builder setSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Builder setSexId(int sexId) {
            this.sexId = sexId;
            return this;
        }

        public Builder setLanguageId(int languageId) {
            this.languageId = languageId;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserData build() {
            return new UserData(this);
        }
    }
}
