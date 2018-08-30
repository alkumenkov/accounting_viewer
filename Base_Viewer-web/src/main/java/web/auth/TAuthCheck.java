/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.auth;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author wellington
 */
public class TAuthCheck {
    
    public static final String AUTHTAG="authtag";

    protected String fUserName="";
    protected boolean fCheckPassed=false;
    protected String fCurrCookieValue = "";
    
    
    public TAuthCheck( HttpServletRequest request ){
        Cookie[] lCooks = request.getCookies();
        
        if( !identificateByCookie( request.getCookies() ) ){
            boolean lPassIdentificated = identificateByPassword( request.getParameter( "login" ), request.getParameter( "pass" ) );
            if( lPassIdentificated ){
                fCheckPassed = true;
            }
        }
    }
  
    private boolean identificateByCookie( Cookie[] lCooks ){
      
        return false;
    }
    
    private boolean identificateByPassword( String lUser, String lPass ){
        return false;
    }
    
    public String getCookieValue(){
        return fCurrCookieValue;
    }
        
    public boolean checkPassed(){
        return fCheckPassed;
    }
   
}
