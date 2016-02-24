package eu.transkribus.core.model.beans;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import eu.transkribus.core.model.beans.pagecontent.PcGtsType;
import eu.transkribus.core.model.beans.pagecontent_trp.TrpPageType;
import eu.transkribus.core.util.PageXmlUtils;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class JAXBPageTranscript extends AbstractPageTranscript<PcGtsType> {
	public JAXBPageTranscript(){}
	
	public JAXBPageTranscript(TrpTranscriptMetadata md) {
		this.setMd(md);
	}
	
	public JAXBPageTranscript(TrpTranscriptMetadata md, PcGtsType pageData) {
		this(md);
		
//		if (pageData == null) {
//			throw new IllegalArgumentException("pageData is null");
//		}
		this.setPageData(pageData);
	}
	
	@Override public void setMd(TrpTranscriptMetadata md) {
		super.setMd(md);
		updateMdOnPage();
	}
		
	@Override public void setPageData(PcGtsType page) {
		super.setPageData(page);
		updateMdOnPage();
	}
	
	void updateMdOnPage() {
		TrpPageType p = getPage();
		if (p!=null)
			p.setMd(md);
	}
	
//	public BorderType getBorder() {
//		return this.pageData.getPage().getBorder();
//	}
	
	public TrpPageType getPage() {
		if (pageData != null)
			return (TrpPageType) this.pageData.getPage();
		else 
			return null;
	}
		
//	public TrpPrintSpaceType getPrintSpace() {
//		if (pageData != null)
//			return (TrpPrintSpaceType) pageData.getPage().getPrintSpace();
//		else
//			return null;
//	}
	
//	public void build() throws JAXBException, IOException {
//		if (md != null) {
//			JAXBPageTranscript tr = TrpPageTranscriptBuilder.build(md);
//			setPageData(tr.getPageData());
//		}
//	}
	
	public void build() throws IOException {
		if (md == null)
			throw new IOException("Metadata is null!");
		
		PcGtsType pageData;
		if (md.getUrl()!=null) {
			try {
				pageData = PageXmlUtils.unmarshal(md.getUrl());
			} catch (JAXBException e) {
				throw new IOException(e);
			}
		}
		else
			pageData = PageXmlUtils.createEmptyPcGtsType(md.getPagePageReferenceForLocalDocs().getUrl());
		
		setPageData(pageData);
	}
}
