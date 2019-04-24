package edu.uan.mercasoft.controllers;

import edu.uan.mercasoft.exceptions.NotFoundUser;
import edu.uan.mercasoft.exceptions.NotMatchingPassword;
import edu.uan.mercasoft.exceptions.NullPassword;
import edu.uan.mercasoft.exceptions.NullUserName;
import edu.uan.mercasoft.useCases.AuthenticateInteractorImpl;
import edu.uan.mercasoft.useCases.IAuthenticateInteractor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class LoginController {
    @FXML
    public TextField txt_username;

    @FXML
    public TextField txt_password;
    IAuthenticateInteractor authenticator;

    public LoginController() {
        authenticator= new AuthenticateInteractorImpl(this);
    }



    @FXML
    private void validateFields(ActionEvent action){
        try {
            removeBlankMessage(txt_username);
            removeBlankMessage(txt_password);
            validateNullableUser(txt_username.getText().trim());
            validateNullablePassword(txt_password.getText().trim());
            authenticator.Authenticate(txt_username.getText().trim(), txt_password.getText().trim());
        }
        catch (NullUserName nullUser){
            blankMessage(txt_username);
        }
        catch (NullPassword nullPassword) {
            blankMessage(txt_password);
        } catch (NotFoundUser notFoundUser) {
            throw new NotImplementedException();
        } catch (NotMatchingPassword notMatchingPassword) {
            throw new NotImplementedException();
        }

    }


    private void validateNullableUser(String userName) throws NullUserName {
        if(userName.equals(null)||userName.isEmpty()){
            throw new NullUserName();
        }
    }

    private void validateNullablePassword(String password) throws NullPassword {
        if(password.equals(null)||password.isEmpty()){
            throw new NullPassword();
        }
    }

    private void postErrorMessage(String text){
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        Text textToPost= new Text(text);
        Button confirmButton=new Button("Ok");
        confirmButton.setOnAction(actionEvent->dialogStage.close());
        VBox vbox = new VBox(textToPost,confirmButton );
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(15));
        dialogStage.setScene(new Scene(vbox));
        dialogStage.show();
    }

    private void blankMessage(TextField blankText){
        blankText.getStyleClass().add("error");
    }

    private void removeBlankMessage(TextField blankText){
        blankText.getStyleClass().remove("error");
    }


    public void GoToApp(){

    }


}
