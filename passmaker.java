/*
Writen by: Techis

Later implentations of this project may include a password database of sorts where you can input the a name for the password and save the name 
and password to a file for later use. If this is done then there will probably be a better menu added. 

TO BE IMPLEMENTED:
Legit menu
password db of some kind

All code is provided as is and I am not responsible for what YOU choose to do with it. 
*/

//Java imports needed for project
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

public class passmaker{

	//static class variables to be used by all methods
	static int [] passints; //array of integers that will become the password
	static ArrayList<Integer> invalid = new ArrayList<Integer>(); //array of invalid characters, arraylist for easy comparisons later
	static int reject[] = {34,35,37,38,39,40,41,42,43,44,47,58,59,60,61,62,64,91,92,93,94,95,96,123}; //ascii codes for invalid special characters. If you want to use them that is up to you but you will have to figure out what each is and remove it from the list

	public static void main(String[] args){
		passmaker pass = new passmaker(); //creates object since variables are non-static
		Scanner in = new Scanner(System.in);
		int length = 0;
		System.out.println("How many total characters would you like in your password?");
		length = in.nextInt();
		passints = new int[length];
		pass.genKey(); //generates the integers for the password. The for loop populates the arraylist
		for(int i=0; i<reject.length; i++){
			invalid.add(reject[i]);
		}
		System.out.println(pass.genPass()); //generates and outputs the password that has been generated
	}

	//generates a random number with an offset for valid ascii characters
	private int genNumber(){
		Random rand = new Random();
		return rand.nextInt(91)+33;
	}

	//populates the key array with numbers from genNumber
	private void genKey(){
		for(int i=0; i<passints.length; i++){
			passints[i] = genNumber();
		}
	}

	//converts the numbers in the array to letters and fixes the special characters that most passwords will reject and returns a string to be directly printed.
	private String genPass(){
		String characters="";
		for(int i=0; i<passints.length; i++){
			if(invalid.contains(passints[i])){
				if(passints[i]==34 || passints[i]==35){
					passints[i]=33;
				}
				else if(passints[i]>=36 && passints[i]<=44){
					passints[i]=45;
				}
				else if(passints[i]==47){
					passints[i]=48;
				}
				else if(passints[i]==58 || passints[i]==59){
					passints[i]=57;
				}
				else if(passints[i]>=60 && passints[i]<=62){
					passints[i]=63;
				}
				else if(passints[i]>=91 && passints[i]<=93){
					passints[i]=90;
				}
				else if(passints[i]>=94 && passints[i]<=96){
					passints[i]=97;
				}
				else if(passints[i]==123){
					passints[i]=122;
				}
			}
			characters+=String.valueOf(((char)passints[i]));
		}

		return characters;
	}

}