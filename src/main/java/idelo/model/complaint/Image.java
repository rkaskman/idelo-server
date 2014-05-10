package idelo.model.complaint;


import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    private Integer id;
    private String data;
    private String title;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="complaint", referencedColumnName = "id")
    private Complaint complaint;

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
