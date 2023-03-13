public class Player {
    private String Name;
    private char OP;

    public Player() {
        OP = 'X';
        Name = "Player";
    }

    public Player(char OP)
    {
        setOP(OP);
        Name = "Player";
    }
    public Player(String name, char sympol)
    {
        setName(name);
        setOP(sympol);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public char getOP() {
        return OP;
    }

    public boolean setOP(char OP) {
        if (OP == 'X' || OP == 'x')
        {
            this.OP='X';
            return true;
        } else if (OP == 'O' || OP == 'o')
        {
            this.OP = 'O';
            return true;
        }
        else {
            System.out.println("Invalid Symbol");
            return false;
        }
    }
}
