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
- Maak in totaal 10 vragen. Einde spel deel de score in in een classificatie. 9 || 10 = uitstekend, 7 || 8 = goed, 5 || 6 = matig else = slecht

Fase 4:
- Meerdere spelers: Vraag om aantal spelers, vraag om naam, om en om aan de beurt.
- Spelers krijgen random vragen: maak 30 vragen, deel vragen random toe aan een speler zijn beurt
*/


import java.util.Scanner;
import java.util.Random;

public class QienMiniQuizGame {


	
	public static void main(String[] args){
		
		Scanner mijnScanner = new Scanner(System.in);
		String oplossingVraag1 = "wenen";
		int score = 0;
	
		System.out.println("******************************** \nwelkom bij de minquiz, have fun! \n******************************** \n\n");
		
		System.out.println("Vraag 1: Wat is de hoofdstad van Oostenrijk?");
		String antwoordvraag1 = mijnScanner.nextLine().toLowerCase();
		if (antwoordvraag1.equals(oplossingVraag1)) {
			System.out.println("Dat is goed!");
		} else {
			System.out.println("Dat is fout!");
		}
		
	}
	
}
