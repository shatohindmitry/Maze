
//https://forum.shelek.ru/index.php/topic,30238.0.html
//https://www.youtube.com/user/ChillinWithTym/videos

public class Main {

    public static void main(String[] args) {

        int ROWS = 12;
        int COLS = 12;

        //System.out.println(Messages.Mazes_4);
        Ellers ell = new Ellers(ROWS,COLS);
        ell.makeMaze();
        ell.printMaze();

        System.out.println();

//        Solver ellSol = new Solver(ell.getMaze());
//        ellSol.solveMaze();
//        ellSol.printSolution();
//
//        System.out.println(Messages.Mazes_4);
//        System.out.println(Messages.Mazes_5);

        new Maze(ROWS, COLS);
    }
}