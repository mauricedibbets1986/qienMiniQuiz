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
	
	public static void main(String[] args){
		

	
		int score = 0;
	
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
		
		spel = true;
		
		while (spel == true) {
			
			if (aanDeBeurt >= aantalSpelers) {
				aanDeBeurt = 0;
			}
			aanDeBeurt++;
			
			
			System.out.println("\n" + "\n" + lijstSpelers.get(aanDeBeurt).getName() + " het is jouw beurt! Beantwoord de volgende vraag: ");
			// vraag ophalen
			vraagStellen();
			
			
			aantalBeurten++;
			aantalRondes = aantalBeurten / aantalSpelers;
			
			if (aantalRondes == 5) {
				spel = false;
			}
		
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
	
	static void vraagStellen() {
		
		String oplossingVraag1 = "wenen";
		String oplossingVraag2 = "40";
		String oplossingVraag3 = "wit";
		String oplossingVraag4 = "2";
		String oplossingVraag5 = "ushi";
		
		boolean vraagGesteld = false;
		int aantalPunten = 0;
		while (vraagGesteld == false) {
			int welkeVraag = 1 +  random.nextInt(5);
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
						if (antwoordvraag5.equals(oplossingVraag4)) {
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
				if (vraag5Gesteld == false) {
					System.out.println("vraag 6");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
				break;
			case 7:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 7");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
				break;
			case 8:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 8");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
				break;
			case 9:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 9");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
				break;
			case 10:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 10");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
				break;
			case 11:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 11");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
				break;
			case 12:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 12");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
				break;
			case 13:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 13");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
				break;
			case 14:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 14");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
				break;
			case 15:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 15");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
				break;
			case 16:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 16");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
				break;
			case 17:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 17");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
				break;
			case 18:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 18");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
				break;
			case 19:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 19");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
				break;
			case 20:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 20");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
				break;
			case 21:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 21");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
				break;
			case 22:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 22");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
			case 23:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 23");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
			case 24:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 24");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
			case 25:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 25");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
			case 26:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 26");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
			case 27:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 27");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
			case 28:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 28");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
			case 29:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 29");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
				break;
			case 30:
				if (vraag5Gesteld == false) {
					System.out.println("vraag 30");
					vraagGesteld = true;
					vraag5Gesteld = true;
				}
				break;
			default:
				vraagGesteld = true;
				break;
			}			
		}		
	}
	
	static void spelersAanmaken() {
		while (aantalSpelers == 0 || aantalSpelers > 4) {
			System.out.println("Met Hoeveel Spelers wil je spelen? (max 4)");
			int inputSpelers = mijnScanner.nextInt();
			if (inputSpelers > 4) {
				System.out.println("Dat is meer dan het maximum aantal spelers");
			}
			else {
				aantalSpelers = inputSpelers;
				System.out.println("Vul de namen in van de spelers");
				
				for (int x = 0; x<=aantalSpelers; x++) 
				{
					String naam = mijnScanner.nextLine();
					lijstSpelers.add(x, new Speler(naam));
					
				}
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
