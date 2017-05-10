
package cssthemedemo1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.AnchorPaneBuilder;
import javafx.stage.Stage;

/**
 *
 * @author sulitas
 */
public class CssThemeDemo1 extends Application {

    private final String theme1Url = getClass().getResource("theme1.css").toExternalForm();
    private final String theme2Url = getClass().getResource("theme2.css").toExternalForm();
    private final String theme3Url = getClass().getResource("theme3.css").toExternalForm();
    int n=0;

    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        final Scene scene = new Scene(root, 450, 350);
        scene.getStylesheets().add(theme3Url);
     
        Button butonCSS = new Button("Stilul 3");
        butonCSS.getStyleClass().add("buttonStyle");
        
        butonCSS.setOnAction((ActionEvent event) -> {
            
            scene.getStylesheets().remove(theme1Url);
            scene.getStylesheets().remove(theme2Url);
            scene.getStylesheets().remove(theme3Url);
        
            if (n%3==0){
                scene.getStylesheets().add(theme1Url);
                butonCSS.setText("Stilul 1");
            }
            
            if (n%3==1){
                scene.getStylesheets().add(theme2Url);
                butonCSS.setText("Stilul 2");
            }
            
            if (n%3==2){
                scene.getStylesheets().add(theme3Url);
                butonCSS.setText("Stilul 3");
            }
            
            n++;
        });
        
        
        root.getChildren().add(AnchorPaneBuilder.create().children(butonCSS).build());
        
        primaryStage.setTitle("Silviu Sulita - JavaFX - Schimbarea temelor 1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
