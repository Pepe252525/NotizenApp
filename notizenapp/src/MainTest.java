package notizenapp.src;
public class MainTest {
public static void main(String []args){

    Note n1 = new Note("Einkauf","Brot,Eier,Milch");
        System.out.println(n1);

        try{
            new Note("","Sollte Fehlschlagen");
        }catch(IllegalArgumentException ex){
            System.out.println("Erwarteter Fehler:" + ex.getMessage());
        }
          
            n1.setContent("Käse,Wurst,Schinken");
            System.out.println("Nach Update:"+ n1);
            System.out.println("createdAt:"+ n1.getCreateAt());
            System.out.println("updateAt"+ n1.getUpdateAt());

            NoteManager manager = new NoteManager();
            manager.addNote("Einkaufen","Milch, Kaffee");
            manager.addNote("Schule","Stifte,Buch");
            manager.listNotes();
            System.out.println("Suche nach Milch:");
            for(Note n : manager.searchNotes("Milch")){
                System.out.println(n);
            }

        }

}



