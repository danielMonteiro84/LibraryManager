import java.util.Date;

public class Author {

    private final int id;
    private String name;
    private Date birthday;

    public Author(int id, String name, Date birthday){
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

   public String getName() {
        return name;
   }

   public void setName(String nome) {
        this.name = name;
   }

   public Date getBirthday() {
        return birthday;
   }

   public void setBirthday(Date birthday) {
        this.birthday = birthday;
   }
}
