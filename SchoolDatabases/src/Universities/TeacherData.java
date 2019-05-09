package Universities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TeacherData {

    private final StringProperty SSN;
    private final StringProperty Name;
    private final StringProperty Age;
    private final StringProperty Rank;

    public TeacherData(String ssn, String name, String age, String rank){
        this.SSN = new SimpleStringProperty(ssn);
        this.Name = new SimpleStringProperty(name);
        this.Age = new SimpleStringProperty(age);
        this.Rank = new SimpleStringProperty(rank);
    }

    public String getSSN() {
        return SSN.get();
    }

    public StringProperty SSNProperty() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN.set(SSN);
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

    public String getAge() {
        return Age.get();
    }

    public StringProperty ageProperty() {
        return Age;
    }

    public void setAge(String age) {
        this.Age.set(age);
    }

    public String getRank() {
        return Rank.get();
    }

    public StringProperty rankProperty() {
        return Rank;
    }

    public void setRank(String rank) {
        this.Rank.set(rank);
    }
}
