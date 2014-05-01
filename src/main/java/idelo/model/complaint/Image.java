package idelo.model.complaint;


import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "image")
public class Image {
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    private Integer id;
    private byte[] imageBytes;
    private String name;
    private String format;
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

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", imageBytes=" + Arrays.toString(imageBytes) +
                ", name='" + name + '\'' +
                ", format='" + format + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (!format.equals(image.format)) return false;
        if (!id.equals(image.id)) return false;
        if (!Arrays.equals(imageBytes, image.imageBytes)) return false;
        if (!name.equals(image.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + Arrays.hashCode(imageBytes);
        result = 31 * result + name.hashCode();
        result = 31 * result + format.hashCode();
        return result;
    }
}
