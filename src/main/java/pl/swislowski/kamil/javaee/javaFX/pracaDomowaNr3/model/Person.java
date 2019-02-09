package pl.swislowski.kamil.javaee.javaFX.pracaDomowaNr3.model;

public class Person {

    private String firstName;
    private String lastName;
    private String roomNumber;
    private String workStartHour;
    private String workEndHour;

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getWorkStartHour() {
        return workStartHour;
    }

    public String getWorkEndHour() {
        return workEndHour;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setWorkStartHour(String workStartHour) {
        this.workStartHour = workStartHour;
    }

    public void setWorkEndHour(String workEndHour) {
        this.workEndHour = workEndHour;
    }

}
