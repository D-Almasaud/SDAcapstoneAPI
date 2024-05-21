package pojos.MembershipTypeServices;

public class MembershipType {

    private int id;
    private String name;
    private String shortName;
    private boolean isEnabled;
    private boolean isIndividualPlan;
    private int defaultRoleId;
    private int subscriptionTypeId;
    private int seatQuota;
    private int appId;
    private String createdAt;
    private String updatedAt;
    private int updatedBy;

    public MembershipType() {
    }

    public MembershipType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public MembershipType(int id, String name, String shortName, boolean isEnabled, boolean isIndividualPlan, int defaultRoleId, int subscriptionTypeId, int seatQuota, int appId, String createdAt, String updatedAt, int updatedBy) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.isEnabled = isEnabled;
        this.isIndividualPlan = isIndividualPlan;
        this.defaultRoleId = defaultRoleId;
        this.subscriptionTypeId = subscriptionTypeId;
        this.seatQuota = seatQuota;
        this.appId = appId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isIndividualPlan() {
        return isIndividualPlan;
    }

    public void setIndividualPlan(boolean individualPlan) {
        isIndividualPlan = individualPlan;
    }

    public int getDefaultRoleId() {
        return defaultRoleId;
    }

    public void setDefaultRoleId(int defaultRoleId) {
        this.defaultRoleId = defaultRoleId;
    }

    public int getSubscriptionTypeId() {
        return subscriptionTypeId;
    }

    public void setSubscriptionTypeId(int subscriptionTypeId) {
        this.subscriptionTypeId = subscriptionTypeId;
    }

    public int getSeatQuota() {
        return seatQuota;
    }

    public void setSeatQuota(int seatQuota) {
        this.seatQuota = seatQuota;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }
}

