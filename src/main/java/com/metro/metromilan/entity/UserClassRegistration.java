package com.metro.metromilan.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.jetbrains.annotations.NotNull;
//import jakarta.validation.constraints.NotNull;

import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Table(name = "user_registration")
public class UserClassRegistration extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_uuid", insertable = false, updatable = false, nullable = false, columnDefinition = "VARCHAR(255)")
    private UUID userId;

    //@NotBlank(message = "Please provide the User Name")
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
    @Column(name = "user_interest")
    //@NotNull
    private String interest;

    @Column(name = "user_age")
    private int age=1000;
    @Column(name = "user_gender")
    private String gender="In-valid";
    @Column(name = "location")
    //@NotNull
    private String place;
    //Store place in Capital letters from frontend side...as logic for Fetching of first time user details from DB
    // have been configured in the capitalize form.
    //see flow of "firstTimeController"..

    @Column(name = "user_mob_number")
    //@NotBlank(message = "Mobile number must be Unique")
    private String mobileNumber;
    @Column(name = "user_email_id")
    //@NotBlank(message = "Email-id must be Unique")
    private String email_id;

//    @Column(name = "user_ceatedAt")
////    @CreatedDate
//    @CreationTimestamp
//    private OffsetDateTime UserTime;

    @Override
    public String toString() {
        return "UserClassRegistration{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", Interest='" + interest + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", Place='" + place + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email_id='" + email_id + '\'' +
                '}';
    }


//    public OffsetDateTime getUserTime() {
//        return UserTime;
//    }
//
//    public void setUserTime(OffsetDateTime userTime) {
//        UserTime = userTime;
//    }



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

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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
