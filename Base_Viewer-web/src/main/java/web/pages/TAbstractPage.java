/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.pages;

import web.*;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author wellington
 */
public abstract class TAbstractPage {
    
    protected final String DO = "do";
    
    public abstract String generateResponse( HttpServletRequest request );
    
}
