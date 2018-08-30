/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.pages;

import com.alk.accounttools.reporting.TDBaseContent;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author wellington
 */
public class TUserForm {
    
    public static class METHODS{ 
        public static final String GET_SUMMARY="get_summary";
        public static final String GET_TRADES="get_tades";
    }
    
    private String fFrom;
    private String fTo;
    private String fAccount;
    private String fCurrency;
    private boolean IsAdvanced;
    private boolean IsCumulative;
    
    public TUserForm( HttpServletRequest request ){
        
        fFrom = request.getParameter("from");
        fTo = request.getParameter("to");
        String lAccount = request.getParameter("acc");
        fAccount = lAccount.equals("not set")?"andrew":lAccount;
        String lCurrency = request.getParameter("currency");
        fCurrency = lCurrency.equals("not set")?"USDT":lCurrency;
        IsAdvanced = ( request.getParameter("advanced") != null );
        IsCumulative = ( request.getParameter("cumulative") != null );
        
    }
    
    public TUserForm(){
        
        Format format = new SimpleDateFormat("yyyy-MM-dd");
        Date lCurrDate = new Date();
        Date lPrevDate = new Date( lCurrDate.getTime()-1000*60*60*24 );
        String lDate = format.format( lCurrDate );
        String lPrDate = format.format( lPrevDate );
        
        fFrom = lPrDate;
        fTo = lDate;
        fAccount = "not set";
        fCurrency = "not set";
        IsAdvanced = false;
        IsCumulative = false;
    }
    
    public String getFrom() {
        return fFrom;
    }

    public String getTo() {
        return fTo;
    }

    public String getAccount() {
        return fAccount;
    }

    public String getCurrency() {
        return fCurrency;
    }

    public boolean isAdvanced() {
        return IsAdvanced;
    }

    public boolean isCumulative() {
        return IsCumulative;
    }
  
    static String getFormBody( TUserForm aForm ){
        String  lContent = "";
        lContent+="<form action=\"/Summary\" method='post'>\n" +
                    "  From:\n" +
                    "  <input type=\"date\" name=\"from\" value='"+aForm.getFrom()+"'>\n" +
                    "  <br><br>\n" +
                    "  To:\n" +
                    "  <input type=\"date\" name=\"to\" value='"+aForm.getTo()+"'>\n" +
                    "  <br><br>\n" +
                    "  Account:\n" +
                    "   <select name=\"acc\">\n";
        
        String [] lAccounts = TDBaseContent.getInstance().getAccounts();
        
        System.out.println( Arrays.toString( lAccounts ) );
        
        if( lAccounts != null ){
            lContent += getSelectContent(lAccounts, aForm.getAccount());
        }
        
        lContent+=  "</select>\n" + 
                    "<br><br>\n" +
                    "Currency:\n" +
                    "<select name=\"currency\">\n";
                
        String [] lCurrencies = TDBaseContent.getInstance().getCurrencies(); 
        if( lCurrencies != null ){
            lContent += getSelectContent( lCurrencies, aForm.getCurrency() );
        }
                    
        lContent += "</select><br><br>\n" +
                    "<div>\n" +
                    "<input type=\"submit\" name='" + METHODS.GET_SUMMARY + "' value=\"get summary\">\n" +
                    "<input type=\"checkbox\" name=\"advanced\" " + ( aForm.isAdvanced() ? "checked" : "" ) + ">advanced"+
                    "</div><br><br>"+
                    "<div>\n" +
                    "<input type=\"submit\" name='" + METHODS.GET_TRADES + "' value=\"get trades\">\n" +
                    "<input type=\"checkbox\" name=\"cumulative\" " + ( aForm.isCumulative() ? "checked" : "" ) + ">cumulative"+
                    "</div>" +
                    "</form>";
        return lContent;
    }
    
    private static String getSelectContent( String[] aContent, String aDefVal ){
        String oRes="";
        oRes+="<option value=\""+aDefVal+"\">"+aDefVal+"</option>";
        if( aContent.length > 1 ){
            for(int i=1; i<aContent.length; i++){
                oRes+="<option value=\""+aContent[i]+"\">"+aContent[i]+"</option>";
            }
        }
        
        return oRes;
    }
}
