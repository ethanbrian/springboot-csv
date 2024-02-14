package org.example.model;

public class Record {
    private String id;
    private String name;
    private String date;
    private double availableBalance;
    private double charge;
    private double bookBalance;

    // Constructors
    public Record() {
    }

    public Record(String id, String name, String date, double availableBalance, double charge, double bookBalance) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.availableBalance = availableBalance;
        this.charge = charge;
        this.bookBalance = bookBalance;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public double getBookBalance() {
        return bookBalance;
    }

    public void setBookBalance(double bookBalance) {
        this.bookBalance = bookBalance;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", availableBalance=" + availableBalance +
                ", charge=" + charge +
                ", bookBalance=" + bookBalance +
                '}';
    }
}
