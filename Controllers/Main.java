
package Controllers;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    
    @Override
    public void start(Stage primaryStage) {
        
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/Views/Vista.fxml"));
            Pane ventana = (Pane) loader.load();
            
            //show the scene
            Scene scene = new Scene(ventana);
            primaryStage.setScene(scene);
          
            
            //config
            primaryStage.setResizable(false);
            primaryStage.setTitle("Proyecto Final - Mejor Ruta");

            
            primaryStage.show();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
