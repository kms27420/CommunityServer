package com.kms.communityserver.model.response;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ResponseTO {
	private String code;
	private Object data;
	private String message;
	
	public ResponseTO() {}
	public ResponseTO(String code, String message) {
		this(code, null, message);
	}
	public ResponseTO(String code, Object data, String message) {
		setCode(code);
		setData(data);
		setMessage(message);
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public final Map<String, Object> convertToMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		for(Method m : getClass().getMethods()) {
			if(m.getName().substring(0, 3).equals("get") && !m.getName().equals("getClass")) {
				try {
					map.put(m.getName().substring(3).substring(0,1).toLowerCase()+m.getName().substring(4), m.invoke(this));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}
}
