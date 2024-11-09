package kg.iuca.InsightKgBackendApplication.controllers;

import kg.iuca.InsightKgBackendApplication.entities.Comment;
import kg.iuca.InsightKgBackendApplication.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/initiative/{initiativeId}")
    public List<Comment> getCommentsByInitiativeId(@PathVariable Long initiativeId) {
        return commentService.getCommentsByInitiativeId(initiativeId);
    }

    @PostMapping("/")
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }
}