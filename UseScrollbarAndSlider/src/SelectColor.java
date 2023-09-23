import javafx.application.Application; // 
import javafx.stage.Stage; // 
import javafx.scene.Scene; // 
import javafx.scene.control.Slider; // 
import javafx.scene.control.Label; // 
import javafx.scene.text.Text; // 
import javafx.scene.layout.GridPane; //
import javafx.scene.layout.BorderPane; // 
import javafx.scene.paint.Color; // 
import javafx.geometry.Pos; // 
import javafx.geometry.Insets; // 

// class extending usage of Application for gui 
public class SelectColor extends Application {

    // creates text object to display text
    private Text text = new Text("What color do you like?");
    
    // creates four slider objects for red, green, blue, and opacity
    private Slider slRed = new Slider(0, 1, 0.5); // min:0, max:1, value:0.5
    private Slider slGreen = new Slider(0, 1, 0.5);
    private Slider slBlue = new Slider(0, 1, 0.5);
    private Slider slOpacity = new Slider(0, 1, 1);

    @Override // the main entry point for the javafx gui application
    public void start(Stage primaryStage) {
        
        // gridpane to hold the sliders
        GridPane paneForSliders = new GridPane();
        paneForSliders.setHgap(10); // horizontal settings
        paneForSliders.setVgap(10); // vertical settings
        paneForSliders.setAlignment(Pos.CENTER); // centering the elements in pane

        // label of the color labels, added opacity 
        paneForSliders.addRow(0, new Label("Red"), slRed);
        paneForSliders.addRow(1, new Label("Green"), slGreen);
        paneForSliders.addRow(2, new Label("Blue"), slBlue);
        paneForSliders.addRow(3, new Label("Opacity"), slOpacity);
        
        // creates borderpane and sets gridpane in center and text at the top
        BorderPane pane = new BorderPane();
        pane.setCenter(paneForSliders);
        pane.setTop(text);
        BorderPane.setAlignment(text, Pos.CENTER); // center text in top area
        BorderPane.setMargin(text, new Insets(10, 10, 10, 10)); // sets margins for text

        // sets listener for sliders to update text color when sliders are moved from left to right
        slRed.valueProperty().addListener(e -> updateColor());
        slGreen.valueProperty().addListener(e -> updateColor());
        slBlue.valueProperty().addListener(e -> updateColor());
        slOpacity.valueProperty().addListener(e -> updateColor());

        // creates a scene and places it in the stage
        Scene scene = new Scene(pane, 300, 200); // Width:300, Height:200
        primaryStage.setTitle("Simple Color App"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    // the method to update color of the text based on slider values moving from left to right
    private void updateColor() {
        text.setFill(new Color(slRed.getValue(), slGreen.getValue(), slBlue.getValue(), slOpacity.getValue()));
    }

    // the main method 
    public static void main(String[] args) {
        launch(args); // starts the application 
    }
}
