package models;

public class Contract {
    private String numberOfContract;
    private String bookingCode;
    private Double deposit;
    private Double totalPayment;
    private String customerCode;

    public Contract() {
    }

    public Contract(String numberOfContract, String bookingCode, Double deposit, Double totalPayment, String customerCode) {
        this.numberOfContract = numberOfContract;
        this.bookingCode = bookingCode;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.customerCode = customerCode;
    }

    public String getNumberOfContract() {
        return numberOfContract;
    }

    public void setNumberOfContract(String numberOfContract) {
        this.numberOfContract = numberOfContract;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "numberOfContract='" + numberOfContract + '\'' +
                ", bookingCode='" + bookingCode + '\'' +
                ", deposit=" + deposit +
                ", totalPayment=" + totalPayment +
                ", customerCode='" + customerCode + '\'' +
                '}';
    }
}
