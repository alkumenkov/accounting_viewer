/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.pages;

import com.alk.accounttools.reporting.TSummaryReport;
import com.alk.webtools.TTableTools;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author wellington
 */
public class TSummaryPage extends TAbstractPage {

    @Override
    public String generateResponse( HttpServletRequest request ) {
       
        TUserForm lForm = new TUserForm( request );
        
        return getSummaryContent( lForm );
        
    }
    
    private static String getSummaryContent( TUserForm aForm ){
        String lContent =  "<!DOCTYPE html><html><head><title>Start Page</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head>";
            lContent+="<body>";
            lContent+="<div align='center'>";
            lContent+="<img src='/protopype.png' />";
            String[][] lDeltaReport = null;
            if( !aForm.isAdvanced() ){
                lDeltaReport = TSummaryReport.getSimpleDelta( aForm.getFrom(), aForm.getTo(), aForm.getAccount(), aForm.getCurrency() );
            }else {
                lDeltaReport = TSummaryReport.getAdvancedDelta( aForm.getFrom(), aForm.getTo(), aForm.getAccount(), aForm.getCurrency() );
            }
            
            if( lDeltaReport != null ){
                lContent += TTableTools.generateHtmlTable( lDeltaReport ); 
            }
            
            lContent+="<br>";
            lContent+=TUserForm.getFormBody( aForm );
            lContent+="</div>";
            lContent+="</body></html>";
        return lContent;
    }
    
}
