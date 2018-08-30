/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.pages;

import com.alk.accounttools.reporting.TDealsReport;
import com.alk.webtools.TTableTools;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author wellington
 */
public class TTradesPage extends TAbstractPage{

    @Override
    public String generateResponse(HttpServletRequest request) {
        
        TUserForm lForm = new TUserForm( request );
        return getTradesContent( lForm );
    }
    
    private static String getTradesContent( TUserForm aForm ){
        String lContent =  "<!DOCTYPE html><html><head><title>Start Page</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head>";
            lContent+="<body>";
            lContent+="<div align='center'>";
            lContent+="<img src='/protopype.png' />";
            String[][] lTradesReport = null;
            
            if( aForm.isCumulative() ){
                lTradesReport = TDealsReport.getCumulativeDeals(aForm.getFrom(), aForm.getTo(), aForm.getAccount() );
            }
            
            if( lTradesReport != null ){
                lContent += TTableTools.generateHtmlTable( lTradesReport ); 
            }
            
            lContent+="<br>";
            lContent+=TUserForm.getFormBody( aForm );
            lContent+="</div>";
            lContent+="</body></html>";
        return lContent;
    }
}
