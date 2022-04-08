package com.cortexits.pharmacy.model;

//import jakarta.persistence.*;
//import jakarta.xml.bind.annotation.XmlRootElement;
//import org.hibernate.annotations.GenericGenerator;

//import jakarta.xml.bind.annotation.XmlRootElement;

import com.cortexits.pharmacy.utils.DatabaseUtil;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//@Entity
//@Table(name = "users")
//@XmlRootElement(name = "users")
public class User extends BaseModel {

    private static User instance;

    private String firstName;
    private String lastName;
    private String userName;
    private String phoneNo;
    private String email;
    private String password;
    private String longPassword;
    private Double costPerHour;
    private Boolean clockedIn;
    private Boolean canLoginInCloud;
    private Boolean posLiveEnable;
    private Date lastClockInTime;
    private Date lastClockOutTime;
    private Boolean staffBank;
    private Boolean autoStartStaffBank;
    private Boolean staffBankStarted;
    private Boolean blindAccountableAmount;
    private Boolean availableForDelivery;
    private Boolean active;
    private String imageId;
    private Boolean root;
    private String outletId;
    private String currentCashDrawerId;
    private Double overtimeRatePerHour;
    private String currentShiftId;
    private String userTypeId;
    private String parentUserId;
    private String properties;

    public User() {
    }

    public User(String firstName, String lastName, String userName, String phoneNo, String email, String password, String longPassword, Double costPerHour, Boolean clockedIn, Boolean canLoginInCloud, Boolean posLiveEnable, Date lastClockInTime, Date lastClockOutTime, Boolean staffBank, Boolean autoStartStaffBank, Boolean staffBankStarted, Boolean blindAccountableAmount, Boolean availableForDelivery, Boolean active, String imageId, Boolean root, String outletId, String currentCashDrawerId, Double overtimeRatePerHour, String currentShiftId, String userTypeId, String parentUserId, String properties) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.password = password;
        this.longPassword = longPassword;
        this.costPerHour = costPerHour;
        this.clockedIn = clockedIn;
        this.canLoginInCloud = canLoginInCloud;
        this.posLiveEnable = posLiveEnable;
        this.lastClockInTime = lastClockInTime;
        this.lastClockOutTime = lastClockOutTime;
        this.staffBank = staffBank;
        this.autoStartStaffBank = autoStartStaffBank;
        this.staffBankStarted = staffBankStarted;
        this.blindAccountableAmount = blindAccountableAmount;
        this.availableForDelivery = availableForDelivery;
        this.active = active;
        this.imageId = imageId;
        this.root = root;
        this.outletId = outletId;
        this.currentCashDrawerId = currentCashDrawerId;
        this.overtimeRatePerHour = overtimeRatePerHour;
        this.currentShiftId = currentShiftId;
        this.userTypeId = userTypeId;
        this.parentUserId = parentUserId;
        this.properties = properties;
    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
//        return Objects.requireNonNullElseGet(instance, User::new);
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLongPassword() {
        return longPassword;
    }

    public void setLongPassword(String longPassword) {
        this.longPassword = longPassword;
    }

    public Double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(Double costPerHour) {
        this.costPerHour = costPerHour;
    }

    public Boolean getClockedIn() {
        return clockedIn;
    }

    public void setClockedIn(Boolean clockedIn) {
        this.clockedIn = clockedIn;
    }

    public Boolean getCanLoginInCloud() {
        return canLoginInCloud;
    }

    public void setCanLoginInCloud(Boolean canLoginInCloud) {
        this.canLoginInCloud = canLoginInCloud;
    }

    public Boolean getPosLiveEnable() {
        return posLiveEnable;
    }

    public void setPosLiveEnable(Boolean posLiveEnable) {
        this.posLiveEnable = posLiveEnable;
    }

    public Date getLastClockInTime() {
        return lastClockInTime;
    }

    public void setLastClockInTime(Date lastClockInTime) {
        this.lastClockInTime = lastClockInTime;
    }

    public Date getLastClockOutTime() {
        return lastClockOutTime;
    }

    public void setLastClockOutTime(Date lastClockOutTime) {
        this.lastClockOutTime = lastClockOutTime;
    }

    public Boolean getStaffBank() {
        return staffBank;
    }

    public void setStaffBank(Boolean staffBank) {
        this.staffBank = staffBank;
    }

    public Boolean getAutoStartStaffBank() {
        return autoStartStaffBank;
    }

    public void setAutoStartStaffBank(Boolean autoStartStaffBank) {
        this.autoStartStaffBank = autoStartStaffBank;
    }

    public Boolean getStaffBankStarted() {
        return staffBankStarted;
    }

    public void setStaffBankStarted(Boolean staffBankStarted) {
        this.staffBankStarted = staffBankStarted;
    }

    public Boolean getBlindAccountableAmount() {
        return blindAccountableAmount;
    }

    public void setBlindAccountableAmount(Boolean blindAccountableAmount) {
        this.blindAccountableAmount = blindAccountableAmount;
    }

    public Boolean getAvailableForDelivery() {
        return availableForDelivery;
    }

    public void setAvailableForDelivery(Boolean availableForDelivery) {
        this.availableForDelivery = availableForDelivery;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public Boolean getRoot() {
        return root;
    }

    public void setRoot(Boolean root) {
        this.root = root;
    }

    public String getOutletId() {
        return outletId;
    }

    public void setOutletId(String outletId) {
        this.outletId = outletId;
    }

    public String getCurrentCashDrawerId() {
        return currentCashDrawerId;
    }

    public void setCurrentCashDrawerId(String currentCashDrawerId) {
        this.currentCashDrawerId = currentCashDrawerId;
    }

    public Double getOvertimeRatePerHour() {
        return overtimeRatePerHour;
    }

    public void setOvertimeRatePerHour(Double overtimeRatePerHour) {
        this.overtimeRatePerHour = overtimeRatePerHour;
    }

    public String getCurrentShiftId() {
        return currentShiftId;
    }

    public void setCurrentShiftId(String currentShiftId) {
        this.currentShiftId = currentShiftId;
    }

    public String getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(String userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(String parentUserId) {
        this.parentUserId = parentUserId;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public void save() {
        save(this);
    }

    public User find(Integer key) {
        return (User) find(this, key);
    }

    public List<?> getAll() {
        return getAll(this);
    }

//    public User checkUser(String userName, String password) {
//        EntityManager entityManager = DatabaseUtil.getInstance().getEntityManager();
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//
//        CriteriaQuery<User> criteria = builder.createQuery( User.class );
//        Root<User> root = criteria.from( User.class );
//        criteria.select(root);
////        criteria.where( builder.equal( root.get("name"), u ) );
////        criteria.where(builder.or(builder.equal(root.get("userName"), u), builder.equal(root.get("phoneNo"), u), builder.equal(root.get("email"), u)))
////        criteria.where(builder.or(root.get("name"), u))
////                .where(builder.equal( root.get("password"), password ));
//
//        criteria.where(
//                builder.and(
//                        builder.or(
//                                builder.equal(root.get("userName"), userName),
//                                builder.equal(root.get("phoneNo"), userName),
//                                builder.equal(root.get("email"), userName)),
//                        builder.equal(root.get("password"), password)
//                )
//        );
//        User user = entityManager.createQuery( criteria ).getSingleResult();
//        return user;
//    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", longPassword='" + longPassword + '\'' +
                ", costPerHour=" + costPerHour +
                ", clockedIn=" + clockedIn +
                ", canLoginInCloud=" + canLoginInCloud +
                ", posLiveEnable=" + posLiveEnable +
                ", lastClockInTime=" + lastClockInTime +
                ", lastClockOutTime=" + lastClockOutTime +
                ", staffBank=" + staffBank +
                ", autoStartStaffBank=" + autoStartStaffBank +
                ", staffBankStarted=" + staffBankStarted +
                ", blindAccountableAmount=" + blindAccountableAmount +
                ", availableForDelivery=" + availableForDelivery +
                ", active=" + active +
                ", imageId='" + imageId + '\'' +
                ", root=" + root +
                ", outletId='" + outletId + '\'' +
                ", currentCashDrawerId='" + currentCashDrawerId + '\'' +
                ", overtimeRatePerHour=" + overtimeRatePerHour +
                ", currentShiftId='" + currentShiftId + '\'' +
                ", userTypeId='" + userTypeId + '\'' +
                ", parentUserId='" + parentUserId + '\'' +
                ", properties='" + properties + '\'' +
                '}';
    }
}
