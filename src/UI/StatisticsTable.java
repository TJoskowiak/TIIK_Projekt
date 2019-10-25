package UI;

import Crypto.TableRow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.Vector;

public class StatisticsTable extends JTable {
    public static File analyzedFile;
    private DefaultTableModel model;

    public StatisticsTable() {
        String[] column = {"Znak", "Ilość wystąpień", "Prawdopodobieństwo", "Ilość informacji"};

        model = new DefaultTableModel();

        for (int i = 0; i<4; i++)
        {
            model.addColumn(column[i]);
        }

        model.addRow(new Vector());
        this.setModel(model);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public static void addRow(TableRow tableRow)
    {
        //@todo add row :)
    }
}