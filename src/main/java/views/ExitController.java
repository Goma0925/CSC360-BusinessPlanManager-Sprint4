package views;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ExitController {
	
	Stage exitViewStage;

	public void setExitViewStage(Stage exitViewStage) {
		this.exitViewStage = exitViewStage;
	}
	
	@FXML
    void onCancelQuit(ActionEvent event) {
		// Close the exit window if the cancel button is pressed.
		this.exitViewStage.close();
    }

    @FXML
    void onConfirmQuit(ActionEvent event) {
    	//Close the exit window if the quit button is pressed.
		this.exitViewStage.close();
		//----Insert a model's code to save data.----
		
		//-------------------------------------------
    	Platform.exit();
        System.exit(0);
    }
}
