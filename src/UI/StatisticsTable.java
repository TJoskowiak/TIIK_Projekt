package UI;

import Crypto.TableRow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StatisticsTable extends JTable {
    public static File analyzedFile;
    private static DefaultTableModel model;

    public StatisticsTable() {
        String[] column = {"Znak", "Ilość wystąpień", "Prawdopodobieństwo", "Ilość informacji"};

        model = new DefaultTableModel();

        for (int i = 0; i<4; i++)
        {
            model.addColumn(column[i]);
        }

        this.setModel(model);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    private static void calculateRows(Collection<TableRow> rows, float numberOfChars) {
        for (TableRow row : rows) {
            row.calculateProbability(numberOfChars);
            row.calculateWorth();
            model.addRow(row.getRow());
        }
    }

    public static void getRows() {
        if(analyzedFile == null)
            return;
        model.setRowCount(0);
        Map<Character, TableRow> tableRows = new HashMap<>();

        try {
            BufferedReader br = Files.newBufferedReader(analyzedFile.toPath());
            int character;
            int charSum = 0;
            while ((character = br.read()) != (-1)) {

                char key = (char)character;
                if(!tableRows.containsKey(key))
                    tableRows.put(key, new TableRow(key));
                tableRows.get(key).amount++;
                charSum++;
            }
            calculateRows(tableRows.values(),charSum);
            
        } catch (IOException ex) {
            Logger.getLogger(LoadFileButton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}