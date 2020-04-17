import java.util.*;
public class Runner {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Board board=new Board();
        int x=0;
        boolean w;
        while(true) {

            if(x==21){
                System.out.println("Draw");
                break;
            }
            int col = -1;
            while (col < 0 || col > 6){
                System.out.println("Enter A Column:");
                if(sc.hasNextInt()) {
                    col = sc.nextInt();
                }else{
                    sc.next();
                }
            }
            w= board.move(col);
            if(w){
                System.out.println("You win!");
                break;
            }

        System.out.println("AI Move:");

            w=board.moveAI(board.getMove());
            if(w){
                System.out.println("AI wins!");
                break;
            }
            x++;
        }

    }
}
