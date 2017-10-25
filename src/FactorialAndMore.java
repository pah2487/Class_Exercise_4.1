import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.application.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import java.util.ArrayList;
import java.util.List;

/**
 * creates JFX input then finds factorial, sum of odd numbers, and fibinacci sequence for user input n
 * @author Patrick H.
 * @since 2017-10-24
 * @version 1.0
 */
public class FactorialAndMore extends Application{

    public void start(Stage primaryStage) {
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setTitle("Factorial and More!");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Scene scene = new Scene(grid, 600,300);
        Text scenetitle = new Text("Please enter your number below.");
        grid.add(scenetitle, 0,0,2,1);
        Label  userNumLabel = new Label("Number:");
        TextField userNumBox = new TextField();
        grid.add(userNumLabel, 0, 1);
        grid.add(userNumBox, 1, 1);

        Button calcBtn = new Button("Calculate!");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(calcBtn);
        grid.add(hbBtn, 1, 3);

        primaryStage.setScene(scene);
        primaryStage.show();


        calcBtn.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {

                    String uinput = userNumBox.getText();
                    int input = Integer.parseInt(uinput);
                    int count = 1;
                    int factorial = 1;
                    do {
                        factorial *= count;
                        count++;
                    } while (count <= input);
                    Label factoLabel = new Label(input + "!= ");
                    grid.add(factoLabel, 0, 5);
                    Text factoNum = new Text(Integer.toString(factorial));
                    grid.add(factoNum, 2, 5);

                    count = 0;
                    int oddSum = 0;
                    do {
                        oddSum = ((2 * count) + 1) + oddSum;
                        count++;
                    } while (count < input);
                    Label oddSumLabel = new Label("Sum of the first " + input + " odd numbers are:");
                    grid.add(oddSumLabel, 0, 6);
                    Text oddSumNum = new Text(Integer.toString(oddSum));
                    grid.add(oddSumNum, 2, 6);


                    int prevValue = 1;
                    int prevPrevValue = 0;
                    count = 0;
                    List<Integer> fibo = new ArrayList<>();
                    do{
                        int currValue = prevValue + prevPrevValue;
                        prevPrevValue = prevValue;
                        prevValue = currValue;
                        fibo.add(currValue);
                        count++;
                    } while (count < input);
                    Label fiboLabel = new Label("The first " + input + " numbers in the Fibonacci Sequence are: ");
                    grid.add(fiboLabel, 0, 7);
                    Text FiboNum = new Text(fibo.toString());
                    grid.add(FiboNum, 2, 7);
                }
        });

       }

}
