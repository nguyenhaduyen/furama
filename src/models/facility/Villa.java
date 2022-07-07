package models.facility;

public class Villa extends Facility {
    private String roomStandard;
    private double poolArea;
    private int numberOfFloor;


    public Villa(String roomStandard, double poolArea, int numberOfFloor) {
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }

    public Villa(String serviceName, double usableArea, double costRent, int maximumNumberOfPeople, String rentalType,String serviceCode, String roomStandard, double poolArea, int numberOfFloor) {
        super(serviceName, usableArea, costRent, maximumNumberOfPeople, rentalType,serviceCode);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString() +
                "roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", numberOfFloor=" + numberOfFloor +
                '}';
    }
    public String getInfoToCSVVilla() {
        return getServiceName() + "," + getUsableArea() + "," + getCostRent() + "," + getMaximumNumberOfPeople() + ","
                + getRentalType() + "," + getServiceCode() + "," + getRoomStandard() + "," + getPoolArea() + "," + getNumberOfFloor();
    }
}
