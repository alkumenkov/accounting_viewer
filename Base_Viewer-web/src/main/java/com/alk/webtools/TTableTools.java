/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alk.webtools;

/**
 *
 * @author wellington
 */
public class TTableTools {
    
    public static String generateHtmlTable( String[][] aArray ){
        String oResuilt="";
        oResuilt += "<table border=\"1\">";
        if( aArray.length > 0 ){
            for( int i=0; i<aArray.length; i++ ){
                if( aArray.length == 1 ){
                    oResuilt += generateTableRow( aArray[i], true );
                } else {
                    oResuilt += generateTableRow( aArray[i], false );
                }
            }
        }
        oResuilt += "</table>";
        return oResuilt;
    }
    
    private static String generateTableRow( String[] aRowData, boolean aIsHeader ){
        String oRes = "";
        if( aRowData != null ){
            oRes += "<tr>";
            if( !aIsHeader ){
                for( int i=0; i < aRowData.length; i++ ){
                    oRes += "<td>";
                    oRes += aRowData[ i ];
                    oRes += "</td>";
                }
            } else {
                for( int i=0; i < aRowData.length; i++ ){
                    oRes += "<th>";
                    oRes += aRowData[ i ];
                    oRes += "</th>";
                }
            }
            oRes += "</tr>";
        }
        return oRes;
    }
    
}
