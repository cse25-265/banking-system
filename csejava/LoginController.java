import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class LoginView {
 
    public void show(Stage stage) {
 
        Label title = new Label("BANKING SYSTEM");
 
        Label usernameLabel = new Label("Username");
        TextField usernameField = new TextField();
 
        Label passwordLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();
 
        Button loginButton = new Button("Login");
 
        loginButton.setOnAction(event -> {
            LoginController controller = new LoginController();
            controller.login(
                stage,
                usernameField.getText(),
                passwordField.getText()
            );
        });
 
        VBox layout = new VBox(12);
        layout.setPadding(new Insets(25));
 
        layout.getChildren().addAll(
            title,
            usernameLabel,
            usernameField,
            passwordLabel,
            passwordField,
            loginButton
        );
 
        Scene scene = new Scene(layout, 400, 350);
 
        stage.setTitle("Banking System - Login");
        stage.setScene(scene);
        stage.show();
    }
}
