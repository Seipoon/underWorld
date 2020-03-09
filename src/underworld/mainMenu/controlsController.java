/*
 * Remove unused code! Trust the process.
 */
package underworld.mainMenu;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author Jeffrey Oh
 */
public class controlsController {

    @FXML
    private Button nextBtn, backBtn;

    @FXML
    protected void handleNextBtn() throws IOException {
        underworldapp.UnderWorld.setCurrentStage("stageOneScene");
        underworldapp.UnderWorld.setActiveScene("stageOneScene");
    }

    @FXML
    protected void handleBackBtn() throws IOException {
        underworldapp.UnderWorld.setActiveScene("mmScene");
    }

}
