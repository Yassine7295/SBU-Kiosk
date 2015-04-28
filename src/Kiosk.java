/**
*Yassine Khaliqui
*109050245
*Homework Assignment Number 5
*CSE 214 Recitation Section 06
*Recitation TA: Kevin Flyangolts 
*Grading TA: Zheyuan (Jeffrey) Gao;
*@author Yassine
*/
import java.io.File;
import java.util.Scanner;

public class Kiosk {
	
	public static void main(String[] args) throws Exception {

		File f;
		String fileName = "";
		Scanner s = new Scanner(System.in);
		Scanner loadFile;
		String input, name, message, selection;
		String[] array;
		Tree tree = new Tree();
		TreeNode node = new TreeNode();
		
		menu();
		input = s.nextLine();
		while(!input.equalsIgnoreCase("q")) {
			if(input.equalsIgnoreCase("l")) {
				
				System.out.print("Enter the name of the file: ");
				input = s.nextLine();
				fileName = input;
				f = new File(fileName);
				loadFile = new Scanner(f);
				node.setName(loadFile.nextLine());
				node.setSelection(loadFile.nextLine());
				node.setMessage(loadFile.nextLine());
				tree.setRoot(node);
				array = loadFile.nextLine().split(" ");
				for(int i = 0; i < Integer.parseInt(array[1]); i++){
					name = loadFile.nextLine();
					selection = loadFile.nextLine();
					message = loadFile.nextLine();
					tree.addNode(name, selection, message, "root");
					
				}
				while(loadFile.hasNextLine()){
					array = loadFile.nextLine().split(" ");
					for(int i = 0; i < Integer.parseInt(array[1]); i++){
						name = loadFile.nextLine();
						selection = loadFile.nextLine();
						message = loadFile.nextLine();
						tree.addNode(name, selection, message, array[0]);
					}
				}
				System.out.println();
				System.out.println("Menu has been updated!");
				System.out.println();
			}
			else if(input.equalsIgnoreCase("p")) {
				try{
					tree.printMenu(tree.getRoot().getName());
				} catch(EmptyTreeException ex){
					ex.getMessage();
				}
			}
			else if(input.equalsIgnoreCase("s")) {
				try{
					tree.beginSession();
				} catch(EmptyTreeException ex){
					ex.getMessage();
				}
			}
			else if(!input.equalsIgnoreCase("q")) {
				System.out.println("\nInvalid command!\n");
			}
			menu();
			input = s.nextLine();
		}
		System.out.println("\nKiosk terminated...");
	}
	
	public static void menu(){
		System.out.print("The Tree of Decisions\n\n"
				+ "L) Load a Tree\n"
				+ "P) Print menu\n"
				+ "S) Start service\n"
				+ "Q) Quit\n"
				+ "Choice: ");
	}
	
}
