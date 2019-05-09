package Universities;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import dbUtil.dbConnection;
import javafx.scene.control.cell.PropertyValueFactory;
import org.sqlite.SQLiteConfig;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UniversitiesController implements Initializable {

    @FXML
    private TextField sid;
    @FXML
    private TextField studentname;
    @FXML
    private TextField studentemail;
    @FXML
    private TextField studentpassword;
    @FXML
    private DatePicker dob;
    @FXML
    private DatePicker ye;

    @FXML
    private TableView<StudentData> studenttable;

    @FXML
    private TableColumn<StudentData , String> sidcolumn;
    @FXML
    private TableColumn<StudentData , String> studentnamecolumn;
    @FXML
    private TableColumn<StudentData , String> studentemailcolumn;
    @FXML
    private TableColumn<StudentData , String> studentpasswordcolumn;
    @FXML
    private TableColumn<StudentData , String> dobcolumn;
    @FXML
    private TableColumn<StudentData , String> yecolumn;

    private dbConnection dc;
    private ObservableList<StudentData> studentData;
    private String Studentsql = "SELECT * FROM Students";

    public void initialize(URL url, ResourceBundle rb){
        this.dc = new dbConnection();
    }

    @FXML
    private void loadStudentData(ActionEvent event) {
        try{
            Connection conn = dbConnection.getConnetciton();
            this.studentData = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(Studentsql);

            while (rs.next()){
                this.studentData.add(new StudentData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));

            }

        }catch (SQLException ex){
            System.err.println("Error" + ex);
        }

        this.sidcolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("SID"));
        this.studentnamecolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("Name"));
        this.studentemailcolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("Email"));
        this.studentpasswordcolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("Password"));
        this.dobcolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("DateOfBirth"));
        this.yecolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("YearEnrolled"));

        this.studenttable.setItems(null);
        this.studenttable.setItems(studentData);
    }

    @FXML
    private void addStudent(ActionEvent event){
        String sqlInsert = "INSERT INTO Students(YearEnrolled, SID, DateOfBirth, Name, Email, Password) VALUES (?,?,?,?,?,?)";

        try{
            Connection conn = dbConnection.getConnetciton();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

            stmt.setString(1,this.ye.getEditor().getText());
            stmt.setString(2,this.sid.getText());
            stmt.setString(3,this.dob.getEditor().getText());
            stmt.setString(4,this.studentname.getText());
            stmt.setString(5,this.studentemail.getText());
            stmt.setString(6,this.studentpassword.getText());
            stmt.execute();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clearFields(ActionEvent event){
        this.sid.setText("");
        this.ye.setValue(null);
        this.dob.setValue(null);
        this.studentname.setText("");
        this.studentemail.setText("");
        this.studentpassword.setText("");

    }
    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
    @FXML
    private TextField budgetname;
    @FXML
    private TextField budgetarge;
    @FXML
    private TableView budgettable;
    @FXML
    private TableColumn budgetnamecolumn;
    @FXML
    private TableColumn budgetargecolumn;

    private ObservableList<BudgetData> budgetData;
    private String Budgetsql = "SELECT * FROM Budget";

    @FXML
    private void loadBudgetData(ActionEvent event) {
        try{
            Connection conn = dbConnection.getConnetciton();
            this.budgetData = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(Budgetsql);

            while (rs.next()){
                this.budgetData.add(new BudgetData(rs.getString(1),rs.getString(2)));

            }

        }catch (SQLException ex){
            System.err.println("Error" + ex);
        }

        this.budgetnamecolumn.setCellValueFactory(new PropertyValueFactory<BudgetData, String>("Dname"));
        this.budgetargecolumn.setCellValueFactory(new PropertyValueFactory<BudgetData, String>("ArGe"));


        this.budgettable.setItems(null);
        this.budgettable.setItems(budgetData);
    }
    @FXML
    private void addBudget(ActionEvent event){
        String sqlInsert = "INSERT INTO Budget(Dname, ArGe) VALUES (?,?)";

        try{
            Connection conn = dbConnection.getConnetciton();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

            stmt.setString(1,this.budgetname.getText());
            stmt.setString(2,this.budgetarge.getText());

            stmt.execute();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clearBudgetFields(ActionEvent event){
        this.budgetname.setText("");
        this.budgetarge.setText("");


    }

    //************************************************************************************

    @FXML
    private TextField cid;
    @FXML
    private TextField coursecredits;
    @FXML
    private TextField cname;
    @FXML
    private TextField coursemark;
    @FXML
    private TextField coursegrade;
    @FXML
    private TableView coursetable;
    @FXML
    private TableColumn cidcolumn;
    @FXML
    private TableColumn coursecreditscolumn;
    @FXML
    private TableColumn cnamecolumn;
    @FXML
    private TableColumn coursemarkcolumn;
    @FXML
    private TableColumn coursegradecolumn;

    private ObservableList<CourseData> courseData;
    private String Coursesql = "SELECT * FROM Course";

    @FXML
    private void loadCourseData(ActionEvent event) {
        try{
            Connection conn = dbConnection.getConnetciton();
            this.courseData = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(Coursesql);

            while (rs.next()){
                this.courseData.add(new CourseData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));

            }

        }catch (SQLException ex){
            System.err.println("Error" + ex);
        }

        this.cidcolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("CID"));
        this.coursecreditscolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("Credits"));
        this.cnamecolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("Cname"));
        this.coursemarkcolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("Mark"));
        this.coursegradecolumn.setCellValueFactory(new PropertyValueFactory<CourseData, String>("Grade"));


        this.coursetable.setItems(null);
        this.coursetable.setItems(courseData);
    }
    @FXML
    private void addCourse(ActionEvent event){
        String sqlInsert = "INSERT INTO Course(CID, Credits, Cname, Mark, Grade) VALUES (?,?,?,?,?)";

        try{
            Connection conn = dbConnection.getConnetciton();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

            stmt.setString(1,this.cid.getText());
            stmt.setString(2,this.coursecredits.getText());
            stmt.setString(3,this.cname.getText());
            stmt.setString(4,this.coursemark.getText());
            stmt.setString(5,this.coursegrade.getText());

            stmt.execute();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clearCourseFields(ActionEvent event){
        this.cid.setText("");
        this.coursecredits.setText("");
        this.cname.setText("");
        this.coursemark.setText("");
        this.coursegrade.setText("");

    }

    /********************************************************************************************************/

    @FXML
    private TextField departmentname;
    @FXML
    private TextField departmentlabs;
    @FXML
    private TextField departmentarge;
    @FXML
    private TextField departmentroom;
    @FXML
    private TextField courseid;
    @FXML
    private TableView departmenttable;
    @FXML
    private TableColumn departmentnamecolumn;
    @FXML
    private TableColumn departmentlabscolumn;
    @FXML
    private TableColumn departmentargecolumn;
    @FXML
    private TableColumn departmentroomcolumn;
    @FXML
    private TableColumn courseidcolumn;

    private ObservableList<DepartmentData> departmentData;
    private String Departmentsql = "SELECT * FROM Departments";

    @FXML
    private void loadDepartmentData(ActionEvent event) {
        try{
            Connection conn = dbConnection.getConnetciton();
            this.departmentData = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(Departmentsql);

            while (rs.next()){
                this.departmentData.add(new DepartmentData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));

            }

        }catch (SQLException ex){
            System.err.println("Error" + ex);
        }

        this.departmentnamecolumn.setCellValueFactory(new PropertyValueFactory<DepartmentData, String>("Depname"));
        this.departmentlabscolumn.setCellValueFactory(new PropertyValueFactory<DepartmentData, String>("Labs"));
        this.departmentargecolumn.setCellValueFactory(new PropertyValueFactory<DepartmentData, String>("DepArGe"));
        this.departmentroomcolumn.setCellValueFactory(new PropertyValueFactory<DepartmentData, String>("Room"));
        this.courseidcolumn.setCellValueFactory(new PropertyValueFactory<DepartmentData, String>("Course_ID"));


        this.departmenttable.setItems(null);
        this.departmenttable.setItems(departmentData);
    }
    @FXML
    private void addDepartment(ActionEvent event){
        String sqlInsert = "INSERT INTO Departments(Depname, Labs, DepArGe, Room, Course_ID) VALUES (?,?,?,?,?)";

        try{
            Connection conn = dbConnection.getConnetciton();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

            stmt.setString(1,this.departmentname.getText());
            stmt.setString(2,this.departmentlabs.getText());
            stmt.setString(3,this.departmentarge.getText());
            stmt.setString(4,this.departmentroom.getText());
            stmt.setString(5,this.courseid.getText());

            stmt.execute();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clearDepartmentFields(ActionEvent event){
        this.departmentname.setText("");
        this.departmentlabs.setText("");
        this.departmentarge.setText("");
        this.departmentroom.setText("");
        this.courseid.setText("");

    }

    /********************************************************************************************************/

    @FXML
    private TextField takecid;
    @FXML
    private TextField takesid;
    @FXML
    private TextField takesemester;
    @FXML
    private TextField takeyear;
    @FXML
    private TableView taketable;
    @FXML
    private TableColumn takecidcolumn;
    @FXML
    private TableColumn takesidcolumn;
    @FXML
    private TableColumn takesemestercolumn;
    @FXML
    private TableColumn takeyearcolumn;


    private ObservableList<TakeData> takeData;
    private String Takesql = "SELECT * FROM Take";

    @FXML
    private void loadTakeData(ActionEvent event) {
        try{
            Connection conn = dbConnection.getConnetciton();
            this.takeData = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(Takesql);

            while (rs.next()){
                this.takeData.add(new TakeData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));

            }

        }catch (SQLException ex){
            System.err.println("Error" + ex);
        }

        this.takeyearcolumn.setCellValueFactory(new PropertyValueFactory<TakeData, String>("Year"));
        this.takesemestercolumn.setCellValueFactory(new PropertyValueFactory<TakeData, String>("Semester"));
        this.takecidcolumn.setCellValueFactory(new PropertyValueFactory<TakeData, String>("cid"));
        this.takesidcolumn.setCellValueFactory(new PropertyValueFactory<TakeData, String>("sid"));



        this.taketable.setItems(null);
        this.taketable.setItems(takeData);
    }
    @FXML
    private void addTake(ActionEvent event){
        String sqlInsert = "INSERT INTO Take(Year, Semester, cid, sid) VALUES (?,?,?,?)";

        try{
            Connection conn = dbConnection.getConnetciton();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

            stmt.setString(1,this.takeyear.getText());
            stmt.setString(2,this.takesemester.getText());
            stmt.setString(3,this.takecid.getText());
            stmt.setString(4,this.takesid.getText());

            stmt.execute();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clearTakeFields(ActionEvent event){
        this.takeyear.setText("");
        this.takesemester.setText("");
        this.takecid.setText("");
        this.takesid.setText("");

    }

    /********************************************************************************************************/

    @FXML
    private TextField ssn;
    @FXML
    private TextField teachername;
    @FXML
    private TextField teacherage;
    @FXML
    private TextField teacherrank;
    @FXML
    private TableView teachertable;
    @FXML
    private TableColumn ssncolumn;
    @FXML
    private TableColumn teachernamecolumn;
    @FXML
    private TableColumn teacheragecolumn;
    @FXML
    private TableColumn teacherrankcolumn;


    private ObservableList<TeacherData> teacherData;
    private String Teachersql = "SELECT * FROM Teacher";

    @FXML
    private void loadTeacherData(ActionEvent event) {
        try{
            Connection conn = dbConnection.getConnetciton();
            this.teacherData = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(Teachersql);

            while (rs.next()){
                this.teacherData.add(new TeacherData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));

            }

        }catch (SQLException ex){
            System.err.println("Error" + ex);
        }

        this.ssncolumn.setCellValueFactory(new PropertyValueFactory<TeacherData, String>("SSN"));
        this.teachernamecolumn.setCellValueFactory(new PropertyValueFactory<TeacherData, String>("Name"));
        this.teacheragecolumn.setCellValueFactory(new PropertyValueFactory<TeacherData, String>("Age"));
        this.teacherrankcolumn.setCellValueFactory(new PropertyValueFactory<TeacherData, String>("Rank"));



        this.teachertable.setItems(null);
        this.teachertable.setItems(teacherData);
    }
    @FXML
    private void addTeacher(ActionEvent event){
        String sqlInsert = "INSERT INTO Teacher(SSN, Name, Age, Rank) VALUES (?,?,?,?)";

        try{
            Connection conn = dbConnection.getConnetciton();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

            stmt.setString(1,this.ssn.getText());
            stmt.setString(2,this.teachername.getText());
            stmt.setString(3,this.teacherage.getText());
            stmt.setString(4,this.teacherrank.getText());

            stmt.execute();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clearTeacherFields(ActionEvent event){
        this.ssn.setText("");
        this.teachername.setText("");
        this.teacherage.setText("");
        this.teacherrank.setText("");

    }

    /********************************************************************************************************/

    @FXML
    private TextField uid;
    @FXML
    private TextField uniname;
    @FXML
    private TextField unicapacity;
    @FXML
    private TableView unitable;
    @FXML
    private TableColumn uidcolumn;
    @FXML
    private TableColumn uninamecolumn;
    @FXML
    private TableColumn unicapacitycolumn;


    private ObservableList<UniversityData> uniData;
    private String unisql = "SELECT * FROM University";

    @FXML
    private void loadUniData(ActionEvent event) {
        try{
            Connection conn = dbConnection.getConnetciton();
            this.uniData = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(unisql);

            while (rs.next()){
                this.uniData.add(new UniversityData(rs.getString(1),rs.getString(2),rs.getString(3)));

            }

        }catch (SQLException ex){
            System.err.println("Error" + ex);
        }

        this.uidcolumn.setCellValueFactory(new PropertyValueFactory<UniversityData, String>("UID"));
        this.uninamecolumn.setCellValueFactory(new PropertyValueFactory<UniversityData, String>("Name"));
        this.unicapacitycolumn.setCellValueFactory(new PropertyValueFactory<UniversityData, String>("Capacity"));



        this.unitable.setItems(null);
        this.unitable.setItems(uniData);
    }
    @FXML
    private void adduni(ActionEvent event){
        String sqlInsert = "INSERT INTO University(UID, Name, Capacity) VALUES (?,?,?)";

        try{
            Connection conn = dbConnection.getConnetciton();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

            stmt.setString(1,this.uid.getText());
            stmt.setString(2,this.uniname.getText());
            stmt.setString(3,this.unicapacity.getText());

            stmt.execute();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clearuniFields(ActionEvent event){
        this.uid.setText("");
        this.uniname.setText("");
        this.unicapacity.setText("");
    }
    /********************************************************************************************************/

    @FXML
    private TextField worksforssn;
    @FXML
    private TextField worksforuid;
    @FXML
    private TableView wftable;
    @FXML
    private TableColumn wfssncolumn;
    @FXML
    private TableColumn wfuidcolumn;

    private ObservableList<WorksForData> wfData;
    private String wfsql = "SELECT * FROM WorksFor";

    @FXML
    private void loadwfData(ActionEvent event) {
        try{
            Connection conn = dbConnection.getConnetciton();
            this.wfData = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(wfsql);

            while (rs.next()){
                this.wfData.add(new WorksForData(rs.getString(1),rs.getString(2)));

            }

        }catch (SQLException ex){
            System.err.println("Error" + ex);
        }

        this.wfssncolumn.setCellValueFactory(new PropertyValueFactory<WorksForData, String>("TeacherSSN"));
        this.wfuidcolumn.setCellValueFactory(new PropertyValueFactory<WorksForData, String>("UniversityID"));



        this.wftable.setItems(null);
        this.wftable.setItems(wfData);
    }
    @FXML
    private void addwf(ActionEvent event){
        String sqlInsert = "INSERT INTO Works_For(TeacherSSN, UniversityID) VALUES (?,?)";

        try{
            Connection conn = dbConnection.getConnetciton();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

            stmt.setString(1,this.worksforssn.getText());
            stmt.setString(2,this.worksforuid.getText());

            stmt.execute();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clearwfFields(ActionEvent event){
        this.worksforssn.setText("");
        this.worksforuid.setText("");
    }


}
