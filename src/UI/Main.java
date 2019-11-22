package UI;

import javax.swing.*;
import java.awt.*;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JFrame frame = new JFrame("TiIK");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setResizable(false);

        StatisticsTable st = new StatisticsTable();

        JPanel topPanel = new JPanel();
        JPanel btnPanel = new JPanel();
        JPanel entropyPanel = new JPanel();

        topPanel.setLayout(new BorderLayout());
        frame.getContentPane().add(topPanel, BorderLayout.CENTER);
        frame.getContentPane().add(entropyPanel, BorderLayout.NORTH);
        frame.getContentPane().add(btnPanel, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(st);
        topPanel.add(scrollPane, BorderLayout.CENTER);

        LoadFileButton loadFileButton = new LoadFileButton("Wczytaj plik");
        AnalyzeButton analyzeButton = new AnalyzeButton("Analizuj");
        EntropyLabel entropyLabel = new EntropyLabel();
        StatisticsTable.entropyLabel = entropyLabel;

        entropyPanel.add(entropyLabel);
        btnPanel.add(loadFileButton);
        btnPanel.add(analyzeButton);

        frame.setVisible(true);
    }
}
