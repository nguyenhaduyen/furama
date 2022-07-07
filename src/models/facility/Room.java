package models.facility;

public class Room extends Facility {
    private String freeService;

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String serviceName, double usableArea, double costRent, int maximumNumberOfPeople, String rentalType, String serviceCode, String freeService) {
        super(serviceName, usableArea, costRent, maximumNumberOfPeople, rentalType,serviceCode);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" + super.toString() +
                "freeService='" + freeService + '\'' +
                '}';
    }
    public String getInfoToCSVRoom () {
        return getServiceName() + "," + getUsableArea() + "," + getCostRent() + "," + getMaximumNumberOfPeople() + "," +
                getRentalType() + "," + getServiceCode() + "," + getFreeService();
    }
}
