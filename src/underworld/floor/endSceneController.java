/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package underworld.floor;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author Jeffrey Oh
 */
public class endSceneController {
    @FXML private Button homeBtn;
    
    @FXML
    protected void handleHomeBtn() throws IOException{
        underworldapp.UnderWorld.setActiveScene("mmScene");
    }
}
