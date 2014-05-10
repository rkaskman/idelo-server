package idelo.response.parts;

import com.fasterxml.jackson.annotation.JsonProperty;
import idelo.model.complaint.Image;

public class ImageResponse {

    @JsonProperty
    private Integer id;
    @JsonProperty
    String data;
    @JsonProperty
    private String title;


    public ImageResponse(Image image) {
        this.id = image.getId();
        this.data = image.getData();
        this.title = image.getTitle();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
