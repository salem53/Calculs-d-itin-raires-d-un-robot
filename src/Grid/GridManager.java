package Grid;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Circle;


public class GridManager {

    private int n;
    private int m;

    private double cellSize;


    private GridPane gridPane;

    public void makeGrid(double cellSize, int n, int m, int margin) {
        this.n = n;
        this.m = m;
        this.cellSize = cellSize;
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(margin, margin, margin, margin));

        gridPane.setAlignment(Pos.CENTER);

        for (int i = 0; i < this.getN(); i++) {
            RowConstraints row = new RowConstraints(cellSize);
            row.setValignment(VPos.CENTER);
            gridPane.getRowConstraints().add(row);
        }
        for (int i = 0; i < this.getM(); i++) {
            ColumnConstraints column = new ColumnConstraints(cellSize);
            column.setHalignment(HPos.CENTER);
            gridPane.getColumnConstraints().add(column);
        }


        gridPane.setStyle("-fx-background-color:whitesmoke; -fx-grid-lines-visible: true");

    }


    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void addtogrid(Circle shape, int x, int y) {
        gridPane.add(shape, x, y);
    }

    public GridPane getGrid() {
        return this.gridPane;
    }
}
