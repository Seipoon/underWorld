/*
 * Remove unused code! Trust the process.
 */
package underworld.floor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import underworld.creature.Mob;
import underworld.mainMenu.characterCreatorController;

/**
 *
 * @author Jeffrey Oh
 */
public class stageThreeController implements Initializable{
    @FXML
    private Button attackBtn;
    @FXML
    private Button abilityBtn;
    @FXML
    private Button quitBtn, nextBtn;
    @FXML
    private TextArea tArea;
    private final characterCreatorController ccc;

    private final underworld.character.Character chara;

    private final Mob mob = new Mob();
    private int mobHp = mob.getHp("Kobold");
    private final int mobAtk = mob.getAtk("Kobold");

    public stageThreeController() {
        ccc = new characterCreatorController();
        chara = ccc.fetchChara();
    }

    private void playerToMobDmg() {
        final int atk = chara.getAttr().get("Strength");
        mobHp -= atk;
    }

    public underworld.character.Character fetchChara() {
        return chara;
    }

    @FXML
    protected void handleAttackBtn(final ActionEvent e) throws IOException, Exception {
        if (mobHp > 0) {
            tArea.setText("You attacked the Kobold!");
            tArea.appendText(" You dealt " + chara.getAttr().get("Strength") + " damage!");
            playerToMobDmg();
        }

        if (mobHp == 0 || mobHp < 0) {
            tArea.appendText(" You have slain the Kobold! You smell treasures...");
            nextBtn.setVisible(true);
            nextBtn.setOpacity(1);
            attackBtn.setDisable(true);
            abilityBtn.setDisable(true);
        }
    }

    @FXML
    protected void handleAbilityBtn(final ActionEvent e) throws IOException, Exception {
        if (mobHp > 0) {
            if (chara.getAttr().get("Class").equals(1)) {
                tArea.setText("You used crippling strike! ");
                tArea.appendText("You dealt " + (chara.getAttr().get("Strength") + 3) + " damage!");
                playerToMobDmg();
                if (mobHp == 0 || mobHp < 0) {
                    tArea.appendText(" You have slain the Kobold! You smell treasures...");
                    nextBtn.setVisible(true);
                    nextBtn.setOpacity(1);
                    attackBtn.setDisable(true);
                    abilityBtn.setDisable(true);
                } 
            }
            
            if (chara.getAttr().get("Class").equals(2)) {
                tArea.setText("You used fireball! ");
                tArea.appendText("You dealt " + (chara.getAttr().get("Intelligence") + 3) + " damage!");
                playerToMobDmg();
                if (mobHp == 0 || mobHp < 0) {
                    tArea.appendText(" You have slain the Kobold! You smell treasures...");
                    nextBtn.setVisible(true);
                    nextBtn.setOpacity(1);
                    attackBtn.setDisable(true);
                    abilityBtn.setDisable(true);
                }
            }
            
            if (chara.getAttr().get("Class").equals(3)) {
                tArea.setText("You used backstab! ");
                tArea.appendText("You dealt " + (chara.getAttr().get("Dexterity") + 3) + " damage!");
                playerToMobDmg();
                if (mobHp == 0 || mobHp < 0) {
                    tArea.appendText(" You have slain the Kobold! You smell treasures...");
                    nextBtn.setVisible(true);
                    nextBtn.setOpacity(1);
                    attackBtn.setDisable(true);
                    abilityBtn.setDisable(true);
                }
            }
        }
    }

    @FXML
    protected void handleQuitBtn(final ActionEvent e) throws IOException, Exception {
        underworldapp.UnderWorld.setActiveScene("mmScene");
    }

    @FXML
    protected void handleNextBtn(final ActionEvent e) throws IOException, Exception {
        underworldapp.UnderWorld.setActiveScene("savePointThreeScene");
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        tArea.setText("A Kobold has appeared!");
        attackBtn.setDisable(false);
        abilityBtn.setDisable(false);
    }
    
}
