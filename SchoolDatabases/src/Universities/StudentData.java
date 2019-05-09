package Universities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentData {

    private final StringProperty SID;
    private final StringProperty YearEnrolled;
    private final StringProperty DateOfBirth;
    private final StringProperty Name;
    private final StringProperty Email;
    private final StringProperty Password;

    public StudentData( String yearenrolled, String sid, String dateofbirth, String name, String email, String password) {
        this.SID = new SimpleStringProperty(sid);
        this.YearEnrolled = new SimpleStringProperty(yearenrolled);
        this.DateOfBirth = new SimpleStringProperty(dateofbirth);
        this.Name = new SimpleStringProperty(name);
        this.Email = new SimpleStringProperty(email);
        this.Password = new SimpleStringProperty(password);
    }

    public String getSID() {
        return SID.get();
    }

    public StringProperty SIDProperty() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID.set(SID);
    }

    public String getYearEnrolled() {
        return YearEnrolled.get();
    }

    public StringProperty yearEnrolledProperty() {
        return YearEnrolled;
    }

    public void setYearEnrolled(String yearEnrolled) {
        this.YearEnrolled.set(yearEnrolled);
    }

    public String getDateOfBirth() {
        return DateOfBirth.get();
    }

    public StringProperty dateOfBirthProperty() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.DateOfBirth.set(dateOfBirth);
    }

    public String getName() {
        return Name.get();
    }

    public StringProperty nameProperty() {
        return Name;
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public String getEmail() {
        return Email.get();
    }

    public StringProperty emailProperty() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email.set(email);
    }

    public String getPassword() {
        return Password.get();
    }

    public StringProperty passwordProperty() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password.set(password);
    }

}
