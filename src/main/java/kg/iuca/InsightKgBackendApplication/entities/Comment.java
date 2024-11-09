package kg.iuca.InsightKgBackendApplication.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Content cannot be empty")
    private String content;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "initiative_id")
    private Initiative initiative;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
