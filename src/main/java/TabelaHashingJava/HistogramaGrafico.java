package TabelaHashingJava;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class HistogramaGrafico extends Application {

    private static HashMap<Integer, Integer> histogramaData;   
    
    public static void exibirHistograma(HashMap<Integer, Integer> histograma) {
        histogramaData = histograma;
        launch();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Histograma de Distribuição Hash");

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        xAxis.setLabel("Índice");
        yAxis.setLabel("Colisões");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Distribuição de Colisões");

        for (Map.Entry<Integer, Integer> entry : histogramaData.entrySet()) {
            series.getData().add(new XYChart.Data<>(entry.getKey().toString(), entry.getValue()));
        }

        Scene scene = new Scene(barChart, 800, 600);
        barChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }
}

