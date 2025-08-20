 import javafx.geometry.Insets;
 import javafx.scene.Scene;
 import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
 import javafx.stage.Stage;
  public class SimpleCalculator extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField num1Field = new TextField();
        TextField num2Field = new TextField();
        ComboBox<import javafx.application.Application;
String> operationBox = new ComboBox<>();
        operationBox.getItems().addAll("Add", "Subtract", "Multiply", "Divide");
        Label resultLabel = new Label();
        Button calcButton = new Button("Calculate");
        calcButton.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                 double result = 0;
                switch (operation) {
                    case "Add":
                        result = num1 + num2;
                        break;
                    case "Subtract":
                        result = num1 - num2;
                        break;
                    case "Multiply":
                        result = num1 * num2;
                        break;
                    case "Divide":
                        if (num2 == 0) {
                            resultLabel.setText("Error: Cannot divide by zero");
                            return;
                        }
                        result = num1 / num2;
                        break;
                    default:
                        resultLabel.setText("Select an operation");
                        return;
                }
                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input. Enter numbers.");
            }
        });
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(new Label("First Number:"), 0, 0);
        grid.add(num1Field, 1, 0);
        grid.add(new Label("Second Number:"), 0, 1);
        grid.add(num2Field, 1, 1);
        grid.add(new Label("Operation:"), 0, 2);
        grid.add(operationBox, 1, 2);
        grid.add(calcButton, 1, 3);
        grid.add(resultLabel, 1, 4);
        Scene scene = new Scene(grid, 350, 250);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
 }