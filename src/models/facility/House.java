package models.facility;

public class House extends Facility {
    private String roomStandard;
    private int numberOfFloor;
    public House(String roomStandard, int numberOfFloor) {
        this.roomStandard = roomStandard;
        this.numberOfFloor = numberOfFloor;
    }


    public House(String serviceName, double usableArea, double costRent, int maximumNumberOfPeople, String rentalType,String serviceCode, String roomStandard, int numberOfFloor) {
        super(serviceName, usableArea, costRent, maximumNumberOfPeople, rentalType,serviceCode);
        this.roomStandard = roomStandard;
        this.numberOfFloor = numberOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "House{" + super.toString() +
                "roomStandard='" + roomStandard + '\'' +
                ", numberOfFloor=" + numberOfFloor +
                '}';
    }
    public String getInfoToCSVHouse () {
        return getServiceName() + "," + getUsableArea() + "," + getCostRent() + "," + getMaximumNumberOfPeople() + "," + getRentalType()
                +"," + getServiceCode() + "," + getRoomStandard() + "," + getNumberOfFloor();

    }
}

