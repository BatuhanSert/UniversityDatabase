package Universities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class WorksForData {

    private final StringProperty TeacherSSN;
    private final StringProperty UniversityID;

    public WorksForData(String teacherssn, String universityid){
        this.TeacherSSN = new SimpleStringProperty(teacherssn);
        this.UniversityID = new SimpleStringProperty(universityid);
    }

    public String getTeacherSSN() {
        return TeacherSSN.get();
    }

    public StringProperty teacherSSNProperty() {
        return TeacherSSN;
    }

    public void setTeacherSSN(String teacherSSN) {
        this.TeacherSSN.set(teacherSSN);
    }

    public String getUniversityID() {
        return UniversityID.get();
    }

    public StringProperty universityIDProperty() {
        return UniversityID;
    }

    public void setUniversityID(String universityID) {
        this.UniversityID.set(universityID);
    }
}
