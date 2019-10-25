package Crypto;

public class TableRow {
    public char character;
    public int amount;
    public float probability;
    public double worth;

    public TableRow(char character, int amount, float probability, double worth)
    {
        this.character = character;
        this.amount = amount;
        this.probability = probability;
        this.worth = worth;
    }
}
