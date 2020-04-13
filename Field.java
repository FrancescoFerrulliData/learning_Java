package TicTacToe_game;

class Field {
    char[][] field = new char[3][3];
    char symb1;
    char symb2;

    public void initialise(char symb1, char symb2) {
        System.out.println("The game starts!");
        char[][] initialField = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        field = initialField;
        this.symb1 = symb1;
        this.symb2 = symb2;
    }
    public void print() {
        //Print the battlefield.
        System.out.println("---------");
        System.out.printf("| %s %s %s |",this.field[2][0], this.field[2][1], this.field[2][2]);
        System.out.println();
        System.out.printf("| %s %s %s |",this.field[1][0], this.field[1][1], this.field[1][2]);
        System.out.println();
        System.out.printf("| %s %s %s |",this.field[0][0], this.field[0][1], this.field[0][2]);
        System.out.println();
        System.out.println("---------");
    }

    public boolean emptyPosition(String nextMove) {
        int x = Character.getNumericValue(nextMove.charAt(0)) - 1;
        int y = Character.getNumericValue(nextMove.charAt(2)) - 1;
        boolean empty = (this.field[y][x] == ' ') ? true : false;
        return empty;
    }

    public void updateField(char player, String nextMove) {
        int x = Character.getNumericValue(nextMove.charAt(0)) - 1;
        int y = Character.getNumericValue(nextMove.charAt(2)) - 1;
        this.field[y][x] = player;
    }

    public int[] winnerStaus() {
        int[] win = new int[2];
        for (int i=0; i<=2; i++) {
            if (this.field[i][0] == this.field[i][1] && this.field[i][0] == this.field[i][2]) {
                if (this.field[i][0] == this.symb2) {
                    win[0] = 1;
                } else if ((this.field[i][0] == this.symb1)) {
                    win[1] = 1;
                }
            }
            if (this.field[0][i] == this.field[1][i] && this.field[0][i] == this.field[2][i]) {
                if (this.field[0][i] == this.symb2) {
                    win[0] = 1;
                } else if ((this.field[0][i] == this.symb1)) {
                    win[1] = 1;
                }
            }
        }
        if (this.field[0][0] == this.field[1][1] && this.field[0][0] == this.field[2][2]) {
            if (this.field[1][1] == this.symb2) {
                win[0] = 1;
            } else if ((this.field[1][1] == this.symb1)) {
                win[1] = 1;
            }
        }
        if (this.field[2][0] == this.field[1][1] && this.field[1][1] == this.field[0][2]) {
            if (this.field[1][1] == this.symb2) {
                win[0] = 1;
            } else if ((this.field[1][1] == this.symb1)) {
                win[1] = 1;
            }
        }
        return win;
    }

    public void finalStatus(int[] winnerStatus) {
        if (winnerStatus[0] == 1) {
            System.out.println(String.format("Game ended: player %c is the winner!", this.symb2));
        } else if (winnerStatus[1] == 1) {
            System.out.println(String.format("Game ended: player %c is the winner!", this.symb1));
        } else {
            System.out.println("Game ended: Draw");
        }
    }


}
