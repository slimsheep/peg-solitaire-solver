package ai;

import java.util.ArrayList;
import java.util.List;

public class TestPegSolver {

	static List<List<String>> getTests() {
		List<List<String>> tests = new ArrayList<List<String>>();
		List<String> test = new ArrayList<String>() { 
			private static final long serialVersionUID = 1L;
			{add("--0XX--"); } 
			{add("--0XX--"); } 
	        {add("0000000"); } 
	        {add("0000000"); }
	        {add("0000000"); }
	        {add("--000--"); }
	        {add("--000--"); }
        }; 
        
		List<String> test1 = new ArrayList<String>() { 
			private static final long serialVersionUID = 1L;
			{add("--XXX--"); } 
			{add("--XXX--"); } 
	        {add("XXXXXXX"); } 
	        {add("XXX0XXX"); }
	        {add("XXXXXXX"); }
	        {add("--XXX--"); }
	        {add("--XXX--"); }
        }; 
        
		tests.add(test1);
		return tests;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			List<List<String>> boardConfigs = getTests();
		
			for(List<String> cfg: boardConfigs) {
				Board testBoard = Board.getBoard(cfg);
//				System.out.println(Board.getBoard(testBoard.bitMap()));
//				if(true) System.exit(0);
				PegSolitaireSolver solver = new PegSolitaireSolver(testBoard);
				if(!solver.solve())
					System.err.println("The given game instance cannot be solved");
				else {
					solver.printSteps();
				}
				System.out.println("Number of moves:  " + solver.getNumMoves());
				testBoard = Board.getBoard(cfg);
				solver = new PegSolitaireSolver(testBoard);
				System.out.println("A star moves"+solver.aStar());
				
				//System.err.println("The given game instance cannot be solved");
				//else print steps
			}		
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
