package org.example.ap_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static org.example.ap_final.Utils.isEmailValid;
import static org.example.ap_final.Utils.isPasswordValid;

public class ForgetController {
    @FXML
    Button submit0Button;
    @FXML
    Button submit1Button;
    @FXML
    Button submit2Button;
    @FXML
    TextField emailTextField;
    @FXML
    TextField passwordTextField;
    @FXML
    TextField repeatPasswordTextField;
    @FXML
    Label messageLabel;
    @FXML
    Button LoginButton;
    @FXML
    TextField TokenTextField;


    @FXML
    protected void onLoginButtonClick(ActionEvent e) throws IOException {
        Parent backParent = FXMLLoader.load(getClass().getResource("Login-Panel.fxml"));
        Scene backScene = new Scene(backParent);
        Stage window = (Stage) submit0Button.getScene().getWindow();
        window.setScene(backScene);
        window.show();
    }

    @FXML
    protected void onSubmit0ButtonClick(ActionEvent e) throws IOException {
        String email = emailTextField.getText();


        if (email != null && !email.isEmpty()) {
            // Validate email format
            if (!isEmailValid(email)) {
                messageLabel.setText("Invalid email format.");
                return;
            }
            if (!Database.userExistsByEmail(email)) {
                messageLabel.setText("User Not found");
                return;
            }
            submit0Button.setVisible(false);
            submit0Button.setDisable(true);

            submit1Button.setVisible(true);
            submit1Button.setDisable(false);

            // In this step, the generated token must be sent

            emailTextField.setEditable(false);
            TokenTextField.setEditable(true);
        } else {
            messageLabel.setText("please Enter Email");
        }

    }

    @FXML
    protected void onSubmit1ButtonClick(ActionEvent e) throws IOException {
        // If the tokens are correct, it enters the next step

        submit1Button.setVisible(false);
        submit1Button.setDisable(true);

        submit2Button.setVisible(true);
        submit2Button.setDisable(false);

        TokenTextField.setVisible(false);
        passwordTextField.setVisible(true);
        repeatPasswordTextField.setVisible(true);
    }

    @FXML
    protected void onSubmit2ButtonClick(ActionEvent e) throws IOException {
        String password = passwordTextField.getText();
        String repeatPassword = repeatPasswordTextField.getText();


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
        String email = emailTextField.getText();
        Database.findUserByEmail(email).password = password;
        messageLabel.setText("Password Has Changed Successfully.");

        submit2Button.setDisable(true);
    }
}

