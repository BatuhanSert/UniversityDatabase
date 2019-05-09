package Universities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CourseData {
    private final StringProperty CID;
    private final StringProperty Credits;
    private final StringProperty Cname;
    private final StringProperty Mark;
    private final StringProperty Grade;

    public CourseData(String cid, String credits, String cname, String mark, String grade){
        this.CID = new SimpleStringProperty(cid);
        this.Credits = new SimpleStringProperty(credits);
        this.Cname = new SimpleStringProperty(cname);
        this.Mark = new SimpleStringProperty(mark);
        this.Grade = new SimpleStringProperty(grade);
    }

    public String getCID() {
        return CID.get();
    }

    public StringProperty CIDProperty() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID.set(CID);
    }

    public String getCredits() {
        return Credits.get();
    }

    public StringProperty creditsProperty() {
        return Credits;
    }

    public void setCredits(String credits) {
        this.Credits.set(credits);
    }

    public String getCname() {
        return Cname.get();
    }

    public StringProperty cnameProperty() {
        return Cname;
    }

    public void setCname(String cname) {
        this.Cname.set(cname);
    }

    public String getMark() {
        return Mark.get();
    }

    public StringProperty markProperty() {
        return Mark;
    }

    public void setMark(String mark) {
        this.Mark.set(mark);
    }

    public String getGrade() {
        return Grade.get();
    }

    public StringProperty gradeProperty() {
        return Grade;
    }

    public void setGrade(String grade) {
        this.Grade.set(grade);
    }
}
