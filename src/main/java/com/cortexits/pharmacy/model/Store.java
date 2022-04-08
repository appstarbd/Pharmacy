package com.cortexits.pharmacy.model;

import java.io.Serial;
import java.util.Date;

public class Store extends BaseModel {
    @Serial
    private static final long serialVersionUID = 1L;

    private Date lastLoginTime;
    private String uuid;
    private String friendlyUid;
    private String resellerId;
    private String ownerId;
    private String defaultOutletId;
    private String name;
    private String outletName;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String house;
    private String flatNo;
    private String type;
    private String street;
    private String city;
    private String state;
    private String country;
    private String countryCode;
    private String zipCode;
    private String telephone;
    private String currencyName;
    private String currencySymbol;
    private Double serviceChargePercentage;
    private Double defaultGratuityPercentage;
    private String ticketFooterMessage;
    private Boolean itemPriceIncludesTax;
    private Boolean allowModifierMaxExceed;
    private Boolean useDetailedReconciliation;
    private Boolean enableOnlineOrdering;

    public Store() {
    }

    public Store(Date lastLoginTime, String uuid, String friendlyUid, String resellerId, String ownerId, String defaultOutletId, String name, String outletName, String addressLine1, String addressLine2, String addressLine3, String house, String flatNo, String type, String street, String city, String state, String country, String countryCode, String zipCode, String telephone, String currencyName, String currencySymbol, Double serviceChargePercentage, Double defaultGratuityPercentage, String ticketFooterMessage, Boolean itemPriceIncludesTax, Boolean allowModifierMaxExceed, Boolean useDetailedReconciliation, Boolean enableOnlineOrdering) {
        this.lastLoginTime = lastLoginTime;
        this.uuid = uuid;
        this.friendlyUid = friendlyUid;
        this.resellerId = resellerId;
        this.ownerId = ownerId;
        this.defaultOutletId = defaultOutletId;
        this.name = name;
        this.outletName = outletName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.house = house;
        this.flatNo = flatNo;
        this.type = type;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.countryCode = countryCode;
        this.zipCode = zipCode;
        this.telephone = telephone;
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
        this.serviceChargePercentage = serviceChargePercentage;
        this.defaultGratuityPercentage = defaultGratuityPercentage;
        this.ticketFooterMessage = ticketFooterMessage;
        this.itemPriceIncludesTax = itemPriceIncludesTax;
        this.allowModifierMaxExceed = allowModifierMaxExceed;
        this.useDetailedReconciliation = useDetailedReconciliation;
        this.enableOnlineOrdering = enableOnlineOrdering;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFriendlyUid() {
        return friendlyUid;
    }

    public void setFriendlyUid(String friendlyUid) {
        this.friendlyUid = friendlyUid;
    }

    public String getResellerId() {
        return resellerId;
    }

    public void setResellerId(String resellerId) {
        this.resellerId = resellerId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getDefaultOutletId() {
        return defaultOutletId;
    }

    public void setDefaultOutletId(String defaultOutletId) {
        this.defaultOutletId = defaultOutletId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public Double getServiceChargePercentage() {
        return serviceChargePercentage;
    }

    public void setServiceChargePercentage(Double serviceChargePercentage) {
        this.serviceChargePercentage = serviceChargePercentage;
    }

    public Double getDefaultGratuityPercentage() {
        return defaultGratuityPercentage;
    }

    public void setDefaultGratuityPercentage(Double defaultGratuityPercentage) {
        this.defaultGratuityPercentage = defaultGratuityPercentage;
    }

    public String getTicketFooterMessage() {
        return ticketFooterMessage;
    }

    public void setTicketFooterMessage(String ticketFooterMessage) {
        this.ticketFooterMessage = ticketFooterMessage;
    }

    public Boolean getItemPriceIncludesTax() {
        return itemPriceIncludesTax;
    }

    public void setItemPriceIncludesTax(Boolean itemPriceIncludesTax) {
        this.itemPriceIncludesTax = itemPriceIncludesTax;
    }

    public Boolean getAllowModifierMaxExceed() {
        return allowModifierMaxExceed;
    }

    public void setAllowModifierMaxExceed(Boolean allowModifierMaxExceed) {
        this.allowModifierMaxExceed = allowModifierMaxExceed;
    }

    public Boolean getUseDetailedReconciliation() {
        return useDetailedReconciliation;
    }

    public void setUseDetailedReconciliation(Boolean useDetailedReconciliation) {
        this.useDetailedReconciliation = useDetailedReconciliation;
    }

    public Boolean getEnableOnlineOrdering() {
        return enableOnlineOrdering;
    }

    public void setEnableOnlineOrdering(Boolean enableOnlineOrdering) {
        this.enableOnlineOrdering = enableOnlineOrdering;
    }

}
