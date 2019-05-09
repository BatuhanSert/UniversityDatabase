package LoginApp;

public enum option {
    Student, Teacher, University;

    private option(){}

    public String value(){
        return name();
    }

    public static option fromvalue(String s){
        return valueOf(s);
    }
}
