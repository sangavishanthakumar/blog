/**
 * This is a domain entity
 *
 */
package de.sangavi.blog.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.time.Instant;



/**
 * Entity: This annotation specifies that every object of this class can (but not necessarily need to) be saved in the database
 * In other words: The entity annotation specifies, that this class is a persistent entity
 * <p>
 * Table: This annotation gives information about how an entity is mapped to an existing database
 * Examples are name, schema and other attributes
 */

@Entity
@Table
public class Post {

    // primary key
    @Id
    // strategy: the way the primary key is generated
    // IDENTITY: database automatically generates an incremented value for the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // starting with the columns
    // ensure that the title is always given
    // empty titles will not be accepted
    @NotBlank
    @Column
    private String title;

    // store it as a lob
    // lob: large object, e.g. text, images, binary data
    @Lob
    @NotEmpty
    @Column
    private String content;

    // timestamps
    @Column
    private Instant createdOn;
    private Instant updatedOn;

    // user data
    @NotBlank
    @Column
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Instant updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
