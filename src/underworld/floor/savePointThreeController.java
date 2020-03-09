/*
 * Remove unused code! Trust the process.
 */
package underworld.floor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import underworld.character.Character;

/**
 *
 * @author Jeffrey Oh
 */
public class savePointThreeController {

    @FXML
    Button saveBtn, dontSaveBtn, quitBtn, contBtn;
    @FXML
    ImageView imgview;
    private final lastStageController stc;
    private final Character chara;
    private String newData;

    public savePointThreeController() {
        stc = new lastStageController();
        chara = Character.getInstance();
    }
    /*returns the characters name they set in the beginning,
    the class type they selected,
    and their current stage.
    this needs to be edited for the next deliverable because we have to do a persistent HP Check as well.
    */
    public String getNewData() {
        newData = chara.getCharaName() + " " + chara.getAttr().get("Class") + " " + 3;
        return newData;
    }

    @FXML
    protected void handleSaveBtn(final ActionEvent event) throws IOException, Exception {
        final Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Save Point 3");
        alert.setContentText("Do you want to save?");
        final Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            try (PrintWriter pw = new PrintWriter("save.txt")) {
                pw.write(getNewData());
                final Alert ok = new Alert(AlertType.INFORMATION);
                ok.setTitle("Save Confirm");
                ok.setHeaderText("Game Saved!");
                ok.setContentText("Game has been successfully saved!");
                underworldapp.UnderWorld.setCurrentStage("finalStage");
                ok.showAndWait();
            }

        } else {
            final Alert no = new Alert(AlertType.INFORMATION);
            no.setTitle("Save Confirm");
            no.setHeaderText("Game not Saved!?");
            no.setContentText("You didn't save! Great Job...");

            no.showAndWait();
            final PrintWriter pw = new PrintWriter("save.txt");
            pw.close();
        }

    }

    @FXML
    protected void handleQuitBtn(final ActionEvent event) throws IOException, Exception {
        underworldapp.UnderWorld.setActiveScene("mmScene");
    }

    @FXML
    protected void handleContBtn(final ActionEvent event) throws IOException, Exception {
        underworldapp.UnderWorld.setActiveScene("finalStageScene");
    }

}
