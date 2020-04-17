import java.util.Scanner;

public class Board {
    int[][] board= new int[6][7];
    int personMove;
    public Board(){
        for(int row = 5; row > -1; row--) {
            for(int col = 0; col < 7; col++) {

                board[row][col]= 0;//col*10+row;

            }
        }
    }

    public void printBoard() {

        for(int row = 5; row > -1; row--) {
            for(int col = 0; col < 7; col++) {

                System.out.print(board[row][col]+" ");

            }
            System.out.print("\n");
        }


    }
    public boolean move(int x){
        int r=0;
        int y;
        Scanner sc = new Scanner(System.in);
        while(true){
            if(r>5){
                x=-1;
                System.out.println("Full Column");
                while (x < 0 || x > 6){
                    System.out.println("Enter A Column:");
                    if(sc.hasNextInt()) {
                        x = sc.nextInt();
                    }else{
                        sc.next();
                    }
                }
                 r=0;
            }else if(board[r][x]==0){
                personMove=x;
                board[r][x]=1;
                y=r;
                break;
            }else{
                r++;
            }
        }
        this.printBoard();
        return this.checkWin(y,x);
    }

    public boolean moveAI(int x){
        int r=0;
        int y;
        while(true){
            if(r>5){
                x=(int )(Math.random() * 7);
                r=0;
            }else if(board[r][x]==0){
                board[r][x]=2;
                y=r;
                break;
            }else{
                r++;
            }
        }

        this.printBoard();
       return this.checkWin(y,x);
    }

    public boolean checkWin(int row, int column){
        int x=0;
        for(int i=0;i<6;i++){
            if(board[row][i]==board[row][i+1]){
                if(board[row][i]!=0){
                    x++;
                }
                if(x==3){
                    return true;
                }
            }else{
                x=0;
            }
        }
        for(int i=0;i<5;i++){
            if(board[i][column]==board[i+1][column]){
                if(board[i][column]!=0){
                    x++;
                }
                if(x==3){
                    return true;
                }
            }else{
                x=0;
            }
        }
        int row2=row;
        int column2=column;
        while(true){
            if(row==0||column==0) {
                break;
            }
            row--;
            column--;
        }
        int q=0;
        while(true){
            if(column==6){
                break;
            }
            if(row==5){
                break;
            }
            if(board[row][column]==board[row+1][column+1]){
                q++;
            }
            if(board[row][column]==0){
                q=0;
            }
            if(q==3){
                return true;
            }
            if(row==4||column==5){
                break;
            }
            row++;
            column++;
        }

        while(true){
            if(row2==0||column2==6) {
                break;
            }
            row2--;
            column2++;
        }
        q=0;
        while(true){
            if(column2==0){
                break;
            }
            if(row2==5){
                break;
            }
            if(board[row2][column2]==board[row2+1][column2-1]){
                q++;
            }
            if(board[row2][column2]==0){
                q=0;
            }
            if(q==3){
                return true;
            }
            if(row2==4||column2==1){
                break;
            }
            row2++;
            column2--;
        }
        return false;
    }
    public int getMove(){
        int x=0;


        for(int i=0;i<7;i++){
            x=0;
            for(int a=0;a<4;a++){
                if(board[a][i]==2&&board[a+1][i]==2){
                    x++;
                }else{
                    x=0;
                }
                if(x==2&&board[a+2][i]==0){
                    return i;
                }
            }
        }



        for(int a=0;a<6;a++){
            x=0;
            for(int i=0;i<5;i++){
                if(board[a][i]==2&&board[a][i+1]==2){
                    x++;
                }else{
                    x=0;
                }
                if(x==2&&board[a][i+2]==0){
                    if(a==0){
                        return i+2;
                    }
                    if(board[a-1][i+2]!=0){
                        return i+2;
                    }

                }
                if(i>1&&x==2){
                    if(board[a][i-2]==0){
                        if(a==0){
                            return i-2;
                        }
                        if(board[a-1][i-2]!=0){
                            return i-2;
                        }
                    }
                }
                if(i==4&&x==1&&board[a][i+2]==2){
                    if(board[a][i-1]==0){
                        if(a==0){
                            return i-1;
                        }
                        if(board[a-1][i-2]!=0){
                            return i-1;
                        }
                    }
                }
            }
        }


        for(int i=0;i<7;i++){
            x=0;
            for(int a=0;a<4;a++){
                if(board[a][i]==1&&board[a+1][i]==1){
                    x++;
                }else{
                    x=0;
                }
                if(x==2&&board[a+2][i]==0){
                    return i;
                }
            }
        }

        for(int a=0;a<6;a++){
            x=0;
            for(int i=0;i<5;i++){
                if(board[a][i]==1&&board[a][i+1]==1){
                    x++;
                }else{
                    x=0;
                }
                if(x==2&&board[a][i+2]==0){
                    if(a==0){
                        return i+2;
                    }
                    if(board[a-1][i+2]!=0){
                        return i+2;
                    }

                }
                if(i>1&&x==2){
                    if(board[a][i-2]==0){
                        if(a==0){
                            return i-2;
                        }
                        if(board[a-1][i-2]!=0){
                            return i-2;
                        }
                    }
                }
                if(i==4&&x==1&&board[a][i+2]==1){
                    if(board[a][i-1]==0){
                        if(a==0){
                            return i-1;
                        }
                        if(board[a-1][i-2]!=0){
                            return i-1;
                        }
                    }
                }
            }
        }
        for(int i=0;i<7;i++){
            x=0;
            for(int a=0;a<4;a++){
                if(board[a][i]==2&&board[a+1][i]==2){
                    x++;
                }else{
                    x=0;
                }
                if(x==1&&board[a+2][i]==0){
                    return i;
                }
            }
        }
        for(int i=0;i<7;i++){
            x=0;
            for(int a=0;a<4;a++){
                if(board[a][i]==1&&board[a+1][i]==1){
                    x++;
                }else{
                    x=0;
                }
                if(x==1&&board[a+2][i]==0){
                    return i;
                }
            }
        }

        for(int a=0;a<6;a++){
            x=0;
            for(int i=0;i<6;i++){
                if(board[a][i]==1&&board[a][i+1]==1){
                    x++;
                }else{
                    x=0;
                }
                if(i!=5) {
                    if (x == 1 && board[a][i + 2] == 0) {
                        if (a == 0) {
                            return i + 2;
                        }
                        if (board[a - 1][i + 2] != 0) {
                            return i + 2;
                        }

                    }
                }
                if(i>0&&x==1){
                    if(board[a][i-1]==0){
                        if(a==0){
                            return i-1;
                        }
                        if(board[a-1][i-1]!=0){
                            return i-1;
                        }
                    }
                }
            }
        }

        for(int a=0;a<6;a++){
            x=0;
            for(int i=0;i<6;i++){
                if(board[a][i]==2&&board[a][i+1]==2){
                    x++;
                }else{
                    x=0;
                }
                if(i!=5) {
                    if (x == 1 && board[a][i + 2] == 0) {
                        if (a == 0) {
                            return i + 2;
                        }
                        if (board[a - 1][i + 2] != 0) {
                            return i + 2;
                        }

                    }
                }
                if(i>0&&x==1){
                    if(board[a][i-1]==0){
                        if(a==0){
                            return i-1;
                        }
                        if(board[a-1][i-1]!=0){
                            return i-1;
                        }
                    }
                }
            }
        }

        int col = (int )(Math.random()*3);
        col+=personMove-1;
        if(col>6){
            col=6;
        }
        if(col<0){
            col=0;
        }
        return col;
    }

}
