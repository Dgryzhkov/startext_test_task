package models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.UUID;

public class Commentary {

    @Id
    private UUID commentaryId;

    @Column(name = "artefactId", nullable = false)
    private UUID artefactId;

    @Column(name = "uerId", nullable = false)
    private  String userId;

    @Column(name = "content", nullable = false)
    private String content;

    public Commentary(){

    }

    public Commentary(UUID commentaryId, UUID artefactId, String userId, String content) {
        this.commentaryId = commentaryId;
        this.userId = userId;
        this.content = content;
        this.artefactId = artefactId;
    }

    public UUID getCommentaryId() {
        if (commentaryId == null) {
            commentaryId = UUID.randomUUID();
        }
        return commentaryId;
    }

    public void setCommentaryId(UUID commentaryId) {
        this.commentaryId = commentaryId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UUID getArtefactId() {
        return artefactId;
    }

    public void setArtefactId(UUID artefactId) {
        this.artefactId = artefactId;
    }
}
