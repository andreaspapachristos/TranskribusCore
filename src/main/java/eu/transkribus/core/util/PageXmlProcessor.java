package eu.transkribus.core.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactoryConfigurationException;

import org.apache.commons.lang3.StringUtils;
import org.dea.fimgstoreclient.utils.FimgStoreUriBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import eu.transkribus.core.io.FimgStoreReadConnection;
import eu.transkribus.core.util.xpath.TrpXPathProcessor;

/**
 * Equivalent to {@link PageXmlUtils} but relying on org.w3c.dom.Document and XPath instead of JaxB.<br/>
 * Use {@link PageXmlProcessorFactory} to get an instance of this.
 * 
 * @author philip
 *
 */
public abstract class PageXmlProcessor extends TrpXPathProcessor {
	private static final Logger logger = LoggerFactory.getLogger(PageXmlProcessor.class);

	protected final FimgStoreUriBuilder uriBuilder;
	
	protected final Map<String, Document> docCache;

	public PageXmlProcessor() throws XPathFactoryConfigurationException, ParserConfigurationException {
		this(DEFAULT_DOC_BUILDER_FACTORY_IMPL, DEFAULT_XPATH_FACTORY_IMPL);
	}
	
	public PageXmlProcessor(DocBuilderFactoryImpl docBuilderFactoryImpl, XPathFactoryImpl xPathFactoryImpl)
			throws XPathFactoryConfigurationException, ParserConfigurationException {
		this(docBuilderFactoryImpl.getClassName(), xPathFactoryImpl.getClassName());
	}
	
	public PageXmlProcessor(String docBuilderFactoryImpl, String xPathFactoryImpl)
			throws XPathFactoryConfigurationException, ParserConfigurationException {
		super(docBuilderFactoryImpl, xPathFactoryImpl);
		uriBuilder = FimgStoreReadConnection.getUriBuilder();
		docCache = new HashMap<>();
	}
	
	/**
	 * Retrieves the XML identified by this xmlKey as {@link org.w3c.dom.Document} from the storage system.<br/>
	 * Use {@link #getDocument(String)} instead, as it calls this method and imeplements caching.
	 * 
	 * @param xmlKey
	 * @return
	 * @throws MalformedURLException
	 * @throws IllegalArgumentException
	 * @throws SAXException
	 * @throws IOException
	 */
	protected abstract Document loadDocument(final String xmlKey) throws MalformedURLException, IllegalArgumentException, SAXException, IOException;
	
	/**
	 * Retrieves the file identified by this key and returns a {@link org.w3c.dom.Document}<br/>
	 * Implements caching.
	 * 
	 * @param xmlKey
	 * @return
	 * @throws MalformedURLException
	 * @throws IllegalArgumentException
	 * @throws SAXException
	 * @throws IOException
	 */
	public Document getDocument(final String xmlKey) throws MalformedURLException, IllegalArgumentException, SAXException, IOException {
		final Document doc;
		if(docCache.containsKey(xmlKey)) {
			doc = docCache.get(xmlKey);
		} else {
			doc = loadDocument(xmlKey);
			docCache.put(xmlKey, doc);
		}
		return doc;
	}
	
		
	
	public Node getLineById(final String xmlKey, final String lineId) throws MalformedURLException, IllegalArgumentException, SAXException, IOException, XPathExpressionException {
		Document doc = getDocument(xmlKey);
		return getLineById(doc, lineId);
	}
	
	public Node getLineById(final Document doc, final String lineId) throws XPathExpressionException, SAXException, IOException {
		final String xPath = "//TextLine[@id='" + lineId + "']";
		XPathExpression exp = super.compile(xPath);
		return super.getNode(doc, exp);
	}

	public List<String> getAllLineIds(final String xmlKey) throws MalformedURLException, IllegalArgumentException, SAXException, IOException, XPathExpressionException {
		Document doc = getDocument(xmlKey);
		final String xPath = "//TextLine";
		XPathExpression exp = super.compile(xPath);
		NodeList lines = super.getNodeList(doc, exp);
		List<String> ids = new ArrayList<>(lines.getLength());
		for(int i = 0; i < lines.getLength(); i++) {
			final String id = lines.item(i)
					.getAttributes()
					.getNamedItem("id")
					.getTextContent();
			if(StringUtils.isEmpty(id)) {
				logger.error("A line ID is empty!");
			} else {
				ids.add(id);
			}
		}
		return ids;
	}
	
	public List<String> getLineIdsByRegion(final String xmlKey, final String regionId) throws MalformedURLException, IllegalArgumentException, SAXException, IOException, XPathExpressionException {
		NodeList lines = getLinesByRegion(xmlKey, regionId);
		List<String> ids = new ArrayList<>(lines.getLength());
		for(int i = 0; i < lines.getLength(); i++) {
			final String id = lines.item(i)
					.getAttributes()
					.getNamedItem("id")
					.getTextContent();
			if(StringUtils.isEmpty(id)) {
				logger.error("A line ID is empty in region: " + regionId);
			} else {
				ids.add(id);
			}
		}
		return ids;
	}
	
	public NodeList getLinesByRegion(final String xmlKey, final String regionId) throws MalformedURLException, IllegalArgumentException, SAXException, IOException, XPathExpressionException {
		Document doc = getDocument(xmlKey);
		final String xPath = "//TextRegion[@id='" + regionId + "']/TextLine";
		XPathExpression exp = super.compile(xPath);
		return super.getNodeList(doc, exp);
	}
}
