

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import views.ExitController;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Convert the FXML into java
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/MainView.fxml"));
		Pane view = loader.load();
		Scene scene = new Scene(view);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//-----------Insert the code below to add ExitView--------
		primaryStage.setOnCloseRequest(
			new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent event) {
					//Stop exiting by event.consume()
	    			FXMLLoader exitViewLoader = new FXMLLoader();
	    			exitViewLoader.setLocation(Main.class.getResource("views/ExitView.fxml"));
	    			Pane exitView;
					try {
						exitView = exitViewLoader.load();
					} catch (IOException e) {
						exitView = null;
						e.printStackTrace();
					}
					ExitController exitController = exitViewLoader.getController();
					//Create a new stage for a popup window and set the exit view.
	    			Scene exitScene = new Scene(exitView);
	                final Stage dialog = new Stage();
	                dialog.initModality(Modality.APPLICATION_MODAL);
	                dialog.initOwner(primaryStage);
	                dialog.setScene(exitScene);
					exitController.setExitViewStage(dialog);
	                dialog.show();
					event.consume();
				}
	         });
		//-----------Insert the code above to add ExitView--------
	}
}
