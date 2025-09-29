package notizenapp.src;
/*Eine Klasse, die alle Notizen im Speicher hält und typische Operationen anbietet:
Notiz hinzufügen
Alle Notizen anzeigen
Nach Notizen suchen*/
//Importe
import java.util.ArrayList;
import java.util.List;


public class NoteManager {

    private final List<Note> notes; 
    private final FileHandler fileHandler;
    private final String filename;

// Konstruktor
        public NoteManager(String filename){
            this.notes = new ArrayList<>();
            this.fileHandler = new FileHandler();
            this.filename = filename;
            load(); // Automatisch beim Start Laden
            Runtime.getRuntime().addShutdownHook(new Thread(this::save)); // ShutDownHook für automatisches Speichern
        }    
//Methode addNote() fürs Hinzüfugen für Notizen in eine Liste
            public void addNote(String title,String content){
                Note newNote = new Note(title,content);
                notes.add(newNote);
            }
//Methode listNotes() zum Anzeigen einer Liste
                public void listNotes(){
                    if(notes.isEmpty()){
                        System.out.println("Keine Notiz vorhanden");
                        return;
                    }
                        for(Note n : notes){
                            System.out.println(n);
                        }
                }
// Methode searchNotes() zum anlegen einer Liste, und alle passenden Notizen hinzufügen und zurück geben.
                    public List<Note> searchNotes(String keyword){
                        if(keyword==null || keyword.isEmpty()){
                            throw new IllegalArgumentException("Suchbegriff darf nicht leer sein");
                        }
                            List<Note> result = new ArrayList<>();
                            for(Note n : notes){
                                if(n.getTitle().contains(keyword)|| n.getContent().contains(keyword)){
                                result.add(n);
                                }
                            }
                                return result;
                    }
// Getter und Setter Methoden für die Ausgabe der Liste notes.
    public List<Note> getNotes(){
        return new ArrayList<>(notes);
        }
        public void setNotes(List<Note> notes){
            this.notes.clear();
            this.notes.addAll(notes);
        }
// Load() und Save() Methode zum verbinden des NoteManager und FileHandler 
// damit Programm automatisch beim Start lädt und beim Beenden speichert.
    public void load(){
        List<Note> loadedNotes = fileHandler.loadNotes(filename);
        setNotes(loadedNotes);    
    }
    public void save(){
        fileHandler.saveNotes(notes,filename);
    }
}
