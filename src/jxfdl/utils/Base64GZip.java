/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jxfdl.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import org.apache.commons.codec.binary.Base64InputStream;

/**
 *
 * @author unamanic
 */
public class Base64GZip {

  public static InputStream B64GzipToInputStream(InputStream is) {
    try {
      InputStream decoded = new Base64InputStream(is);
      
      InputStream gzip = new GZIPInputStream(decoded);
      return gzip;
    } catch (IOException ex) {
      Logger.getLogger(Base64GZip.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
  
  
}
