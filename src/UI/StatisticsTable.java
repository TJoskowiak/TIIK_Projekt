package UI;

import Crypto.TableRow;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.text.DecimalFormat;

public class StatisticsTable extends JTable {
    public static File analyzedFile;
    private static DefaultTableModel model;
    public static EntropyLabel entropyLabel;
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
        double currentValue = 0;
        for (TableRow row : rows) {
            row.calculateProbability(numberOfChars);
            row.calculateWorth();
            model.addRow(row.getRow());
            currentValue += row.worth * (double) row.probability;
        }
        entropyLabel.updateLabel( new DecimalFormat("#.###").format(currentValue));
    }

    public static void getRows() {
        if(analyzedFile == null)
            return;
        model.setRowCount(0);
        Map<Character, TableRow> tableRows = new HashMap<>();

        try {
            String text = new String(Files.readAllBytes(analyzedFile.toPath()), StandardCharsets.UTF_8);
            //text = text.replaceAll("\\s+","");
            char[] charText = text.toCharArray();
            int charSum = 0;

            for (char character : charText) {
                if(!tableRows.containsKey(character))
                    tableRows.put(character, new TableRow(character));
                tableRows.get(character).amount++;
                charSum++;
            }
            calculateRows(tableRows.values(),charSum);


            
        } catch (IOException ex) {
            Logger.getLogger(LoadFileButton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}