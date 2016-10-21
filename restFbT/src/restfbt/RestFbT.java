/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restfbt;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;

/**
 *
 * @author Yacine
 */
public class RestFbT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FacebookConnector fb = new FacebookConnector();
		fb.getNameAndId();
                fb.getPosts();
        
        /*FacebookClient fbc = new DefaultFacebookClient("EAACEdEose0cBAA3vbFcOfHn6JBQmi87Rf2QWUBeLUIf4T7KBBMiQAaWatGAWZAuGunExAlZBujaO3deSZAeLL0eTmYEcjvNhwHPZCYGZCCf7zqF6qLQ61gC858Ov1xwT9PkQGJWZClL9ZCWxy2kJynRGZA7ZCV2ykGw3gLT2I1RFEggZDZD");
        FacebookType publishMessageResponse = fbc.publish("me/feed",FacebookType.class,Parameter.with("message","Hello Fb. Sent from an app :)"));*/
    }
    
}
