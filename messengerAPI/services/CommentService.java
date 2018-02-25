/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messengerAPI.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import messengerAPI.database.DatabaseClass;
import messengerAPI.model.Comment;
import messengerAPI.model.Message;

/**
 *
 * @author David
 */
public class CommentService {
    
    private Map<Long, Message> messages = DatabaseClass.getMessages();
    
    public CommentService(){}
    
    public List<Comment> getAllComments(long id){
        Map<Long, Comment> comments = messages.get(id).getComments();
        return new ArrayList<>(comments.values());
    }
    
   
    public Comment getComment(long messageId, Long commentId){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.get(commentId);
    }
    
    public Comment addComment(long messageId, Comment comment){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comment.setId(comments.size()+1);
        comments.put(comment.getId(), comment);
        return comment;
    }
    
    public Comment updateComment(long messageId, Comment comment){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        if(comment.getId() <= 0){
            return null;
        }
        comments.put(comment.getId(), comment);
        return comment;
    }
    
    public Comment deleteComment(long messageId, long commentId){
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.remove(commentId);
    }
}
