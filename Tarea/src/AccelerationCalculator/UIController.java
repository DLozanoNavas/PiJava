/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccelerationCalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author jlozanonavas
 */
public class UIController implements Initializable {

    // TODO Add calculations client
    public Calculations CalculationsObject = new Calculations();
    final NumberAxis xAxis = new NumberAxis();
    final NumberAxis yAxis = new NumberAxis();
    @FXML
    public TextField DistanciaEnKM;
    @FXML
    public TextField TiempoEnSegundos;
    @FXML
    public TextField PiDigits;
    @FXML
    public Text ResultNotificationLabel;
    @FXML
    public Text ResultTitle;
    @FXML
    public Text ResultText;

    @FXML
    final LineChart<Number, Number> VelChart
            = new LineChart<Number, Number>(xAxis, yAxis);

    private void init() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        XYChart.Series series = new XYChart.Series();
        series.setName("1");

        double DistanceInKm = 10;
        double Time = 20;

        series.getData().add(new XYChart.Data(DistanceInKm, Time));
        VelChart.getData().add(series);

    }

    public void reloadGraphs() {
        VelChart.setTitle("Velocidad");

        XYChart.Series series = new XYChart.Series();
        series.setName("VelocidadSet");

        double DistanceInKm = Double.parseDouble(DistanciaEnKM.getText());
        double Time = Double.parseDouble(TiempoEnSegundos.getText());

        series.getData().add(new XYChart.Data(DistanceInKm, Time));
        series.getData().add(new XYChart.Data(DistanceInKm * 2, Time * 1.5));
        VelChart.getData().add(series);

    }

    public void CalculatePi() {
        int pd = Integer.parseInt(PiDigits.getText());
        CalculationsObject.CalcularPI(pd);
        ResultNotificationLabel.setText(CalculationsObject.print());
        setPiResult();
    }

    public void setPiResult() {
        
                int pd = Integer.parseInt(PiDigits.getText());
        CalculationsObject.CalcularPI(pd);
        ResultTitle.setText("Numero Pi");
        ResultText.setText("π (pi) es la relación entre la longitud de una circunferencia y su diámetro en geometría euclidiana.1​ Es un número irracional2​ y una de las constantes matemáticas más importantes. Se emplea frecuentemente en matemáticas, física e ingeniería. El valor numérico de π, truncado a sus primeras "+PiDigits.getText()+" cifras, es el siguiente: " + CalculationsObject.print());
        
    }

}
