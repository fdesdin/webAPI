/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messengerAPI.database;

import java.util.HashMap;
import java.util.Map;
import messengerAPI.model.Comment;
import messengerAPI.model.Message;
import messengerAPI.model.Profile;

/**
 *
 * @author David
 */

public class DatabaseClass {
    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();
    
    public static Map<Long, Message> getMessages(){
        return messages;
    }
    
    public static Map<String, Profile> getProfile(){
        return profiles;
    }
}
