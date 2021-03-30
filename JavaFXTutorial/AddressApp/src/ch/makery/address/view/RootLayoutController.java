package ch.makery.address.view;

import java.io.File;

import ch.makery.address.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

/**
 * 상위 레이아웃에 대한 컨트롤러이다. 상위 레이아웃은 메뉴바와 JavaFX 엘리먼트가 들어갈 공간을 포함한 기본적인 레이아웃을 제공한다.
 *
 * @author Marco Jakob
 */
public class RootLayoutController {

    // 메인 애플리케이션 참조
    private MainApp mainApp;

    /**
     * 참조를 다시 유지하기 위해 메인 애플리케이션이 호출한다.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * About 다이얼로그를 보여준다.
     */
    @FXML
    private void handleAbout() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("AddressApp");
    	alert.setHeaderText("About");
    	alert.setContentText("Author: Marco Jakob\nWebsite: http://code.makery.ch");

    	alert.showAndWait();
    }

    /**
     * 애플리케이션을 닫는다.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }

    /**
     * 생일 차트를 연다.
     */
    @FXML
    private void handleShowBirthdayStatistics() {
    	mainApp.showBirthdayStatistics();
    }
}
