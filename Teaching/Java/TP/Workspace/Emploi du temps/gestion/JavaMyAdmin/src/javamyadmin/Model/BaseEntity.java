package javamyadmin.Model;

public class BaseEntity {
	private String id;


    public void setId(String string) {
        this.id = string;
    }

    public String getId() {
        return id;
    }

    public boolean isNew() {
        return (this.id == null);
    }
}
