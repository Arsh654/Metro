package com.metro.metromilan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
@Builder
public class UserClassRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_uuid", insertable = false, updatable = false, nullable = false, columnDefinition = "VARCHAR(255)")
    private UUID userId;

    @NotBlank(message = "Please provide the User Name")
    @Column(name = "user_name")
    private String name;

    /*
    * Storing a List in a single DB is Not a good idea & Also Considered as a violation of normalization.
    * that's why we have the new DB as "USER_CLASS_REGISTRATION_INTEREST" just for storing the interest of the users.
    * and schema looks like we have a mapping of "ids" vs "interest"
    *
        USER_CLASS_REGISTRATION_ID  	    INTEREST
            1	                             play
            1	                             music
            1	                             read
            2	                             A
            2	                             B
            2                                C

     //Related Articles.
    * https://softwareengineering.stackexchange.com/questions/358913/is-storing-a-list-of-strings-in-single-database-field-a-bad-idea-why
    * */
    @ElementCollection
    @Column(name = "user_interest")
    private List <String> Interest;

    @Column(name = "user_age")
    private int age;
    @Column(name = "user_gender")
    private String gender;

    @Column(name = "user_mob_number", unique = true )
    @NotBlank(message = "Mobile number must not be Empty")
    private String mobileNumber;
    @Column(name = "user_email_id", unique = true)
    @NotBlank(message = "Email-id must not be Empty")
    private String email_id;

    @Override
    public String toString() {
        return "UserClassRegistration{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", Interest=" + Interest +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email_id='" + email_id + '\'' +
                '}';
    }

    public UserClassRegistration(UUID userId, String name, List<String> interest, int age, String gender, String mobileNumber, String email_id) {
        this.userId = userId;
        this.name = name;
        Assert.notNull(interest, "Interest result items list should not be null");
        //Interest = interest;
        this.age = age;
        this.gender = gender;
        Assert.notNull(mobileNumber, "Mobile number must not be Empty");
        //this.mobileNumber = mobileNumber;
        this.email_id = email_id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getInterest() {
        return Interest;
    }

    public void setInterest(List<String> interest) {
        Interest = interest;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }
}
