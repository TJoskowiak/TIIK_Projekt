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
        JPanel labelPanel = new JPanel();

        topPanel.setLayout(new BorderLayout());
        frame.getContentPane().add(topPanel, BorderLayout.CENTER);
        frame.getContentPane().add(labelPanel, BorderLayout.NORTH);
        frame.getContentPane().add(btnPanel, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(st);
        topPanel.add(scrollPane, BorderLayout.CENTER);

        LoadFileButton loadFileButton = new LoadFileButton("Wczytaj plik");
        AnalyzeButton analyzeButton = new AnalyzeButton("Analizuj");
        CompressButton compressButton = new CompressButton("Kompresuj");
        DecompressButton decompressButton = new DecompressButton("Dekompresuj");

        EntropyLabel entropyLabel = new EntropyLabel();
        CompressionLevelLabel compressionLevelLabel = new CompressionLevelLabel();

        StatisticsTable.entropyLabel = entropyLabel;
        CompressButton.compressionLevelLabel = compressionLevelLabel;

        labelPanel.add(entropyLabel);
        labelPanel.add(compressionLevelLabel);

        btnPanel.add(loadFileButton);
        btnPanel.add(analyzeButton);
        btnPanel.add(compressButton);
        btnPanel.add(decompressButton);


        frame.setVisible(true);
    }
}
