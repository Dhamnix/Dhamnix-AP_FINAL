package org.example.ap_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    Button LoginButton ;
    @FXML
    Button SignUpButton ;
    @FXML
    TextField usernameTextField ;
    @FXML
    TextField passwordTextField ;
    @FXML
    Label messageLabel ;
    @FXML
    Button forgetPasswordButton ;


    @FXML
    protected void onLoginButtonClick(ActionEvent e ) throws IOException{
        String username =  usernameTextField.getText();
        String password =  passwordTextField.getText();
        System.out.println("Username : " + username);
        System.out.println("Password : " + password);
        if (!Database.userExistsByUsername(username)){
            messageLabel.setText("User Doesnt Exist");
            return ;
        }
        if (!Database.findUserByUsername(username).password.equals(password)){
            messageLabel.setText("Wrong Password");
            return ;
        }
        if (Database.userExistsByUsername(username) && Database.findUserByUsername(username).password.equals(password)){
            System.out.println("Email : "+ Database.findUserByUsername(username).email);
            Parent backParent = FXMLLoader.load(getClass().getResource("Dashboard-Panel.fxml"));
            Scene backScene = new Scene(backParent);
            Stage window = (Stage) SignUpButton.getScene().getWindow();
            window.setScene(backScene);
            window.show();
        }
    }
    @FXML
    protected void onSignUpButtonClick(ActionEvent e) throws IOException {
        Parent backParent = FXMLLoader.load(getClass().getResource("SignUp-Panel.fxml"));
        Scene backScene = new Scene(backParent);
        Stage window = (Stage) SignUpButton.getScene().getWindow();
        window.setScene(backScene);
        window.show();
    }



    @FXML
    protected void onforgetPasswordButtonClick(ActionEvent e) throws IOException {
        Parent backParent = FXMLLoader.load(getClass().getResource("Forgot-Panel.fxml"));
        Scene backScene = new Scene(backParent);
        Stage window = (Stage) SignUpButton.getScene().getWindow();
        window.setScene(backScene);
        window.show();
    }
}