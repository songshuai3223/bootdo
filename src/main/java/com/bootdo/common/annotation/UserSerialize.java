package com.bootdo.common.annotation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class UserSerialize extends StdSerializer<Long>{
	Logger logger = LoggerFactory.getLogger(UserSerialize.class);
    /**
	 *
	 */

	private static final long serialVersionUID = 1L;
	public UserSerialize(){
    	this(null);
    }
	public UserSerialize(Class<Long> s) {
		super(s);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void serialize(Long paramT,
			JsonGenerator paramJsonGenerator,
			SerializerProvider paramSerializerProvider) throws IOException{
		if (paramT==null) {
			paramJsonGenerator.writeString("");
		}else{
//			User user=(User)JedisUtil.get(LoanContants.USER_CHACHE_NAME,paramT.toString());
//			if(null==user){
//				UserMapper userMapper= (UserMapper) SpringBeanLoader.getBean("userMapper");
//				user=userMapper.selectByUserNum(paramT.toString());
//				if(null==user){
//					paramJsonGenerator.writeString("");
//				}
//				else {
//					paramJsonGenerator.writeString(user.getUserName());
//				}
//			}else {
//				paramJsonGenerator.writeString(user.getUserName());
//			}

		}
	}

}
