package models;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "artefacts")
public class Artefact {

    @Id
    private UUID artefactId;

    @Column(name= "created")
    private Date created;

    @Column(name = "userId", nullable = false)
    private  String userId;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "description", nullable = false)
    private String  description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "artefactId", referencedColumnName = "artefactId")
    private List<Commentary> commentaries = new ArrayList<>();

    public Artefact(){

    }

    public Artefact(UUID artefactId, Date created, String userId, String category, String description) {
        this.artefactId = artefactId;
        this.created = created;
        this.userId = userId;
        this.category = category;
        this.description = description;
    }

    public UUID getArtefactId() {
        if (artefactId==null){
            artefactId=UUID.randomUUID();
        }
        return artefactId;
    }

    public void setArtefactId(UUID artefactId) {
        this.artefactId = artefactId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Page<Commentary> getCommentaries(Pageable pageable) {
        int start =(int) pageable.getOffset();
        int end = (Math.min((start+pageable.getPageSize()), commentaries.size()));
        return new PageImpl<>(commentaries.subList(start,end), pageable, commentaries.size());
    }

    public void setCommentaries(List<Commentary> commentaries) {
        this.commentaries = commentaries;
    }
}
