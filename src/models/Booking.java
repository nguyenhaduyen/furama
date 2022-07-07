package models;

import java.time.LocalDate;

public class Booking implements Comparable<Booking>{
    private String bookingCode;
    private LocalDate start;
    private LocalDate end;
    private String customerCode;
    private String serviceName;
    private String kindOfService;

    public Booking() {
    }

    public Booking(String bookingCode, LocalDate start, LocalDate end, String customerCode, String serviceName, String kindOfService) {
        this.bookingCode = bookingCode;
        this.start = start;
        this.end = end;
        this.customerCode = customerCode;
        this.serviceName = serviceName;
        this.kindOfService = kindOfService;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getKindOfService() {
        return kindOfService;
    }

    public void setKindOfService(String kindOfService) {
        this.kindOfService = kindOfService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingCode='" + bookingCode + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", customerCode='" + customerCode + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", kindOfService='" + kindOfService + '\'' +
                '}';
    }
    public String getInfoToCSVBooking () {
        return bookingCode + "," + start + "," + end + "," + customerCode + "," + serviceName + "," + kindOfService;
    }


    @Override
    public int compareTo(Booking o) {
        if (o.getStart().isBefore(this.start)){
            return 1;
        }else if (o.getStart().isAfter(this.start)){
            return -1;
        }else {
            if (o.getEnd().isBefore(this.end)){
                return 1;
            }else if (o.getEnd().isAfter(this.end)){
                return -1;
            }else return 0;
        }
    }
}
