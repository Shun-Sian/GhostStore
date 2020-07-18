package models;

public class Response {

	private String key;
	private Object body;
	
	public Response(String key,Object body) {
		this.key = key;
		this.body = body;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

}
