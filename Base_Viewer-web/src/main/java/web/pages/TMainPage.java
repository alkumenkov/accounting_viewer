/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.pages;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author wellington
 */
public class TMainPage extends TAbstractPage{

    @Override
    public String generateResponse( HttpServletRequest request ) {
        Format format = new SimpleDateFormat("yyyy-MM-dd");
        Date lCurrDate = new Date();
        Date lPrevDate = new Date( lCurrDate.getTime()-1000*60*60*24 );
        String lDate = format.format( lCurrDate );
        String lPrDate = format.format( lPrevDate );
        
        String lContent =  "<!DOCTYPE html><html><head><title>Start Page</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head>";
        lContent+="<body>";
        lContent+="<div align='center'>";
        lContent+="<img src='/protopype.png' />";
        lContent+=TUserForm.getFormBody(new TUserForm() );
        lContent+="</div>";
        lContent+="</body></html>";
        return lContent;
    }
    
}
