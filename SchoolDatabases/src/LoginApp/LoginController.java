package LoginApp;

import Students.StudentsController;
import Teachers.TeacherController;
import Universities.UniversitiesController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    LoginModel loginmodel = new LoginModel();

    @FXML
    private Label dbstatus;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<option> combobox;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginstatus;



    public void initialize(URL url, ResourceBundle rb){
        if (this.loginmodel.isDatabaseConnected()){
            this.dbstatus.setText("Connected");
        }else{
            this.dbstatus.setText("Not Connected");
        }

        this.combobox.setItems(FXCollections.observableArrayList(option.values()));
    }

    @FXML
    public void Login(ActionEvent event){
        try{

            if (this.loginmodel.isLogin(this.username.getText(), this.password.getText(), ((option)this.combobox.getValue()).toString()))
            {
                Stage stage = (Stage)this.loginButton.getScene().getWindow();
                stage.close();

                switch (((option)this.combobox.getValue()).toString()){

                    case "Student":
                        StudentLogin();
                        break;
                    case "Teacher":
                        TeacherLogin();
                        break;
                    case "University"  :
                        UniversityLogin();
                }
            }else {
                this.loginstatus.setText("Wrong...");

            }

        }catch (Exception localException){

        }

    }

    public void StudentLogin(){
        try{
            Stage StudentStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/Students/student.fxml").openStream());

            StudentsController studentsController = (StudentsController)loader.getController();

            Scene scene = new Scene(root);
            StudentStage.setScene(scene);
            StudentStage.setTitle("Students");
            StudentStage.setResizable(false);
            StudentStage.show();


        }
        catch (IOException ex){
            ex.printStackTrace();

        }

    }
    public void TeacherLogin(){
        try{
            Stage TeacherStage = new Stage();
            FXMLLoader TeacherLoader = new FXMLLoader();
            Pane TeacherRoot = (Pane)TeacherLoader.load(getClass().getResource("/Teachers/teacher.fxml").openStream());

            TeacherController teacherController = (TeacherController)TeacherLoader.getController();

            Scene scene = new Scene(TeacherRoot);
            TeacherStage.setScene(scene);
            TeacherStage.setTitle("Teachers");
            TeacherStage.setResizable(false);
            TeacherStage.show();

        }catch (IOException ex){
            ex.printStackTrace();
        }


    }
    public void UniversityLogin(){
        try{
            Stage UniversityStage = new Stage();
            FXMLLoader UniversityLoader = new FXMLLoader();
            Pane UniversityRoot = (Pane)UniversityLoader.load(getClass().getResource("/Universities/university.fxml").openStream());

            UniversitiesController universitiesController = (UniversitiesController)UniversityLoader.getController();

            Scene scene = new Scene(UniversityRoot);
            UniversityStage.setScene(scene);
            UniversityStage.setTitle("University");
            UniversityStage.setResizable(false);
            UniversityStage.show();

        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

}
