package Universities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BudgetData {

    private final StringProperty Dname;
    private final StringProperty ArGe;

    public BudgetData(String name, String arge){
        this.Dname = new SimpleStringProperty(name);
        this.ArGe = new SimpleStringProperty(arge);

    }

    public String getDname() {
        return Dname.get();
    }

    public StringProperty dnameProperty() {
        return Dname;
    }

    public void setDname(String dname) {
        this.Dname.set(dname);
    }

    public String getArGe() {
        return ArGe.get();
    }

    public StringProperty arGeProperty() {
        return ArGe;
    }

    public void setArGe(String arGe) {
        this.ArGe.set(arGe);
    }
}
