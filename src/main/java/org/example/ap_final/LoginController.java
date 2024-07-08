package org.example.ap_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    protected void onLoginButtonClick(ActionEvent e ) {
        System.out.println("Username : " + usernameTextField.getText());
        System.out.println("Password : " + passwordTextField.getText());
    }
    @FXML
    protected void onSignUpButtonClick(ActionEvent e) throws IOException {
        Parent backParent = FXMLLoader.load(getClass().getResource("SignUp-Panel.fxml"));
        Scene backScene = new Scene(backParent);
        Stage window = (Stage) SignUpButton.getScene().getWindow();
        window.setScene(backScene);
        window.show();
    }
}