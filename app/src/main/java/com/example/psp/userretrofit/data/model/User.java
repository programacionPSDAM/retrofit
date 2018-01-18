package com.example.psp.userretrofit.data.model;

/**
 * Created by psp on 16/01/18.
 */



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class User {

    @SerializedName("_id")
    @Expose
    private Integer _id;
    @SerializedName("first_name")
    @Expose
    private String first_name;
    @SerializedName("last_name")
    @Expose
    private String last_name;
    @SerializedName("email")
    @Expose
    private String email;

    /**
     * No args constructor for use in serialization
     *
     */
    public User() {
    }

    /**
     *
     * @param id
     * @param lastName
     * @param email
     * @param firstName
     */
    public User(Integer id, String firstName, String lastName, String email) {
        super();
        this._id = id;
        this.first_name = firstName;
        this.last_name = lastName;
        this.email = email;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ").append(_id).append("User: ").append("-").append(first_name).append("-").
                append(last_name).append("-").append(email);
        return stringBuilder.toString();
    }
}
