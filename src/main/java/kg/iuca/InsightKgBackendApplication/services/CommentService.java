package kg.iuca.InsightKgBackendApplication.services;

import kg.iuca.InsightKgBackendApplication.entities.Comment;
import kg.iuca.InsightKgBackendApplication.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Page<Comment> getCommentsByInitiativeId(Long initiativeId, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size).withSort(org.springframework.data.domain.Sort.by(sortBy));
        return commentRepository.findByInitiativeId(initiativeId, pageable);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long id, Comment commentDetails) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
        comment.setContent(commentDetails.getContent());
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
