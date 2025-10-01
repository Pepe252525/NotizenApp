package notizenapp.src;

import java.util.Scanner;
import java.util.List;

public class CLI {

    private final NoteManager manager;
    private final Scanner scanner;

    public CLI(NoteManager manager){
        this.manager = manager;
        this.scanner = new Scanner(System.in);  
    }
// System Schleife für die Methode Start()
        public void start(){
            while(true){
                showMenu();
                String choice = scanner.nextLine().trim();

                switch(choice){
                    case "1":
                        addNote();
                        break;
                    case "2":
                        listAllNotes();
                        break;
                    case "3":
                    searchNotes();
                    break;
                    case "0":
                    System.out.println("Programm beendet. Notizen werden gespeichert!");
                    return;
                    default: System.out.println("Ungültige Eingabe bitte wiederholen");

                }
            }
        } 
// Methode ShowMenu 
     private void showMenu(){
        System.out.println("\n=== Notizen-App ===");
        System.out.println("1) Neue Notiz hinzufügen");
        System.out.println("2) Alle Notizen anzeigen");
        System.out.println("3) Notizen durchsuchen");
        System.out.println("0) Beenden");
        System.out.print("Auswahl: ");
     } 
// Methode addNote()
    private void addNote(){
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Inhalt: ");
        String content = scanner.nextLine();
        manager.addNote(title,content);
        System.out.println("Notiz hinzugefügt");
    }  
// Methode searchNotes()
    private void searchNotes(){
        System.out.print("Suchbegriff: ");
        String keyword = scanner.nextLine();
        List<Note> results = manager.searchNotes(keyword);
        if(results.isEmpty()){
            System.out.println("Kein Treffer");
        }else{
            results.forEach(n->System.out.println(n));
        }
    }      
// Methode ListAllNotes
    private void listAllNotes(){
        List<Note> allNotes = manager.getNotes();
        if(allNotes.isEmpty()){
            System.out.println("Liste ist noch Leer");
        }else{
            for(Note n : allNotes){
                System.out.println(n); // ruft automatisch toString() von Note auf
            }
        }

    }
}
