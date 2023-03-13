import java.util.Scanner;

public class Game {
    private Player p1,p2;
    private Board board;
    private int round;

    public Game()
    {

        p1 = new Player();
        p2 = new Player();
        board = new Board();
        round = 1;
    }
    public Game(int size)
    {
        p1 = new Player();
        p2 = new Player();
        board = new Board();
        round = 1;
    }
    public void readPlayersData()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to XO Game, Enter first player name: ");
        p1.setName(s.nextLine());
        System.out.println(p1.getName() + " Choose your symbol ( X or O )");
        while (true) {
            if(p1.setOP(s.nextLine().charAt(0)));
            break;
        }
        System.out.println( p1.getName() + " your symbol: " + p1.getOP());
        System.out.println("Enter second player name: ");
        p2.setName(s.nextLine());
        if(p1.getOP() == 'X')
        {
            p2.setOP('O');
        }
        else
            p2.setOP('X');
        System.out.println(p2.getName() + " your symbol: " + p2.getOP());
    }
    public void play()
    {
        readPlayersData();
        board.Drwa();
        while (board.isFull() == false) {
            Player p;
            if (round % 2 == 1)
                p = p1;
            else
                p = p2;
            round++;
            int position;
            while (true) {
                Scanner s = new Scanner(System.in);
                System.out.println(p.getName() + ", Enter empty cell to play");
                position = Integer.parseInt(s.nextLine());
                if (board.playerMove(p, position) == true) {
                    break;
                }
            }
            board.Drwa();
            if (board.isWin(p) == true) {
                System.out.println("Cngratulations " + p.getName() + ". You win");
                return;
            }
        }
        System.out.println("Drwa");
    }
}