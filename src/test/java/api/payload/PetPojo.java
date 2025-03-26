package api.payload;

import java.util.List;

public class PetPojo {

    private int id;  // "id" is an integer
    private Category category;  // "category" is an object of the Category class
    private String petname;  // "name" is a string
    private List<String> photoUrls;  // "photoUrls" is a list of strings (URLs)
    private List<Tag> tags;  // "tags" is a list of Tag objects
    private String status;  // "status" is a string (could be "available", "sold", or "pending")

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PetPojo{" +
                "id=" + id +
                ", category=" + category +
                ", petname='" + petname + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}
