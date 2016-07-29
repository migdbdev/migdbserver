package org.migdb.migdbserver.main.resources;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CollectionStructureJSON {
	
	private String jsonContent;

	public String getJsonContent() {
		return jsonContent;
	}

	public void setJsonContent(String jsonContent) {
		this.jsonContent = jsonContent;
	}

}
