package idelo.response.parts;

import com.fasterxml.jackson.annotation.JsonProperty;
import idelo.model.complaint.Image;

public class ImageResponse {

    @JsonProperty
    private Integer id;
    @JsonProperty
    private byte[] imageBytes;
    @JsonProperty
    private String name;
    @JsonProperty
    private String format;

    public ImageResponse(Image image) {
        this.id = image.getId();
        this.imageBytes = image.getImageBytes();
        this.name = image.getName();
        this.format = image.getFormat();
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
}
