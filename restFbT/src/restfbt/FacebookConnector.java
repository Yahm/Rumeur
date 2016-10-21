/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restfbt;

/**
 *
 * @author Yacine
 */
/*public class FacebookConnector {
    
}*/
import java.util.Arrays;
import java.util.List;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.Facebook;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.exception.FacebookException;
import com.restfb.json.JsonObject;
import com.restfb.types.FacebookType;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.User;
public class FacebookConnector {
    /* Variables */
    private final String pageAccessToken = "EAACEdEose0cBAJnWYZBFvd7lNPAPRHnbDFKbAPmShnIuXMwWN2JjUrpbYISTOjhbsTvTBbuJf5AZCb16aa90N8ZB2pZBdWbqNr5T8ZC4RNcN1XfYIPZCaPSwZAzMBbxVfDCOKQFkMAZCHwZBGPG76wh98ZAwfb8qTUORkQvic9m2akMgZDZD";
    private final String pageID = "9gag";
    private FacebookClient fbClient;
    private User myuser = null;
    private Page mypage = null;  
    JsonObject jsonResults = null;
                                   
    private int counter = 0;
    public FacebookConnector() {
        try {
            fbClient = new DefaultFacebookClient(pageAccessToken);
            myuser = fbClient.fetchObject("me", User.class);
            mypage = fbClient.fetchObject(pageID, Page.class);
            jsonResults = fbClient.fetchObjects(Arrays.asList("me", "123456789"), 
                    JsonObject.class, Parameter.with("fields","name,id"));
            
            
            counter = 0;
        } catch (FacebookException ex) {     //So that you can see what went wrong
            ex.printStackTrace(System.err);  //in case you did anything incorrectly
        }
    }
    
    public void getNameAndId() {
    	System.out.println(myuser.getLastName());
    	System.out.println(mypage.getAbout());
        System.out.println(myuser.getGender());
    	    	
    	
    }
    
    
    public void getPosts() {
    	Connection<Post> postFeed = fbClient.fetchConnection(mypage.getId()+"/feed", Post.class);
       // Connection<Post> pageFeed = client.fetchConnection(page.getId() + "/feed", Post.class);
    	  //Post apost = new Post();
    	for (List<Post> postPage : postFeed) {
    		for (Post aPost : postPage) {
        		System.out.println(aPost.getFrom().getName());
        		System.out.println("-->"+ aPost.getMessage());
        		System.out.println("fb.com/" + aPost.getId());
                        System.out.println("commentaire : " + aPost.getComments());
        		
        		System.out.println();
        		
        		
        	}
    	}
        
        /*for (List<Post> feed : postFeed){
                        for (Post post : feed){     
                             //PRINTING THE POST 
                             
                        }
                   }*/
        
        /*while (postFeed.hasNext()) {
            
            postFeed = fbClient.fetchConnectionPage(postFeed.getNextPageUrl(),Post.class);
            System.out.println(mypage.getName() + " --> " + mypage.getLikes());
        }*/
    }
    
    public static class FqlPost {
    @Facebook("post_id")
    String post_id;

    @Facebook("created_time")
    String created_time;

    @Override
    public String toString() {
        return String.format("%s,%s", post_id, created_time);
    }
}

    
    public void makeTestPost() {
        fbClient.publish(pageID + "/feed", FacebookType.class, Parameter.with("message", Integer.toString(counter) + ": Hello, facebook World!"));
        counter++;
    }
}
