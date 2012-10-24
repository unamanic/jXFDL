/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jxfdl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import jxfdl.utils.Base64GZip;
import sun.misc.BASE64Decoder;

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
      
      StringBuffer formXML = new StringBuffer();

      //purge header info
      for (int i = 0; i < 52; i++) {
        header += (char)fis.read();
      }
      
      InputStream processed = Base64GZip.B64GzipToInputStream(fis);

      int c = 0;
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
