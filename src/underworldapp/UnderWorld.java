/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package underworldapp;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * @author Jeffrey Oh
 */
public class UnderWorld extends Application {
    private static final HashMap<String, Parent> LOADER_LIST = new HashMap<>();
    private static Stage stage;
    
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        UnderWorld.stage = primaryStage;
        setupItems();
        
        primaryStage.setTitle("UnderWorld");
        setActiveScene("mmScene");
        primaryStage.show();
        
    }
    
    private void setupItems() throws IOException {
        FXMLLoader mainMenuLoader = new FXMLLoader();
        mainMenuLoader.setLocation(UnderWorld.class.getResource("/underworld/mainMenu/mainMenu.fxml"));
        Parent mainRoot = mainMenuLoader.load();
        LOADER_LIST.put("mmScene", mainRoot);
        
        FXMLLoader ccLoader = new FXMLLoader();
        ccLoader.setLocation(UnderWorld.class.getResource("/underworld/mainMenu/characterCreator.fxml"));
        Parent cRoot = ccLoader.load();
        LOADER_LIST.put("ccScene", cRoot);
        
        FXMLLoader controlsLoader = new FXMLLoader();
        controlsLoader.setLocation(UnderWorld.class.getResource("/underworld/mainMenu/controlsMenu.fxml"));
        Parent controlsRoot = controlsLoader.load();
        LOADER_LIST.put("controlsScene", controlsRoot);
        
        FXMLLoader stageOneLoader = new FXMLLoader();
        stageOneLoader.setLocation(UnderWorld.class.getResource("/underworld/floor/stageOne.fxml"));
        Parent stageOneRoot = stageOneLoader.load();
        LOADER_LIST.put("stageOneScene", stageOneRoot);
        
        FXMLLoader savePointOneLoader = new FXMLLoader();
        savePointOneLoader.setLocation(UnderWorld.class.getResource("/underworld/floor/savePointOneScene.fxml"));
        Parent savePointOneRoot = savePointOneLoader.load();
        LOADER_LIST.put("savePointOneScene", savePointOneRoot);
    }
    
    public static void setActiveScene(String name) throws IOException {
        Parent tempRoot = LOADER_LIST.get(name);
        Scene scene;
        if (tempRoot.getScene() == null) {
            scene = new Scene(tempRoot);
        } else {
            scene = tempRoot.getScene();
        }
        stage.setScene(scene);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
