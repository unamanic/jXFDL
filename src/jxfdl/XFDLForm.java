/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jxfdl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import jxfdl.utils.Base64GZip;

/**
 *
 * @author unamanic
 */
public class XFDLForm {

  private String formXMLString;
  private String header  = "";

  public XFDLForm(File fileIn) {
    try {

      FileInputStream fis = new FileInputStream(fileIn);
      
      StringBuilder formXML = new StringBuilder();

      //purge header info
      for (int i = 0; i < 52; i++) {
        header += (char)fis.read();
      }
      
      InputStream processed = Base64GZip.B64GzipToInputStream(fis);

      int c;
      while ((c = processed.read()) != -1) {
        formXML.append((char) c);
      }
      
      formXMLString = formXML.toString();

      fis.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String getFormXMLString() {
    return formXMLString;
  }

  public String getHeader() {
    return header;
  }
  
  
}
