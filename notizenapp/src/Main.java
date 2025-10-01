package notizenapp.src;

public class Main {
    public static void main(String[]args){
        NoteManager manager = new NoteManager("notes.txt");  // lädt automatisch beim Start
        CLI cli = new CLI(manager); 
        cli.start(); // interaktives Menü starten
    }
}
