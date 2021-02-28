/*
 * Jameel H. Khan
 * Module 5 Assignment
 * EN.605.201.83.SP21
 */

// import required package
import java.util.Scanner;

public class Translator
{
	public static void main ( String [] args)
	{
		// Encoding and decoding arrays
		char [] english = { 
			      'A', 'B', 'C', 'D', 'E', 'F', 
				  'G', 'H', 'I', 'J', 'K', 'L', 
				  'M', 'N', 'O', 'P', 'Q', 'R', 
				  'S', 'T', 'U', 'V', 'W', 'X', 
				  'Y', 'Z', '1', '2', '3', '4', 
				  '5', '6', '7', '8', '9', '0', ' '};
		
		String [] morse = { 
				   ".-", "-...", "-.-.", "-..", ".", 
				   "..-.", "--.", "....", "..", 
				   ".---", "-.-", ".-..", "--", 
				   "-.", "---", ".--.", "--.-", 
				   ".-.", "...", "-", "..-", 
				   "...-", ".--", "-..-", "-.--", 
				   "--..", ".----", "..---", "...--", 
				   "....-", ".....", "-....", "--...", 
				   "---..", "----.", "-----", "|" };
		
		// Define and initialize variables for values to be input
		int userChoice = 0;					// user selection: 1 or 2
		String userMessage = new String();	// message to translate
		String translationStr = ""; 		// variable to hold translated str
		String [] userInputMorse = null;	// array for morse translation
		
		// Scanner to obtain user input
		Scanner inputMain = new Scanner( System.in ); 
		
		System.out.println();
		System.out.print
		  ( "MAIN MENU "
		    + "\n1: Translate from English to Morse code"
		    + "\n2: Translate from Morse code to English"
		    + "\n"
		    + "\nEnter a number from the above choices: ");
		userChoice = inputMain.nextInt(); // read input for translation type
		
		if ( userChoice == 1 )
		{
			/*
			 * For some reason, my initial scanner does not take a 
			 * second input so I created another scanner specific to each
			 * input message type (English or Morse) to be used
			 */
			Scanner inputEnglish = new Scanner( System.in );
			System.out.print
			  ( "\nINSTRUCTIONS"
				+ "\nEnter the English phrase you wish to translate into Morse "
			    + "\ncode. Please separate each word with one blank space."
				+ "\n"
			    + "\nEnter the phrase: " );
			
			// read input, message to translate
			userMessage = inputEnglish.nextLine();
			
			// convert to upper case for encoding array comparison
			userMessage = userMessage.toUpperCase();
			
			// separate english message input into individual letters and store
			// in char array
			char [] userInputChar = userMessage.toCharArray();
			
			/*
			 * Initial for loop iterates through the letters of the English
			 * message stored in char array. Nested for loop iterates through
			 * each character in the English encoding array. Once a match is
			 * made (via the if == test), the index of the English encoding 
			 * array is used to find the corresponding Morse code in the Morse 
			 * array. The Morse code is then saved to the translationStr 
			 * variable. The same steps are repeated in the else section.
			 */
			for ( int i = 0; i < userInputChar.length; i++ )
			{
				for ( int j = 0; j < english.length; j++ )
				{
					if ( english[j] == userInputChar[i] )
					{
						translationStr = translationStr + morse[j] + " ";
					}
				} // end of j for loop
			} // end of i for loop
		}
		else
		{
			Scanner inputMorse = new Scanner( System.in );
			System.out.print
			  ( "\nINSTRUCTIONS"
				+ "\nEnter the Morse code you wish to translate. Please "
				+ "\nseparate each letter/digit with a single space and "
				+ "\ndelimit multiple words with a '|'. For example, "
				+ "\n'- --- | -... .' would be the Morse code for the "
				+ "\nsentence 'to be'."
				+ "\n"
				+ "\nEnter the phrase: " );
			
			// read input of Morse code to translate
			userMessage = inputMorse.nextLine();
			
			// split each Morse code letter into individual strings and save
			// to a array
			userInputMorse = userMessage.split( " " ); 
			
			for ( int i = 0; i < userInputMorse.length; i++ )
			{
				for ( int j = 0; j < morse.length; j++ )
				{
					if ( morse[j].equals(userInputMorse[i]) )
					{
						translationStr = translationStr + english[j];
					}
				} // end of j for loop
			} // end of i for loop
		} // end of if statement
		
		// output
		System.out.println( translationStr );
	} // end of main method
} // end of class Translator
