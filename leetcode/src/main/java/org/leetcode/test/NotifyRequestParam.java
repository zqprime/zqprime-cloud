package org.leetcode.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotifyRequestParam {

	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("create_time")
	private String createTime;
	
	@JsonProperty("event_type")
	private String eventType;
	
	@JsonProperty("resource_type")
	private String resourceType;
	
	@JsonProperty("resource")
	private Resource resource;
	
	private String decryptData;
	    
	@JsonIgnoreProperties(ignoreUnknown = true)
    public class Resource {

        @JsonProperty("algorithm")
        private String algorithm;
        @JsonProperty("ciphertext")
        private String ciphertext;
        @JsonProperty("associated_data")
        private String associatedData;
        @JsonProperty("nonce")
        private String nonce;
        @JsonProperty("original_type")
        private String originalType;

        public String getAlgorithm() {
            return algorithm;
        }

        public String getCiphertext() {
            return ciphertext;
        }

        public String getAssociatedData() {
            return associatedData;
        }

        public String getNonce() {
            return nonce;
        }

        public String getOriginalType() {
            return originalType;
        }

		public void setAlgorithm(String algorithm) {
			this.algorithm = algorithm;
		}

		public void setCiphertext(String ciphertext) {
			this.ciphertext = ciphertext;
		}

		public void setAssociatedData(String associatedData) {
			this.associatedData = associatedData;
		}

		public void setNonce(String nonce) {
			this.nonce = nonce;
		}

		public void setOriginalType(String originalType) {
			this.originalType = originalType;
		}

		@Override
        public String toString() {
            return "Resource{" +
                    "algorithm='" + algorithm + '\'' +
                    ", ciphertext='" + ciphertext + '\'' +
                    ", associatedData='" + associatedData + '\'' +
                    ", nonce='" + nonce + '\'' +
                    ", originalType='" + originalType + '\'' +
                    '}';
        }
    }
	
	@Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", createTime='" + createTime + '\'' +
                ", eventType='" + eventType + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", decryptData='" + decryptData + '\'' +
                ", resource=" + resource +
                '}';
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public String getDecryptData() {
		return decryptData;
	}

	public void setDecryptData(String decryptData) {
		this.decryptData = decryptData;
	}
	
}