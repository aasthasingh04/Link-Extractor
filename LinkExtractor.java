import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class LinkExtractor {

    

    public void Links(String webSiteUrl,String search,String Extension,String FILENAME) throws IOException {
    	BufferedWriter bw = null;
		FileWriter fw = null;
		fw = new FileWriter(FILENAME,true);
		bw = new BufferedWriter(fw);
        try {
        	
        	
			
            //Connect to the website and get the html
            Document doc = Jsoup.connect(webSiteUrl).get();

            //Get all elements with href tag ,
            Elements linksOnPage = doc.select("a[href]");
           
            for(Element link : linksOnPage)
            {
            	if(link.absUrl("href").toLowerCase().contains(search.toLowerCase())&&link.absUrl("href").toLowerCase().contains(Extension.toLowerCase()))
            		{
            		bw.write(link.absUrl("href"));
            		bw.write("\n");
            		
            		}
            }
               

            bw.close();

        } catch (IOException ex) {
            System.err.println("There was an error");
            Logger.getLogger(LinkExtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

    

    