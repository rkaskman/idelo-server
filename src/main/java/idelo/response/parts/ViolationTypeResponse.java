package idelo.response.parts;

import com.fasterxml.jackson.annotation.JsonProperty;
import idelo.model.complaint.ViolationType;

public class ViolationTypeResponse {

    @JsonProperty
    Integer id;
    @JsonProperty
    String name;

    public ViolationTypeResponse(ViolationType violationType) {
        this.id = violationType.getId();
        this.name = violationType.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
