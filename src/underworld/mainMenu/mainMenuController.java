/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package underworld.mainMenu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author Jeffrey Oh
 */
public class mainMenuController {

    @FXML
    private Button startBtn;
    @FXML
    private Button newBtn;
    @FXML
    private Button loadBtn;
    @FXML
    private Button deleteBtn;

    @FXML
    protected void handleNewBtn(ActionEvent event) throws IOException {
        underworldapp.UnderWorld.setActiveScene("ccScene");
        newBtn.setDisable(true);
        startBtn.setDisable(false);
        deleteBtn.setDisable(false);
    }

    @FXML
    protected void handleStartBtn(ActionEvent event) throws IOException {
        switch (underworldapp.UnderWorld.getCurrentStage()) {
            case "stageTwo":
                underworldapp.UnderWorld.setActiveScene("stageTwoScene");
                break;
            case "stageThree":
                underworldapp.UnderWorld.setActiveScene("stageThreeScene");
                break;
            case "stageOne":
                underworldapp.UnderWorld.setActiveScene("stageOneScene");
                break;
            default:
                underworldapp.UnderWorld.setActiveScene("controlsScene");
                break;
        }
    }

    @FXML
    protected void handleLoadBtn(ActionEvent event) throws IOException {
//        System.out.println("This feature is still not yet implemented!");
//        underworldapp.UnderWorld.setActiveScene("mmScene");
    }

    @FXML
    public void initialize() throws FileNotFoundException, IOException {
        FileReader reader = new FileReader("save.txt");
        BufferedReader br = new BufferedReader(reader);
        String line = br.readLine();
        if (line == null) {
            startBtn.setDisable(true);
        } else {
            startBtn.setDisable(false);
            newBtn.setDisable(true);
            deleteBtn.setDisable(false);
        }
    }

    @FXML
    protected void handleDeleteBtn(ActionEvent event) throws IOException {
        //delete the contents of the save file
        PrintWriter pw = new PrintWriter("save.txt");
        pw.close();
        startBtn.setDisable(true);
        deleteBtn.setDisable(true);
        newBtn.setDisable(false);
    }

}
