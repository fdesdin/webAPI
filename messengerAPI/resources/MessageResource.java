/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messengerAPI.resources;

import java.util.List;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import messengerAPI.model.Message;
import messengerAPI.services.MessageService;

/**
 *
 * @author David
 */
@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON) 
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
    MessageService messageService = new MessageService();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAllMessages(){        
        return messageService.getAllMessages();
    }
    
    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long messageId){
        return messageService.getMessage(messageId);
    }
    
    @POST
    public Message addMessage(Message message){
        return messageService.addMessage(message);
    }
    
    @PUT
    @Path("/{messageId}")    
    public Message updateMessage(@PathParam("messageId") long id, Message message){
        message.setId(id);        
        return messageService.updateMessage(message);
    }
    
    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long id){
        messageService.removeMessage(id); 
    } 
    
    @Path("/{messageId}/comments")
    public CommentResource getCommentResource(){
        return new CommentResource();
    }   
}
