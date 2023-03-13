public class Board {
    private char board[][]; private int size, symbolsCnt;
    public Board()
    {
        int symbolsCnt = 0;
        size = 3;
        board = new char[3][3];
    }
    public Board(int size)
    {
        symbolsCnt= 0;
        this.size = size;
        board = new char[size][size];
    }
    public int getRow(int IDX){
        return ((IDX-1) / size);
   }
    public int getColum(int IDX){
        return ((IDX -1) % size);
   }
    public boolean isEmpty(int IDX){
        if(IDX > size || IDX < size)
            return false;
        int row = getRow(IDX);
        int colum = getColum(IDX);
        if(board[row][colum] == 'O' || board[row][colum] == 'X')
            return false;
        return true;
   }
    public boolean repalcChar(int IDX,Player p){
        if(isEmpty(IDX)){
            int row = getRow(IDX);
            int colum = getColum(IDX);
            board[row][colum] = p.getOP();
            return true;
        }
        return false;
   }
    public void Drwa(){
    for(int i = 0; i < size; i++){
    System.out.println("-------------");
        for(int j = 0; j < size; j++){
            symbolsCnt++;
            System.out.print("| "+ symbolsCnt +" ");
        }
        System.out.println("|");
    }
        System.out.println("-------------");
}
public boolean playerMove(Player p, int position)
    {
        symbolsCnt = 0;
        int row = getRow(position);
        int col = getColum(position);
        if(board[row][col] == 'X' || board[row][col] == 'O') {
            return false;
        }
        board[row][col] = p.getOP();
        symbolsCnt++;
        return true;
    }
boolean isFull(){
    if(symbolsCnt == size * size)
        return true;
    return false;
}
    public boolean checkRows(Player p){
       int cnt = 0;
   char symbol = p.getOP();
   for(int i = 0; i < size; i++){
       for(int j = 0; j < size; j++){
           if(board[i][j] == symbol)
               cnt++;
       }
      if(cnt == size)
          return true;
   }
   return false;
}
    public boolean checkDiagonals(Player p){
        char symbol = p.getOP();
        int cnt = 0;
        for(int i = 0; i < size; i++){
            if(board[i][i] == symbol)
                cnt++;
        }
    if(cnt == size)
        return true;
            cnt = 0;
        for(int i = size-1; i >= 0; i--){
            if(board[i][i] == symbol)
                cnt++;
        }
        if(cnt == size)
            return true;
        return false;
}
    public boolean checkCols(Player p) {
        char symbol = p.getOP();
            int cnt = 0;
        for(int j = 0; j < size; j++)
        {
            for(int i = 0; i < size; i++)
            {
                if(board[i][j] == symbol)
                {
                    cnt++;
                }
            }
            if(cnt == size)
                return true;
        }
        return false;
}

public boolean isWin(Player p){
        if(checkCols(p) == true || checkRows(p) == true || checkDiagonals(p) == true)
            return true;
        return false;
}
}
