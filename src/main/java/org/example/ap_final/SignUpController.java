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

import static org.example.ap_final.Utils.isEmailValid;
import static org.example.ap_final.Utils.isPasswordValid;

public class SignUpController {
    @FXML
    Button LoginButton ;
    @FXML
    Button SignUpButton ;
    @FXML
    TextField emailTextField ;
    @FXML
    TextField usernameTextField ;
    @FXML
    TextField passwordTextField ;
    @FXML
    TextField repeatPasswordTextField ;
    @FXML
    Label messageLabel ;


    @FXML
    protected void onLoginButtonClick(ActionEvent e ) throws IOException {
        Parent backParent = FXMLLoader.load(getClass().getResource("Login-Panel.fxml"));
        Scene backScene = new Scene(backParent);
        Stage window = (Stage) SignUpButton.getScene().getWindow();
        window.setScene(backScene);
        window.show();
    }
    @FXML
    protected void onSignUpButtonClick(ActionEvent e)  {
        String email = emailTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        String repeatPassword = repeatPasswordTextField.getText();

        if (email != null && !email.isEmpty() &&
                username != null && !username.isEmpty() &&
                password != null && !password.isEmpty() &&
                repeatPassword != null && !repeatPassword.isEmpty()) {

            // Validate email format
            if (!isEmailValid(email)) {
                messageLabel.setText("Invalid email format.");
                return;
            }

            // Check if passwords match
            if (!password.equals(repeatPassword)) {
                messageLabel.setText("Passwords do not match.");
                return;
            }

            // Validate password strength
            if (!isPasswordValid(password)) {
                messageLabel.setText("Password does not meet the required criteria.");
                return;
            }

            // Check if username already exists

            if (Database.userExists(username)) {
                messageLabel.setText("Username already exists.");
                return;
            }

            // Add the user to the database
            Database.addUser(username, password);

            messageLabel.setText("User registered successfully.");
        } else {
            messageLabel.setText("All fields are required.");
        }
    }
}