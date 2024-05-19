package pojos.MembershipService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Membership {
    private int id;
    @JsonProperty("app_id")
    private int appId;
    @JsonProperty("app_name")
    private String appName;
    @JsonProperty("app_short_name")
    private String appShortName;
    @JsonProperty("app_logo_url")
    private String appLogoUrl;
    @JsonProperty("user_id")
    private int userId;
    private String username;
    @JsonProperty("subscription_id")
    private String subscriptionId;
    @JsonProperty("membership_type_id")
    private int membershipTypeId;
    @JsonProperty("is_individual_membership")
    private boolean isIndividualMembership;
    @JsonProperty("default_role_id")
    private int defaultRoleId;
    @JsonProperty("default_role_name")
    private String defaultRoleName;
    @JsonProperty("organization_id")
    private long organizationId;
    @JsonProperty("organization_name")
    private String organizationName;
    @JsonProperty("is_owner")
    private boolean isOwner;
    @JsonProperty("is_active")
    private boolean isActive;
    @JsonProperty("is_default")
    private boolean isDefault;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("created_by")
    private int createdBy;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("updated_by")
    private int updatedBy;

    // Getters
    public int getId() {
        return id;
    }

    public int getAppId() {
        return appId;
    }

    public String getAppName() {
        return appName;
    }

    public String getAppShortName() {
        return appShortName;
    }

    public String getAppLogoUrl() {
        return appLogoUrl;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public int getMembershipTypeId() {
        return membershipTypeId;
    }

    public boolean isIndividualMembership() {
        return isIndividualMembership;
    }

    public int getDefaultRoleId() {
        return defaultRoleId;
    }

    public String getDefaultRoleName() {
        return defaultRoleName;
    }

    public long getOrganizationId() {
        return organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setAppShortName(String appShortName) {
        this.appShortName = appShortName;
    }

    public void setAppLogoUrl(String appLogoUrl) {
        this.appLogoUrl = appLogoUrl;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public void setMembershipTypeId(int membershipTypeId) {
        this.membershipTypeId = membershipTypeId;
    }

    public void setIndividualMembership(boolean individualMembership) {
        isIndividualMembership = individualMembership;
    }

    public void setDefaultRoleId(int defaultRoleId) {
        this.defaultRoleId = defaultRoleId;
    }

    public void setDefaultRoleName(String defaultRoleName) {
        this.defaultRoleName = defaultRoleName;
    }

    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }
}
