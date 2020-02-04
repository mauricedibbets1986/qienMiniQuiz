package qienMiniQuiz;

/*
De miniquiz opdracht. De miniquiz geeft de speler vragen. per beantwoorde vraag ontvang de speler punten, op het eind worden de punten
bijelkaar opgeteld en ziet de speler zijn eindscore. Het programma kan zo moeilijk gemaakt worden als je wil. Succes!

Fase 1: 
- Welkom bij de quiz melding
- Toon vraag
- Vraag om antwoord
- Controleer antwoord
- Meld goed of juist
- Geef punt
- 3 vragen

Fase 2:
- Maak naast open vragen ook multiple choice vragen. Vragen - antwoord - controle
- Geef spelers 2 pogingen per vraag

Fase 3:
- Geef de speler een hint optie bij het invullen van HINT
- trek 1 punt af indien speler om een hint heeft gevraagd
- Einde spel deel de score in in een classificatie.

Fase 4:
- Meerdere spelers: Vraag om aantal spelers, vraag om naam, om en om aan de beurt.
- Spelers krijgen random vragen: maak 30 vragen, deel vragen random toe aan een speler zijn beurt
*/


import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class QienMiniQuizGame {

	static int aantalSpelers;
	static Scanner mijnScanner = new Scanner(System.in);
	static ArrayList <Speler> lijstSpelers = new ArrayList <Speler> ();
	
	public static void main(String[] args){
		
		spelersAanmaken();
		
		String oplossingVraag1 = "wenen";
		String oplossingVraag2 = "40";
		String oplossingVraag3 = "wit";
		String oplossingVraag4 = "2";
		String oplossingVraag5 = "ushi";
		
		int score = 0;
	
		System.out.println("**************************************************************************** \n"
		+ "welkom bij de MINIQUIZ, have fun! \n"
		+ "Weet je een vraag niet en wil je een hint? typ (hint), \ndit betekent wel dat je een punt aftrek krijgt. \n"
		+ "Per goed antwoord krijg je 3 punten. \n"
		+ "**************************************************************************** \n");
		
		System.out.println("\nVraag 1: Wat is de hoofdstad van Oostenrijk?");
		String antwoordvraag1 = mijnScanner.nextLine().toLowerCase();
		if (antwoordvraag1.equals("hint")) {
			System.out.println("Ook wel bekend als Vienna");
			System.out.println("Geef nu jouw antwoord");
			score -= 1;
			antwoordvraag1 = mijnScanner.nextLine().toLowerCase();
		}
		
		if (antwoordvraag1.equals(oplossingVraag1)) {
			System.out.println("Dat is goed!");
			score += 3;
			System.out.println("Score is nu: " + score);
		} else {
			System.out.println("Dat is fout! \nProbeer het nogmaals");
			antwoordvraag1 = mijnScanner.nextLine().toLowerCase();
			if (antwoordvraag1.equals("hint")) {
				System.out.println("Ook wel bekend als Vienna");
				System.out.println("Geef nu jouw antwoord");
				score -= 1;
				antwoordvraag1 = mijnScanner.nextLine().toLowerCase();
			} 
			if (antwoordvraag1.equals(oplossingVraag1)) {
				System.out.println("Dat is goed!");
				score += 3;
			} else {
				System.out.println("Dat is nog steeds fout het antwoord was: " + oplossingVraag1);
			}
			System.out.println("Score is: " + score);
		}
		
		System.out.println("\nVraag 2: Hoeveel is 6 x 6 : 2 + 22");
		String antwoordvraag2 = mijnScanner.nextLine().toLowerCase();
		if (antwoordvraag2.equals("hint")) {
			System.out.println("36 : 2 + 22");
			System.out.println("Geef nu jouw antwoord");
			score -= 1;
			antwoordvraag2 = mijnScanner.nextLine().toLowerCase();
		}
		
		if (antwoordvraag2.equals(oplossingVraag2)) {
			System.out.println("Dat is goed!");
			score += 3;
			System.out.println("Score is nu: " + score);
		} else {
			System.out.println("Dat is fout! \nProbeer het nogmaals");
			antwoordvraag2 = mijnScanner.nextLine().toLowerCase();
			if (antwoordvraag2.equals("hint")) {
				System.out.println("36 : 2 + 22");
				System.out.println("Geef nu jouw antwoord");
				score -= 1;
				antwoordvraag2 = mijnScanner.nextLine().toLowerCase();
			} 
			
			if (antwoordvraag2.equals(oplossingVraag2)) {
				System.out.println("Dat is goed!");
				score += 3;
			} else {
				System.out.println("Dat is nog steeds fout het antwoord was: " + oplossingVraag2);
			}
			System.out.println("Score is: " + score);
		}
		
		System.out.println("\nVraag 3: Welke kleur begint altijd bij het schaken?");
		String antwoordvraag3 = mijnScanner.nextLine().toLowerCase();
		if (antwoordvraag3.equals("hint")) {
			System.out.println("... begint en ... wint");
			System.out.println("Geef nu jouw antwoord");
			score -= 1;
			antwoordvraag3 = mijnScanner.nextLine().toLowerCase();
		}
		
		if (antwoordvraag3.equals(oplossingVraag3)) {
			System.out.println("Dat is goed!");
			score += 3;
			System.out.println("Score is nu: " + score);
		} else {
			System.out.println("Dat is fout! \nProbeer het nogmaals");
			antwoordvraag3 = mijnScanner.nextLine().toLowerCase();
			if (antwoordvraag3.equals("hint")) {
				System.out.println("... begint en ... wint");
				System.out.println("Geef nu jouw antwoord");
				score -= 1;
				antwoordvraag3 = mijnScanner.nextLine().toLowerCase();
			}
			
			if (antwoordvraag3.equals(oplossingVraag3)) {
				System.out.println("Dat is goed!");
				score += 3;
			} else {
				System.out.println("Dat is nog steeds fout het antwoord was: " + oplossingVraag3);
			}
			System.out.println("Score is: " + score);
		}
		
		System.out.println("\nVraag 4: Wie was de eerste president van Amerika?\n Typ (1) voor Abraham Lincoln\n Typ (2) voor George Washington\n Typ (3) voor Benjamin Franklin");
		String antwoordvraag4 = mijnScanner.nextLine().toLowerCase();
		if (antwoordvraag4.equals("hint")) {
			System.out.println("Heeft de Britten verslagen in de Amerikaanse revolutie");
			System.out.println("Geef nu jouw antwoord");
			score -= 1;
			antwoordvraag4 = mijnScanner.nextLine().toLowerCase();
		}
		
		if (antwoordvraag4.equals(oplossingVraag4)) {
			System.out.println("Dat is goed!");
			score += 3;
			System.out.println("Score is nu: " + score);
		} else {
			System.out.println("Dat is fout! \nProbeer het nogmaals");
			antwoordvraag4 = mijnScanner.nextLine().toLowerCase();
			if (antwoordvraag4.equals("hint")) {
				System.out.println("Heeft de Britten verslagen in de Amerikaanse revolutie");
				System.out.println("Geef nu jouw antwoord");
				score -= 1;
				antwoordvraag4 = mijnScanner.nextLine().toLowerCase();
			}
			if (antwoordvraag4.equals(oplossingVraag4)) {
				System.out.println("Dat is goed!");
				score += 3;
			} else {
				System.out.println("Dat is nog steeds fout het antwoord was: " + oplossingVraag4);
			}
			System.out.println("Score is: " + score);
		}
		
		System.out.println("\nVraag 5: Welk bekend Japans typetje wordt door Wendy van Dijk gespeeld?");
		String antwoordvraag5 = mijnScanner.nextLine().toLowerCase();
		if (antwoordvraag4.equals("hint")) {
			System.out.println("Hip japans restaurant - s");
			System.out.println("Geef nu jouw antwoord");
			score -= 1;
			antwoordvraag4 = mijnScanner.nextLine().toLowerCase();
		}
		
		if (antwoordvraag5.equals(oplossingVraag5)) {
			System.out.println("Dat is goed!");
			score += 3;
			System.out.println("Score is nu: " + score);
		} else {
			System.out.println("Dat is fout! \nProbeer het nogmaals");
			antwoordvraag5 = mijnScanner.nextLine().toLowerCase();
			if (antwoordvraag4.equals("hint")) {
				System.out.println("Hip japans restaurant - s");
				System.out.println("Geef nu jouw antwoord");
				score -= 1;
				antwoordvraag5 = mijnScanner.nextLine().toLowerCase();
			}
			if (antwoordvraag5.equals(oplossingVraag5)) {
				System.out.println("Dat is goed!");
				score += 3;
			} else {
				System.out.println("Dat is nog steeds fout het antwoord was: " + oplossingVraag5);
			}
			System.out.println("Score is: " + score);
		}
		
		System.out.println("Dat was de quiz jouw score is: " + score);
		if (score <= 8) {
			System.out.println("Dat kan beter!");
		}
		else if (score == 9 || score == 10) {
			System.out.println("Redelijk gedaan.");
		}
		else if (score == 11 || score == 12) {
			System.out.println("Good job");
		}
		else if (score > 12) {
			System.out.println("Geweldig! Je bent een Quizmaster");
		}

	}
	
	static void spelersAanmaken()
	{
		System.out.println("Met Hoeveel Spelers wil je spelen?");
		aantalSpelers = mijnScanner.nextInt();
		System.out.println("Vul de namen in van de spelers");
		
		for (int x = 0; x<=aantalSpelers; x++) 
		{
			String naam = mijnScanner.nextLine();
			lijstSpelers.add(x, new Speler(naam));
			
		}
	}
	
}

class Speler {
	private String name;
	private int score = 0;
	Speler (String naam) {
		name = naam;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
