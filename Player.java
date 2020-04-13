package TicTacToe_game;

public class Player {
    char player;
    char symb1;
    char symb2;

    public void setSymbol1(char symb1) {
        this.symb1 = symb1;
    }
    public void setSymbol2(char symb2) {
        this.symb2 = symb2;
    }
    public void setPlayer(int choice) { player = (choice == 1) ? this.symb1 : this.symb2; }
    public char getPlayer() { return player; }
    public void switchPlayer() { player  = (player == this.symb1) ? this.symb2 : this.symb1; }

    public void initialise(char symb1, char symb2, int choice) {
        setSymbol1(symb1);
        setSymbol2(symb2);
        setPlayer(choice);
    }
}
