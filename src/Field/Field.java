package Field;
import java.util.Scanner;
import java.util.Random;
 class  Field {
    static Scanner sc=new Scanner(System.in);
    static class UserFigure{
        private String userFigure;
         String getUserFigure(){
            return getUserFigure();
        }
        public void setUserFigure(String userFigure){
            this.userFigure=userFigure;
        }
        public int getUserInput(){
            System.out.println("Select ROCK PAPER SCISSORS");
            String input=sc.next();
            input=input.toUpperCase();
            char c=input.charAt(0);
            if (c=='R')
                return GameLogic.ROCK;
            else if (c=='P')
                return GameLogic.PAPER;
            else if (c=='S')
                return GameLogic.SCISSORS;
            else {
                getUserInput();
                return 0;
            }
        }
    }

    public static class PcFigure{
        private String pcFigure;

        public  void getPcFigure(){
            getPcFigure();
        }
        public void setPcFigure(String pcFigure){
            this.pcFigure=pcFigure;
        }
        public int generatePCInput(){
            Random random=new Random();
            int generatePCInput=random.nextInt(3)+1;
            return generatePCInput;
    }



}

    }


     class GameLogic{
        public static final int ROCK=1;
        public static final int PAPER=2;
        public static final int SCISSORS=3;
        public static void display(String who, int s){
            switch (s){
                case GameLogic.ROCK:
                    System.out.println(who+"selected ROCK");
                    break;
                case GameLogic.PAPER:
                    System.out.println(who+"selected PAPER");
                    break;
                case GameLogic.SCISSORS:
                    System.out.println(who+"selected SCISSORS");
                    break;
                default:
                    break;
            }
        }

         public static int validateInput(int userSelection,int computerSelection) {
             if (userSelection==computerSelection) return 0;
             switch (userSelection){
                 case ROCK:
                     return (computerSelection==SCISSORS ? 1: -1);
                 case PAPER:
                     return (computerSelection==ROCK?1:-1);
                 case SCISSORS:
                     return (computerSelection==PAPER?1:-1);
             }
             return 0;
         }
    }

       class GameRunner {

    private Field.UserFigure userFigure;
    private Field.PcFigure pcFigure;
     private int userScore;
     private int pcScore;



         public GameRunner() {
         userFigure =new Field.UserFigure();
         pcFigure =new Field.PcFigure();
        userScore=0;
        pcScore=0;


    }

        public static void main (String[] args ){
         GameRunner gameRunner =new GameRunner();

         gameRunner.startGame();

        }
        public void startGame(){
            userFigure = userFigure;
            int userinput= userFigure.getUserInput();
            GameLogic.display(userFigure.getUserFigure(),userinput);
            int pcinput=pcFigure.generatePCInput();
            GameLogic.display("Pc",pcinput);
            int checkWinner=GameLogic.validateInput(userinput,pcinput);
            switch (checkWinner) {
                case 0:
                    System.out.println("Tie");
                    break;
                case 1:
                    System.out.println(userFigure.getUserFigure()+"Beats"+"Pc"+"You won");
                    userScore++;
                    break;
                case -1:
                    System.out.println("Pc"+"Beats"+ userFigure.getUserFigure()+"You lost");
                    pcScore++;
                    break;
            }

        }

    }



