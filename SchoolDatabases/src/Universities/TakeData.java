package Universities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TakeData {

    private final StringProperty Year;
    private final StringProperty Semester;
    private final StringProperty cid;
    private final StringProperty sid;

    public TakeData(String year, String semester, String cid, String sid){
        this.Year = new SimpleStringProperty(year);
        this.Semester = new SimpleStringProperty(semester);
        this.cid = new SimpleStringProperty(cid);
        this.sid = new SimpleStringProperty(sid);
    }

    public String getYear() {
        return Year.get();
    }

    public StringProperty yearProperty() {
        return Year;
    }

    public void setYear(String year) {
        this.Year.set(year);
    }

    public String getSemester() {
        return Semester.get();
    }

    public StringProperty semesterProperty() {
        return Semester;
    }

    public void setSemester(String semester) {
        this.Semester.set(semester);
    }

    public String getCid() {
        return cid.get();
    }

    public StringProperty cidProperty() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid.set(cid);
    }

    public String getSid() {
        return sid.get();
    }

    public StringProperty sidProperty() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid.set(sid);
    }
}
