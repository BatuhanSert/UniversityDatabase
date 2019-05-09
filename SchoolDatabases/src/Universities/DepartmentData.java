package Universities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DepartmentData {
    private final StringProperty Depname;
    private final StringProperty Labs;
    private final StringProperty DepArGe;
    private final StringProperty Room;
    private final StringProperty Course_ID;

    public DepartmentData(String depname, String labs, String deparge, String room, String course_id){
        this.Depname = new SimpleStringProperty(depname);
        this.Labs = new SimpleStringProperty(labs);
        this.DepArGe = new SimpleStringProperty(deparge);
        this.Room = new SimpleStringProperty(room);
        this.Course_ID = new SimpleStringProperty(course_id);
    }

    public String getDepname() {
        return Depname.get();
    }

    public StringProperty depnameProperty() {
        return Depname;
    }

    public void setDepname(String depname) {
        this.Depname.set(depname);
    }

    public String getLabs() {
        return Labs.get();
    }

    public StringProperty labsProperty() {
        return Labs;
    }

    public void setLabs(String labs) {
        this.Labs.set(labs);
    }

    public String getDepArGe() {
        return DepArGe.get();
    }

    public StringProperty depArGeProperty() {
        return DepArGe;
    }

    public void setDepArGe(String depArGe) {
        this.DepArGe.set(depArGe);
    }

    public String getRoom() {
        return Room.get();
    }

    public StringProperty roomProperty() {
        return Room;
    }

    public void setRoom(String room) {
        this.Room.set(room);
    }

    public String getCourse_ID() {
        return Course_ID.get();
    }

    public StringProperty course_IDProperty() {
        return Course_ID;
    }

    public void setCourse_ID(String course_ID) {
        this.Course_ID.set(course_ID);
    }
}
