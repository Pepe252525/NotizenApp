package notizenapp.src;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

// Persistente Speicherung der Notizen in einer Datei. 
public class FileHandler {

    /* Methode saveNotes() 
     *-zum öffnen der Datei im Schreibmodus
     *-soll jede Notiz als eine Zeile schreiben
     *-schließt die Datei wieder.
     */
    public void saveNotes(List<Note> notes, String filename){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            for(Note n : notes){
                writer.write(n.getTitle() +"|"+ n.getContent());
                writer.newLine();
            }
        }       catch(IOException e){
                    System.err.println("Fehler beim Speichern: " + e.getMessage());
                }
        
    }
    /*Methode loadNotes
     *-öffnet Datei im Lesemodus
     *-liest alle Zeilen
     *-trennt mit .Split("//|") in title und content
     *-erstellt Note-Objekte und gibt sie zurück 
     */
        public List<Note> loadNotes(String filename){
            List<Note> loadedNotes = new ArrayList<>();
            File file = new File(filename);
            
            if(!file.exists()){
                return loadedNotes; // Leere Liste wenn Datei nich nicht da ist.
            }
            try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
                String line;
                while((line = reader.readLine())!= null){
                    String[] parts = line.split("//|",1);
                    if(parts.length == 2){
                        loadedNotes.add(new Note(parts[0], parts[1]));
                    }
                }
            } catch(IOException e){
                System.err.println("Fehler beim Laden: "+ e.getMessage());
            }
            return loadedNotes;
        }
}
