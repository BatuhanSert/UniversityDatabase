package Universities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UniversityData {

    private final StringProperty UID;
    private final StringProperty Name;
    private final StringProperty Capacity;

    public UniversityData(String uid, String name, String capacity){
        this.UID = new SimpleStringProperty(uid);
        this.Name = new SimpleStringProperty(name);
        this.Capacity = new SimpleStringProperty(capacity);
    }

    public String getUID() {
        return UID.get();
    }

    public StringProperty UIDProperty() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID.set(UID);
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

    public String getCapacity() {
        return Capacity.get();
    }

    public StringProperty capacityProperty() {
        return Capacity;
    }

    public void setCapacity(String capacity) {
        this.Capacity.set(capacity);
    }
}
