package com.bootdo.common.annotation;

import com.bootdo.common.utils.StringUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class CodeTableSerialize extends StdSerializer<String>{
	Logger logger = LoggerFactory.getLogger(CodeTableSerialize.class);
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CodeTableSerialize(){
    	this(null);
    }
	public CodeTableSerialize(Class<String> s) {
		super(s);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void serialize(String paramT,
			JsonGenerator paramJsonGenerator,
			SerializerProvider paramSerializerProvider) throws IOException,
			JsonProcessingException {
		if (!StringUtils.isEmpty(paramT)) {
			paramJsonGenerator.writeString("");
		}else{

//			Map<String, Map<String, CodeTable>> map =  (Map<String, Map<String, CodeTable>>) JedisUtil.get( LoanContants.CODETYPE_CHACHE_NAME,LoanContants.CONTEXT_PARAM_CODE_TABLE);
//			String key=paramJsonGenerator.getOutputContext().getCurrentName();
//			String value = "";
//			try {
//				key=paramJsonGenerator.getOutputContext().getCurrentValue().getClass().getDeclaredField(key).getAnnotation(CodeTypeAnnotation.class).codeType();
//				if (map.containsKey(key)) {
//					Map<String,CodeTable> codeMap = map.get(key);
//					value = Arrays.stream(paramT.split(","))
//							.map(t -> codeMap.get(t) == null ? t:codeMap.get(t).getCodeValue()).collect(Collectors.joining(","));
//				}
//			} catch (NoSuchFieldException e) {
//				logger.error("key",e);
//			} catch (SecurityException e) {
//				e.printStackTrace();
//			}
//			if (StringUtils.isNullOrEmpty(value)) {
//				value=paramT;
//			}
//			paramJsonGenerator.writeString(value);
		}
	}

}
