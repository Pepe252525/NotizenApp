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

        public NoteManager(){
            this.notes = new ArrayList<>();
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
}
