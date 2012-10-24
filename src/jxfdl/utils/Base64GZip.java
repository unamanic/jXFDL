/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jxfdl.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import sun.misc.BASE64Decoder;

/**
 *
 * @author unamanic
 */
public class Base64GZip {

  public static InputStream B64GzipToInputStream(InputStream is) {
    ByteArrayInputStream decoded = null;
    try {
      BASE64Decoder b64 = new BASE64Decoder();
      decoded = new ByteArrayInputStream(b64.decodeBuffer(is));
      GZIPInputStream gzip = new GZIPInputStream(decoded);
      return gzip;
    } catch (IOException ex) {
      Logger.getLogger(Base64GZip.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
  
  
}
