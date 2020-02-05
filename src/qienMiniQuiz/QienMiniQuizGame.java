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

	static int aantalSpelers = 0;
	static Scanner mijnScanner = new Scanner(System.in);
	static ArrayList <Speler> lijstSpelers = new ArrayList <Speler> ();
	static boolean spel = false;
	static int aanDeBeurt;
	static int aantalRondes;
	static int aantalBeurten;
	static Random random = new Random();
	static boolean vraag1Gesteld = false;
	static boolean vraag2Gesteld = false;
	static boolean vraag3Gesteld = false;
	static boolean vraag4Gesteld = false;
	static boolean vraag5Gesteld = false;
	static boolean vraag6Gesteld = false;
	static boolean vraag7Gesteld = false;
	static boolean vraag8Gesteld = false;
	static boolean vraag9Gesteld = false;
	static boolean vraag10Gesteld = false;
	static boolean vraag11Gesteld = false;
	static boolean vraag12Gesteld = false;
	static boolean vraag13Gesteld = false;
	static boolean vraag14Gesteld = false;
	static boolean vraag15Gesteld = false;
	static boolean vraag16Gesteld = false;
	
	public static void main(String[] args){
	
		System.out.println("**************************************************************************** \n"
		+ "welkom bij de MINIQUIZ, have fun! \n"
		+ "Weet je een vraag niet en wil je een hint? typ (hint), \ndit betekent wel dat je een punt aftrek krijgt. \n"
		+ "Per goed antwoord krijg je 3 punten. \n"
		+ "**************************************************************************** \n");
		
		spelersAanmaken();
		System.out.printf("\nWe spelen met de volgende spelers: ");
		for(Speler spelers : lijstSpelers) {
            System.out.println(spelers.getName());
        }
		int itemCount = lijstSpelers.size();
		System.out.println(itemCount);
		
		spel = true;
		
		while (spel == true) {
			
			if (aanDeBeurt >= aantalSpelers) {
				aanDeBeurt = 0;
			}
			aanDeBeurt++;
			
			System.out.println("\n" + "\n" + lijstSpelers.get(aanDeBeurt).getName() + " het is jouw beurt! Beantwoord de volgende vraag: ");

			vraagStellen();
			
			
			aantalBeurten++;
			aantalRondes = aantalBeurten / aantalSpelers;
			
			if (aantalRondes == 5) {
				spel = false;
			}
		
		}

		System.out.println("\n\n**************************************************************************** \nDat was de quiz jullie score is:\n");
		lijstSpelers.remove(0);
		toonScore();
	}
	
	static void vraagStellen() {
		
		String oplossingVraag1 = "wenen";
		String oplossingVraag2 = "40";
		String oplossingVraag3 = "wit";
		String oplossingVraag4 = "2";
		String oplossingVraag5 = "ushi";
		String oplossingVraag6 = "4";
		String oplossingVraag7 = "js";
		String oplossingVraag71 = "javascript";
		String oplossingVraag8 = "silicon valley";
		String oplossingVraag9 = "3";
		String oplossingVraag12 = "20";
		String oplossingVraag121 = "20ste";
		String oplossingVraag13 = "4";
		String oplossingVraag14 = "scrum";

		
		boolean vraagGesteld = false;
		int aantalPunten = 0;
		while (vraagGesteld == false) {
			int welkeVraag = 1 +  random.nextInt(15);
			
			switch (welkeVraag) {
			case 1:
				if (vraag1Gesteld == false) {
					System.out.println("Wat is de hoofdstad van Oostenrijk?");
					String antwoordvraag1 = mijnScanner.nextLine().toLowerCase();
					if (antwoordvraag1.equals("hint")) {
						aantalPunten -= 1;
						System.out.println("Ook wel bekend als Vienna");
						System.out.println("Geef nu jouw antwoord");
						antwoordvraag1 = mijnScanner.nextLine().toLowerCase();
					}
					
					if (antwoordvraag1.equals(oplossingVraag1)) {
						System.out.println("Dat is goed!");
						aantalPunten += 3;
					} else {
						System.out.println("Dat is fout! \nProbeer het nogmaals");
						antwoordvraag1 = mijnScanner.nextLine().toLowerCase();
						if (antwoordvraag1.equals("hint")) {
							System.out.println("Ook wel bekend als Vienna");
							System.out.println("Geef nu jouw antwoord");
							aantalPunten -= 1;
							antwoordvraag1 = mijnScanner.nextLine().toLowerCase();
						} 
						if (antwoordvraag1.equals(oplossingVraag1)) {
							System.out.println("Dat is goed!");
							aantalPunten += 3;
						} else {
							System.out.println("Dat is nog steeds fout het antwoord was: " + oplossingVraag1);
						}
						
					}
					lijstSpelers.get(aanDeBeurt).verhoogScore(aantalPunten);
					System.out.println("Score is nu: " + lijstSpelers.get(aanDeBeurt).getScore());
					vraagGesteld = true;
					vraag1Gesteld = true;
				}
				break;
				
			case 2:
				if (vraag2Gesteld == false) {
					System.out.println("Hoeveel is 6 x 6 : 2 + 22?");
					String antwoordvraag2 = mijnScanner.nextLine().toLowerCase();
					if (antwoordvraag2.equals("hint")) {
						aantalPunten -= 1;
						System.out.println("36 : 2 + 22");
						System.out.println("Geef nu jouw antwoord");
						antwoordvraag2 = mijnScanner.nextLine().toLowerCase();
					}
					
					if (antwoordvraag2.equals(oplossingVraag2)) {
						System.out.println("Dat is goed!");
						aantalPunten += 3;
					} else {
						System.out.println("Dat is fout! \nProbeer het nogmaals");
						antwoordvraag2 = mijnScanner.nextLine().toLowerCase();
						if (antwoordvraag2.equals("hint")) {
							System.out.println("36 : 2 + 22");
							System.out.println("Geef nu jouw antwoord");
							aantalPunten -= 1;
							antwoordvraag2 = mijnScanner.nextLine().toLowerCase();
						} 
						if (antwoordvraag2.equals(oplossingVraag2)) {
							System.out.println("Dat is goed!");
							aantalPunten += 3;
						} else {
							System.out.println("Dat is nog steeds fout het antwoord was: " + oplossingVraag2);
						}
						
					}
					lijstSpelers.get(aanDeBeurt).verhoogScore(aantalPunten);
					System.out.println("Score is nu: " + lijstSpelers.get(aanDeBeurt).getScore());
					vraagGesteld = true;
					vraag2Gesteld = true;
				}
				break;
			case 3:
				if (vraag3Gesteld == false) {
					System.out.println("Welke kleur begint altijd bij het schaken?");
					String antwoordvraag3 = mijnScanner.nextLine().toLowerCase();
					if (antwoordvraag3.equals("hint")) {
						aantalPunten -= 1;
						System.out.println("... begint en ... wint");
						System.out.println("Geef nu jouw antwoord");
						antwoordvraag3 = mijnScanner.nextLine().toLowerCase();
					}
					
					if (antwoordvraag3.equals(oplossingVraag3)) {
						System.out.println("Dat is goed!");
						aantalPunten += 3;
					} else {
						System.out.println("Dat is fout! \nProbeer het nogmaals");
						antwoordvraag3 = mijnScanner.nextLine().toLowerCase();
						if (antwoordvraag3.equals("hint")) {
							System.out.println("... begint en ... wint");
							System.out.println("Geef nu jouw antwoord");
							aantalPunten -= 1;
							antwoordvraag3 = mijnScanner.nextLine().toLowerCase();
						} 
						if (antwoordvraag3.equals(oplossingVraag3)) {
							System.out.println("Dat is goed!");
							aantalPunten += 3;
						} else {
							System.out.println("Dat is nog steeds fout het antwoord was: " + oplossingVraag3);
						}
						
					}
					lijstSpelers.get(aanDeBeurt).verhoogScore(aantalPunten);
					System.out.println("Score is nu: " + lijstSpelers.get(aanDeBeurt).getScore());
					vraagGesteld = true;
					vraag3Gesteld = true;
				}
				break;
			case 4:
				if (vraag4Gesteld == false) {
					System.out.println("Wie was de eerste president van Amerika?\\n Typ (1) voor Abraham Lincoln\\n Typ (2) voor George Washington\\n Typ (3) voor Benjamin Franklin");
					String antwoordvraag4 = mijnScanner.nextLine().toLowerCase();
					if (antwoordvraag4.equals("hint")) {
						aantalPunten -= 1;
						System.out.println("Heeft de Britten verslagen in de Amerikaanse revolutie");
						System.out.println("Geef nu jouw antwoord");
						antwoordvraag4 = mijnScanner.nextLine().toLowerCase();
					}
					
					if (antwoordvraag4.equals(oplossingVraag4)) {
						System.out.println("Dat is goed!");
						aantalPunten += 3;
					} else {
						System.out.println("Dat is fout! \nProbeer het nogmaals");
						antwoordvraag4 = mijnScanner.nextLine().toLowerCase();
						if (antwoordvraag4.equals("hint")) {
							System.out.println("Heeft de Britten verslagen in de Amerikaanse revolutie");
							System.out.println("Geef nu jouw antwoord");
							aantalPunten -= 1;
							antwoordvraag4 = mijnScanner.nextLine().toLowerCase();
						} 
						if (antwoordvraag4.equals(oplossingVraag4)) {
							System.out.println("Dat is goed!");
							aantalPunten += 3;
						} else {
							System.out.println("Dat is nog steeds fout het antwoord was: " + oplossingVraag4);
						}
						
					}
					lijstSpelers.get(aanDeBeurt).verhoogScore(aantalPunten);
					System.out.println("Score is nu: " + lijstSpelers.get(aanDeBeurt).getScore());
					vraagGesteld = true;
					vraag4Gesteld = true;
				}
				break;
			case 5:
				if (vraag5Gesteld == false) {
					System.out.println("Welk bekend Japans typetje wordt door Wendy van Dijk gespeeld?");
					String antwoordvraag5 = mijnScanner.nextLine().toLowerCase();
					if (antwoordvraag5.equals("hint")) {
						aantalPunten -= 1;
						System.out.println("Hip japans restaurant - s");
						System.out.println("Geef nu jouw antwoord");
						antwoordvraag5 = mijnScanner.nextLine().toLowerCase();
					}
					
					if (antwoordvraag5.equals(oplossingVraag5)) {
						System.out.println("Dat is goed!");
						aantalPunten += 3;
					} else {
						System.out.println("Dat is fout! \nProbeer het nogmaals");
						antwoordvraag5 = mijnScanner.nextLine().toLowerCase();
						if (antwoordvraag5.equals("hint")) {
							System.out.println("Hip japans restaurant - s");
							System.out.println("Geef nu jouw antwoord");
							aantalPunten -= 1;
							antwoordvraag5 = mijnScanner.nextLine().toLowerCase();
						} 
						if (antwoordvraag5.equals(oplossingVraag5)) {
							System.out.println("Dat is goed!");
							aantalPunten += 3;
						} else {
							System.out.println("Dat is nog steeds fout het antwoord was: " + oplossingVraag5);
						}
						
					}
					lijstSpelers.get(aanDeBeurt).verhoogScore(aantalPunten);
					System.out.println("Score is nu: " + lijstSpelers.get(aanDeBeurt).getScore());
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
				break;
			case 6:
				if (vraag6Gesteld == false) {
					System.out.println("Wat is het snelste dier van de wereld?\n Typ (1) voor Hazewindhond\n Typ (2) voor Gaffelbok\n Typ (3) voor Bulvleermuizen \n Typ (4) voor Jachtluipaard Cheeta");
					String antwoordvraag6 = mijnScanner.nextLine().toLowerCase();
					if (antwoordvraag6.equals("hint")) {
						aantalPunten -= 1;
						System.out.println("Geel met zwarte stippen");
						System.out.println("Geef nu jouw antwoord");
						antwoordvraag6 = mijnScanner.nextLine().toLowerCase();
					}
					
					if (antwoordvraag6.equals(oplossingVraag6)) {
						System.out.println("Dat is goed!");
						aantalPunten += 3;
					} else {
						System.out.println("Dat is fout! \nProbeer het nogmaals");
						antwoordvraag6 = mijnScanner.nextLine().toLowerCase();
						if (antwoordvraag6.equals("hint")) {
							System.out.println("Geel met zwarte stippen");
							System.out.println("Geef nu jouw antwoord");
							aantalPunten -= 1;
							antwoordvraag6 = mijnScanner.nextLine().toLowerCase();
						} 
						if (antwoordvraag6.equals(oplossingVraag6)) {
							System.out.println("Dat is goed!");
							aantalPunten += 3;
						} else {
							System.out.println("Dat is nog steeds fout het antwoord was: " + oplossingVraag6);
						}
						
					}
					lijstSpelers.get(aanDeBeurt).verhoogScore(aantalPunten);
					System.out.println("Score is nu: " + lijstSpelers.get(aanDeBeurt).getScore());
					vraagGesteld = true;
					vraag6Gesteld = true;
				}
				break;
			case 7:
				if (vraag7Gesteld == false) {
					System.out.println("Van welke taal is REACT een bibliotheek?");
					String antwoordvraag7 = mijnScanner.nextLine().toLowerCase();
					if (antwoordvraag7.equals("hint")) {
						aantalPunten -= 1;
						System.out.println("Het is geen JAVA");
						System.out.println("Geef nu jouw antwoord");
						antwoordvraag7 = mijnScanner.nextLine().toLowerCase();
					}
					
					if (antwoordvraag7.equals(oplossingVraag7) || antwoordvraag7.equals(oplossingVraag71)) {
						System.out.println("Dat is goed!");
						aantalPunten += 3;
					} else {
						System.out.println("Dat is fout! \nProbeer het nogmaals");
						antwoordvraag7 = mijnScanner.nextLine().toLowerCase();
						if (antwoordvraag7.equals("hint")) {
							System.out.println("Het is geen JAVA");
							System.out.println("Geef nu jouw antwoord");
							aantalPunten -= 1;
							antwoordvraag7 = mijnScanner.nextLine().toLowerCase();
						} 
						if (antwoordvraag7.equals(oplossingVraag7) || antwoordvraag7.equals(oplossingVraag71)) {
							System.out.println("Dat is goed!");
							aantalPunten += 3;
						} else {
							System.out.println("Dat is nog steeds fout het antwoord was: " + oplossingVraag7);
						}
						
					}
					lijstSpelers.get(aanDeBeurt).verhoogScore(aantalPunten);
					System.out.println("Score is nu: " + lijstSpelers.get(aanDeBeurt).getScore());
					vraagGesteld = true;
					vraag7Gesteld = true;
				}
				break;
			case 8:
				if (vraag8Gesteld == false) {
					System.out.println("In Californie is een regio waar veel technologiebedrijven zijn gevestigd. Hoe heet deze regio?");
					String antwoordvraag8 = mijnScanner.nextLine().toLowerCase();
					if (antwoordvraag8.equals("hint")) {
						aantalPunten -= 1;
						System.out.println("Ook een naam van een serie dat gaat over code geeks die het bedrijg PiedPiper oprichten");
						System.out.println("Geef nu jouw antwoord");
						antwoordvraag8 = mijnScanner.nextLine().toLowerCase();
					}
					
					if (antwoordvraag8.equals(oplossingVraag8)) {
						System.out.println("Dat is goed!");
						aantalPunten += 3;
					} else {
						System.out.println("Dat is fout! \nProbeer het nogmaals");
						antwoordvraag8 = mijnScanner.nextLine().toLowerCase();
						if (antwoordvraag8.equals("hint")) {
							System.out.println("Ook een naam van een serie dat gaat over code geeks die het bedrijg PiedPiper oprichten");
							System.out.println("Geef nu jouw antwoord");
							aantalPunten -= 1;
							antwoordvraag8 = mijnScanner.nextLine().toLowerCase();
						} 
						if (antwoordvraag8.equals(oplossingVraag8)) {
							System.out.println("Dat is goed!");
							aantalPunten += 3;
						} else {
							System.out.println("Dat is nog steeds fout het antwoord was: " + oplossingVraag8);
						}
						
					}
					lijstSpelers.get(aanDeBeurt).verhoogScore(aantalPunten);
					System.out.println("Score is nu: " + lijstSpelers.get(aanDeBeurt).getScore());
					vraagGesteld = true;
					vraag8Gesteld = true;
				}
				break;
			case 9:
				if (vraag9Gesteld == false) {
					System.out.println("Waar staat de afkorting HTML voor? \n Typ (1) voor HyperText Management Language \n Typ (2) voor HotText Marking Language \n Typ (3) voor HyperText Markup Language");
					String antwoordvraag9 = mijnScanner.nextLine().toLowerCase();
					if (antwoordvraag9.equals("hint")) {
						aantalPunten -= 1;
						System.out.println("M van Markup");
						System.out.println("Geef nu jouw antwoord");
						antwoordvraag9 = mijnScanner.nextLine().toLowerCase();
					}
					
					if (antwoordvraag9.equals(oplossingVraag9)) {
						System.out.println("Dat is goed!");
						aantalPunten += 3;
					} else {
						System.out.println("Dat is fout! \nProbeer het nogmaals");
						antwoordvraag9 = mijnScanner.nextLine().toLowerCase();
						if (antwoordvraag9.equals("hint")) {
							System.out.println("M van Markup");
							System.out.println("Geef nu jouw antwoord");
							aantalPunten -= 1;
							antwoordvraag9 = mijnScanner.nextLine().toLowerCase();
						} 
						if (antwoordvraag9.equals(oplossingVraag9)) {
							System.out.println("Dat is goed!");
							aantalPunten += 3;
						} else {
							System.out.println("Dat is nog steeds fout het antwoord was: " + oplossingVraag9);
						}
						
					}
					lijstSpelers.get(aanDeBeurt).verhoogScore(aantalPunten);
					System.out.println("Score is nu: " + lijstSpelers.get(aanDeBeurt).getScore());
					vraagGesteld = true;
					vraag9Gesteld = true;
				}
				break;
			case 10:
				if (vraag9Gesteld == false) {
					System.out.println("Geen vraag! 3 Bonuspunten!!");
					aantalPunten += 3;
					lijstSpelers.get(aanDeBeurt).verhoogScore(aantalPunten);
					System.out.println("Score is nu: " + lijstSpelers.get(aanDeBeurt).getScore());
					vraagGesteld = true;
					vraag10Gesteld = true;
				}
				break;
			case 11:
				if (vraag11Gesteld == false) {
					System.out.println("Geen vraag! 1 Strafpunt!!");
					aantalPunten -= 1;
					lijstSpelers.get(aanDeBeurt).verhoogScore(aantalPunten);
					System.out.println("Score is nu: " + lijstSpelers.get(aanDeBeurt).getScore());
					vraagGesteld = true;
					vraag11Gesteld = true;
				}
				break;
			case 12:
				if (vraag12Gesteld == false) {
					System.out.println("Op de hoeveelste van Februari is het Qien Code Cafe#3?");
					String antwoordvraag12 = mijnScanner.nextLine().toLowerCase();
					if (antwoordvraag12.equals("hint")) {
						aantalPunten -= 1;
						System.out.println("Op de 3e donderdag van Februari");
						System.out.println("Geef nu jouw antwoord");
						antwoordvraag12 = mijnScanner.nextLine().toLowerCase();
					}
					
					if (antwoordvraag12.equals(oplossingVraag12) || antwoordvraag12.equals(oplossingVraag121)) {
						System.out.println("Dat is goed!");
						aantalPunten += 3;
					} else {
						System.out.println("Dat is fout! \nProbeer het nogmaals");
						antwoordvraag12 = mijnScanner.nextLine().toLowerCase();
						if (antwoordvraag12.equals("hint")) {
							System.out.println("Op de 3e donderdag van Februari");
							System.out.println("Geef nu jouw antwoord");
							aantalPunten -= 1;
							antwoordvraag12 = mijnScanner.nextLine().toLowerCase();
						} 
						if (antwoordvraag12.equals(oplossingVraag12)) {
							System.out.println("Dat is goed!");
							aantalPunten += 3;
						} else {
							System.out.println("Dat is nog steeds fout het antwoord was: " + oplossingVraag12);
						}
						
					}
					lijstSpelers.get(aanDeBeurt).verhoogScore(aantalPunten);
					System.out.println("Score is nu: " + lijstSpelers.get(aanDeBeurt).getScore());
					vraagGesteld = true;
					vraag12Gesteld = true;
				}
				break;
			case 13:
				if (vraag13Gesteld == false) {
					System.out.println("Wie zijn de managing partners van Qien? \n Typ (1) voor Paul & Hamid \n Typ (2) voor Mauk & Hamid \n Typ (3) voor Jack & Paul \n Typ (4) voor Hamid & Dennis");
					String antwoordvraag13 = mijnScanner.nextLine().toLowerCase();
					if (antwoordvraag13.equals("hint")) {
						aantalPunten -= 1;
						System.out.println("1 van de managing partners heb je op de 1e dag in de ochtend gezien");
						System.out.println("Geef nu jouw antwoord");
						antwoordvraag13 = mijnScanner.nextLine().toLowerCase();
					}
					
					if (antwoordvraag13.equals(oplossingVraag13)) {
						System.out.println("Dat is goed!");
						aantalPunten += 3;
					} else {
						System.out.println("Dat is fout! \nProbeer het nogmaals");
						antwoordvraag13 = mijnScanner.nextLine().toLowerCase();
						if (antwoordvraag13.equals("hint")) {
							System.out.println("1 van de managing partners heb je op de 1e dag in de ochtend gezien");
							System.out.println("Geef nu jouw antwoord");
							aantalPunten -= 1;
							antwoordvraag13 = mijnScanner.nextLine().toLowerCase();
						} 
						if (antwoordvraag13.equals(oplossingVraag13)) {
							System.out.println("Dat is goed!");
							aantalPunten += 3;
						} else {
							System.out.println("Dat is nog steeds fout het antwoord was: " + oplossingVraag13);
						}
						
					}
					lijstSpelers.get(aanDeBeurt).verhoogScore(aantalPunten);
					System.out.println("Score is nu: " + lijstSpelers.get(aanDeBeurt).getScore());
					vraagGesteld = true;
					vraag13Gesteld = true;
				}
				break;
			case 14:
				if (vraag14Gesteld == false) {
					System.out.println("Gaan wij scrum of agile leren?");
					String antwoordvraag14 = mijnScanner.nextLine().toLowerCase();
					if (antwoordvraag14.equals("hint")) {
						aantalPunten -= 1;
						System.out.println("Laatste 3 letters geven het favoriete drankje van Jack Sparrow");
						System.out.println("Geef nu jouw antwoord");
						antwoordvraag14 = mijnScanner.nextLine().toLowerCase();
					}
					
					if (antwoordvraag14.equals(oplossingVraag14)) {
						System.out.println("Dat is goed!");
						aantalPunten += 3;
					} else {
						System.out.println("Dat is fout! \nProbeer het nogmaals");
						antwoordvraag14 = mijnScanner.nextLine().toLowerCase();
						if (antwoordvraag14.equals("hint")) {
							System.out.println("Laatste 3 letters geven het favoriete drankje van Jack Sparrow");
							System.out.println("Geef nu jouw antwoord");
							aantalPunten -= 1;
							antwoordvraag14 = mijnScanner.nextLine().toLowerCase();
						} 
						if (antwoordvraag14.equals(oplossingVraag14)) {
							System.out.println("Dat is goed!");
							aantalPunten += 3;
						} else {
							System.out.println("Dat is nog steeds fout het antwoord was: " + oplossingVraag14);
						}
						
					}
					lijstSpelers.get(aanDeBeurt).verhoogScore(aantalPunten);
					System.out.println("Score is nu: " + lijstSpelers.get(aanDeBeurt).getScore());
					vraagGesteld = true;
					vraag14Gesteld = true;
				}
				break;
			case 15:
				if (vraag15Gesteld == false) {
					System.out.println("Geen vraag! Wat een pech door een error in de code zijn je punten gewist en begin je weer bij 0");
					aantalPunten = 0;
					lijstSpelers.get(aanDeBeurt).setScore(0);
					System.out.println("Score is nu: " + lijstSpelers.get(aanDeBeurt).getScore());
					vraagGesteld = true;
					vraag15Gesteld = true;
				}
				break;
			case 16:
				if (vraag16Gesteld == false) {
					System.out.println("Geen vraag! Wat heb jij een geluk! Je krijgt 5 gratis punten");
					aantalPunten += 5;
					lijstSpelers.get(aanDeBeurt).verhoogScore(aantalPunten);
					System.out.println("Score is nu: " + lijstSpelers.get(aanDeBeurt).getScore());
					vraagGesteld = true;
					vraag16Gesteld = true;
				}
				break;
			default:
				vraagGesteld = true;
				break;
			}			
		}		
	}
	
	static void spelersAanmaken() {
		while (aantalSpelers == 0 || aantalSpelers > 3) {
			System.out.println("Met Hoeveel Spelers wil je spelen? (max 3)");
			int inputSpelers = mijnScanner.nextInt();
			if (inputSpelers > 3) {
				System.out.println("Dat is meer dan het maximum aantal spelers");
			}
			else {
				aantalSpelers = inputSpelers;
				System.out.println("Vul de namen in van de spelers");
				
				for (int i = 0; i <= aantalSpelers; i++) 
				{
					String naam = mijnScanner.nextLine();
					lijstSpelers.add(i, new Speler(naam));
					
				}
			}
		}
	}
	
	static void toonScore() {
		
		for(Speler spelers : lijstSpelers) {
			System.out.println(spelers.getName());
            System.out.printf("jij hebt gescoord: %d", spelers.getScore());
            if (spelers.getScore() <= 8) {
    			System.out.println("\nDat kan beter!");
    		}
    		else if (spelers.getScore() == 9 || spelers.getScore() == 10) {
    			System.out.println("\nRedelijk gedaan.");
    		}
    		else if (spelers.getScore() == 11 || spelers.getScore() == 12) {
    			System.out.println("\nGood job");
    		}
    		else if (spelers.getScore() > 12) {
    			System.out.println("\nGeweldig! Je bent een Quizmaster");
    		}
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
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void verhoogScore(int punten) {
		this.score += punten;
	}

	
}
