/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messengerAPI.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import messengerAPI.database.DatabaseClass;
import messengerAPI.model.Profile;

/**
 *
 * @author David
 */
public class ProfileService {
    
    private Map<String, Profile> profiles = DatabaseClass.getProfile();
    
    public ProfileService(){}
    
    public List<Profile> getProfiles(){
        return new ArrayList<>(profiles.values());
    }
    
    public Profile getProfile(String profileName){
        return profiles.get(profileName);
    }
    
    public Profile addProfile(Profile profile){
        profile.setId(profiles.size()+1);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }
    
    public Profile updateProfile(Profile profile){
        if(profile.getProfileName().isEmpty()){
            return null;
        }
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }
    
    public Profile removeProfile(String profileName){
        return profiles.remove(profileName);
    }
}
