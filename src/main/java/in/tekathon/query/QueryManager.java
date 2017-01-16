package in.tekathon.query;

import java.util.Iterator;
import javax.xml.bind.JAXBException;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.tree.xpath.XPathExpressionEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryManager {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Get query from queries.xml
     *
     * @throws JAXBException
     */
    public String getQuery(String controllerName, String queryName) throws JAXBException {
        String query = "";
        try {
            String filename = "queries.xml";
            CompositeConfiguration compositeConfiguration = new CompositeConfiguration();
            XMLConfiguration xmlConfig = new XMLConfiguration();
            xmlConfig.setDelimiterParsingDisabled(true);
            xmlConfig.setExpressionEngine(new XPathExpressionEngine());
            xmlConfig.load(filename);
            compositeConfiguration.addConfiguration(xmlConfig);

            Iterator<String> keys = compositeConfiguration.getKeys();

            while (keys.hasNext()) {
                String next = keys.next();
                System.out.println("Keys : " + next);
            }

            query = getQueryByName(compositeConfiguration, controllerName, queryName);
            System.out.println("string = " + query);
            return query;

        } catch (Exception e) {
            e.printStackTrace();
            LoggerFactory.getLogger(QueryManager.class).error("Exception : " + e);
        }
        return null;
    }

    private static String getQueryByName(CompositeConfiguration compositeConfiguration, String controllerName, String queryName) {
        String query = "";
        try {
            query = compositeConfiguration.getString("controller[@name='" + controllerName + "']/query[@name='" + queryName + "']/sql");
        } catch (Exception e) {
            e.getMessage();
            LoggerFactory.getLogger(QueryManager.class).error("Exception : " + e);
        }

        return query;
    }

    public static void main(String args[]) throws JAXBException {
        QueryManager manager = new QueryManager();
        manager.getQuery("", "");
    }

}
