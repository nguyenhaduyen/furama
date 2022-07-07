package models.facility;

public abstract class  Facility {
    private String serviceName;
    private double usableArea;
    private double costRent;
    private int maximumNumberOfPeople;
    private String rentalType;
    private String serviceCode;
    public Facility() {
    }
    public Facility(String service, double usableArea, double costRent, int maximumNumberOfPeople, String rentalType,String serviceCode) {
        this.serviceName = service;
        this.usableArea = usableArea;
        this.costRent = costRent;
        this.maximumNumberOfPeople = maximumNumberOfPeople;
        this.rentalType = rentalType;
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getCostRent() {
        return costRent;
    }

    public void setCostRent(double costRent) {
        this.costRent = costRent;
    }

    public int getMaximumNumberOfPeople() {
        return maximumNumberOfPeople;
    }

    public void setMaximumNumberOfPeople(int maximumNumberOfPeople) {
        this.maximumNumberOfPeople = maximumNumberOfPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Override
    public String toString() {
        return
                "serviceName='" + serviceName + '\'' +
                ", usableArea=" + usableArea +
                ", costRent=" + costRent +
                ", maximumNumberOfPeople=" + maximumNumberOfPeople +
                ", rentalType='" + rentalType + '\'' +
                ", serviceCode='" + serviceCode;

    }
}
