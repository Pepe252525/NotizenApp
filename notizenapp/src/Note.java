package notizenapp.src;
//Importe 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 
import java.util.Objects; 

public final class Note {

//Variablen definieren

private final String title; 
private String content;
private final LocalDateTime createAt; 
private LocalDateTime updateAt; 

// Konstruktor definieren 

public Note(String title,String content){
    if(title==null || title.isBlank()){
        throw new IllegalArgumentException("Titel darf nicht Null sein oder Leer");    }
        
        if(content==null){
            throw new IllegalArgumentException("Inhalt darf nicht Null sein!");
        }
        this.title = title;
        this.content = content; 
        this.createAt = LocalDateTime.now();
        this.updateAt = createAt; 
}

// Getter und Setter

public String getTitle(){
    return title;
}    
        public String getContent(){
            return content; 
        }
            public LocalDateTime getCreateAt(){
                return createAt;
            }
                public LocalDateTime getUpdateAt(){
                    return updateAt;
                }
public void setContent(String newContent){
    if(newContent==null){
        throw new IllegalArgumentException("Inhalt darf nicht Null sein!");
    } this.content = newContent;
      this.updateAt = LocalDateTime.now();
        
    }
// ToString-Methode zur Formatierung von createAt 

@Override
    public String toString(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String teaser = content.length()> 40 ? content.substring(0,40) + "..." : content;
        return "[" + createAt.format(dtf)+"]"+ title + "-" + teaser;
    }      

// Methode equals/Hash muss noch entschieden werden welche eingesetzt wird
@Override
public boolean equals(Object o){
    return super.equals(o);
}
@Override
public int hashCode(){
    return System.identityHashCode(this);
}

}


