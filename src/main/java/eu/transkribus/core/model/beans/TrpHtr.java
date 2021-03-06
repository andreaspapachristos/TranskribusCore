package eu.transkribus.core.model.beans;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.transkribus.core.util.CoreUtils;
import eu.transkribus.core.util.HtrCITlabUtils;

@Entity
@Table(name = "HTR")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TrpHtr {
	private static final Logger logger = LoggerFactory.getLogger(TrpHtr.class);
	
	@Id
	@Column(name="HTR_ID")
	private int htrId;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private String provider;
	
	/**
	 * path is better created from HTR ID and DbServiceName
	 */
	@XmlTransient
	@Column
	private String path;
	
	@Column
	private Timestamp created;
	
	@Column(name="TRAIN_GT_DOCID")
	private Integer gtDocId;
	
	@Column(name="TEST_GT_DOCID")
	private Integer testGtDocId;
	
	@Column(name="LANGUAGE")
	private String language;
	
	@Column(name="BASE_HTR_ID")
	private Integer baseHtrId;
	
	@Column(name="TRAIN_JOB_ID")
	private String trainJobId;
	
	@Column(name="TRAIN_CER_SERIES")
	private String cerString;
	
	@Column(name="TEST_CER_SERIES")
	private String cerTestString;
	
	/**
	 * Contains the CITlab specific char-to-channel mapping
	 */
	@Deprecated
	private String charList;
	
	@Column(name="CHARSET")
	private String charSetString;
	
	@Column(name="HAS_BEST_NET")
	private boolean bestNetStored = true;
	
	@Column(name="HAS_LANGUAGE_MODEL")
	private boolean languageModelExists = false;
	
	@Column(name="NR_OF_LINES")
	private int nrOfLines;
	
	@Column(name="NR_OF_WORDS")
	private int nrOfWords;
	
	@Column(name="PARAMS")
	private String params;
	
	@Transient
	@Column
	private String userName;
	
	@Transient
	@Column
	private int userId;
	
	//those fields just cache the split result from cerString and cerTestString
	private double[] cerLog = null;
	private double[] cerTestLog = null;

	public int getHtrId() {
		return htrId;
	}

	public void setHtrId(int htrId) {
		this.htrId = htrId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Integer getGtDocId() {
		return gtDocId;
	}

	public void setGtDocId(Integer gtDocId) {
		this.gtDocId = gtDocId;
	}
	
	public Integer getTestGtDocId() {
		return testGtDocId;
	}

	public void setTestGtDocId(Integer testGtDocId) {
		this.testGtDocId = testGtDocId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getBaseHtrId() {
		return baseHtrId;
	}

	public void setBaseHtrId(Integer baseHtrId) {
		this.baseHtrId = baseHtrId;
	}
	
	public String getTrainJobId() {
		return trainJobId;
	}

	public void setTrainJobId(String trainJobId) {
		this.trainJobId = trainJobId;
	}
	
	public String getCerString() {
		return cerString;
	}

	public void setCerString(String cerLogString) {
		this.cerString = cerLogString;
	}
	
	public String getCerTestString() {
		return cerTestString;
	}

	public void setCerTestString(String cerTestLogString) {
		this.cerTestString = cerTestLogString;
	}
	
	/**
	 * CITlab specific charmap string. needed by GUI versions &lt; 1.5<br>
	 * Channel mapping may not match the actual one! So do not use this for HTR.
	 */
	@Deprecated
	public String getCharList() {
		return charList;
	}
	
	/**
	 * CITlab specific charmap string. needed by GUI versions &lt; 1.5
	 */
	@Deprecated
	public void setCharList(String charList) {
		this.charList = charList;
	}
	
	/**
	 * Fake the CITlab syntax on the basis of what is stored in DB. needed by GUI versions &lt; 1.5<br>
	 * Channel mapping may not match the actual one! So do not use this for HTR.
	 * 
	 * @return
	 */
	@Deprecated
	private String createCharList() {
		int i = 1;
		String charListStr = "";
		for(String s : getCharSetList()) {
			charListStr += s + "=" + i + "\n";
		}
		return charListStr.trim();
	}
	
	public String getCharSetString() {
		return charSetString;
	}

	public void setCharSetString(String charSet) {
		this.charList = createCharList();
		this.charSetString = charSet;
	}
	
	public List<String> getCharSetList() {
		if(StringUtils.isEmpty(charSetString)) {
			return new ArrayList<>();
		}
		return Arrays.asList(charSetString.split("\n"));
	}

	public boolean isBestNetStored() {
		return bestNetStored;
	}

	public void setBestNetStored(boolean bestNetStored) {
		this.bestNetStored = bestNetStored;
	}

	public boolean isLanguageModelExists() {
		return languageModelExists;
	}

	public void setLanguageModelExists(boolean dictionaryExists) {
		this.languageModelExists = dictionaryExists;
	}

	public String getParams() {
		return params;
	}
	
	public Properties getParamsProps() {
		if(params == null || params.isEmpty()) {
			return new Properties();
		}
		try {
			return CoreUtils.readPropertiesFromString(params);
		} catch (IOException ioe) {
			logger.error("Could nor read Properties from String:\n" + params);
			return new Properties();
		}
	}
	
	public void setParams(String params) {
		this.params = params;
	}

	public int getNrOfLines() {
		return nrOfLines;
	}

	public void setNrOfLines(int nrOfLines) {
		this.nrOfLines = nrOfLines;
	}

	public int getNrOfWords() {
		return nrOfWords;
	}

	public void setNrOfWords(int nrOfWords) {
		this.nrOfWords = nrOfWords;
	}
	
	public double[] getCerLog() {
		if(cerLog == null) {
			cerLog = HtrCITlabUtils.parseCitlabCerString(cerString);
		}
		return cerLog;
	}
	
	public double[] getCerTestLog() {
		if(cerTestLog == null) {
			cerTestLog = HtrCITlabUtils.parseCitlabCerString(cerTestString);
		}
		return cerTestLog;
	}
	
	public double getFinalTrainCerVal() {
		if(!hasCerLog()) {
			return -1;
		}
		return getCerLog()[getCerLog().length-1];
	}
	
	public boolean hasCerLog() {
		return cerString != null && !cerString.isEmpty();
	}

	public boolean hasCerTestLog() {
		return cerTestString != null && !cerTestString.isEmpty();
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "TrpHtr [htrId=" + htrId + ", name=" + name + ", description=" + description + ", provider=" + provider
				+ ", path=" + path + ", created=" + created + ", gtDocId=" + gtDocId + ", testGtDocId=" + testGtDocId
				+ ", language=" + language + ", baseHtrId=" + baseHtrId + ", trainJobId=" + trainJobId + ", cerString="
				+ cerString + ", cerTestString=" + cerTestString + ", charSet=" + charSetString
				+ ", bestNetStored=" + bestNetStored + ", nrOfLines=" + nrOfLines + ", nrOfWords=" + nrOfWords
				+ ", params=" + params + ", userName=" + userName + ", userId=" + userId + ", cerLog="
				+ Arrays.toString(cerLog) + ", cerTestLog=" + Arrays.toString(cerTestLog) + "]";
	}
	
}
