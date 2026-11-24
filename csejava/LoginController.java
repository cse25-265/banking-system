import model.Customer;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
 
public class LoginController {
 
    private Customer customer;
 
    public LoginController() {
        customer = new Customer(
            "C001",
            "Abi",
            "Test",
            "Gaborone",
            "abi@mail.com",
            "1234"
        );
    }
 
    public void login(Stage stage, String email, String password) {
 
        if (customer.login(email, password)) {
            AccountView accountView = new AccountView();
            accountView.show(stage);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Incorrect email or password.");
            alert.showAndWait();
        }
    }
