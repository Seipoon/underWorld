/*
 * Remove unused code! Trust the process.
 */
package underworld.floor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import underworld.character.Character;
/**
 *
 * @author Jeffrey Oh
 */
public class savePointOneController {
    @FXML Button saveBtn, dontSaveBtn, quitBtn, contBtn;
    @FXML ImageView imgview;
    private final stageOneController soc;
    private final  Character chara;
    private String newData;
    
    public savePointOneController(){
        soc = new stageOneController();
        chara = soc.fetchChara();
        
    }
    public String getNewData(){
        newData = chara.getCharaName() + " " + chara.getAttr().get("Class") + " " + 1;
        return newData;
    }
    @FXML protected void handleSaveBtn(ActionEvent event) throws IOException, Exception{
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Save Point 1");
        alert.setContentText("Do you want to save?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            try (PrintWriter pw = new PrintWriter("save.txt")) {
            pw.write(getNewData());
            Alert ok = new Alert(AlertType.INFORMATION);
            ok.setTitle("Save Confirm");
            ok.setHeaderText("Game Saved!");
            ok.setContentText("Game has been successfully saved!");

            ok.showAndWait();
        }
            
        } else {
            Alert no = new Alert(AlertType.INFORMATION);
            no.setTitle("Save Confirm");
            no.setHeaderText("Game not Saved!?");
            no.setContentText("You didn't save! Great Job...");

            no.showAndWait();
            PrintWriter pw = new PrintWriter("save.txt");
            pw.close();  
        }
        
        
    }
    
    @FXML protected void handleQuitBtn(ActionEvent event) throws IOException, Exception{
        underworldapp.UnderWorld.setActiveScene("mmScene");
    }
    
    @FXML protected void handleContBtn(ActionEvent event) throws IOException, Exception{
        underworldapp.UnderWorld.setActiveScene("mmScene");
    }
    
    @FXML public void initialize() throws FileNotFoundException{
        imgview = new ImageView(new Image("file:image/westen-fry-bonfire2x.gif"));
        imgview.setVisible(true);
    }
}
