import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;


import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RedLightGreenLightTime extends Application {

    private static BorderPane pane = new BorderPane();
    private Circle redLight = new Circle(263, 215,  30, Color.RED);
    private Circle yellowLight = new Circle(263, 280,  30, Color.GRAY);
    private Circle greenLight = new Circle(263, 280 + 65,  30, Color.GRAY);
    private int num = 0;


    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage stage){

        pane.setPrefSize(500, 500);

        Rectangle light = new Rectangle(225, 175, 75, 210 );
        pane.getChildren().addAll(light, redLight, yellowLight, greenLight);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5000), e -> {
            if(num == 3)
                num = 0;

            switch (num){
                case 0:
                    redLight.setFill(Color.RED);
                    yellowLight.setFill(Color.GRAY);
                    greenLight.setFill(Color.GRAY);
                    break;

                case 1:
                    redLight.setFill(Color.GRAY);
                    yellowLight.setFill(Color.GRAY);
                    greenLight.setFill(Color.LIMEGREEN);
                    break;

                case 2:
                    redLight.setFill(Color.GRAY);
                    yellowLight.setFill(Color.YELLOW);
                    greenLight.setFill(Color.GRAY);
                    break;

            }

            num++;
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }


}
