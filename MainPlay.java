package TicTacToe_game;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Arrays;

public class MainPlay {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Pick icon for Player 1:");
        char symb1 = scanner.nextLine().charAt(0);
        char symb2;

        do {
            System.out.println("Pick icon for Player 2:");
            symb2 = scanner.nextLine().charAt(0);
        } while (symb1 == symb2);

        System.out.println(String.format("Select which player plays first. Enter 1 for %c, any other key for %c",symb1, symb2)); //needs control!
        int scelta = scanner.nextInt();
        scanner.nextLine();

        Player player = new Player();
        player.initialise(symb1, symb2, scelta);

        Field field = new Field();
        field.initialise(symb1, symb2);
        field.print();

        int counter = 0;
        int[] winStatus = new int[2];
        int[] winNot = new int[2];
        String nextMove;

        while (counter < 9 && Arrays.equals(winStatus, winNot)) {
            do {
                System.out.println(String.format("PLayer %c turn. Insert coordinates.", player.getPlayer()));
                nextMove =  scanner.nextLine();
            } while (!(nextMoveValidInput(nextMove) && field.emptyPosition(nextMove)));

            field.updateField(player.getPlayer(), nextMove);
            field.print();

            winStatus = field.winnerStaus();
            player.switchPlayer();
            counter++;
        }
        field.finalStatus(winStatus);

    }

    public static boolean nextMoveValidInput(String nextMove) {
        boolean legal = nextMove.length() == 3 && Pattern.matches("[123]{1}[' ']{1}[123]{1}", nextMove);
        return legal;
    }




}
