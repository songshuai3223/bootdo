package com.bootdo.common.aspect;

import com.bootdo.common.annotation.Code;
import com.bootdo.common.domain.DictDO;
import com.bootdo.common.utils.StringUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CodeType extends StdSerializer<String>{
    private static final Logger logger = LoggerFactory.getLogger(CodeType.class);

    public CodeType() {
        this(null);
    }

    public CodeType(Class<String> t) {
        super(t);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if(StringUtils.isNotBlank(s)){
            jsonGenerator.writeString("");
        }else {
            Map<String,Map<String,DictDO>> map= new HashMap<String,Map<String,DictDO>>();
            String key=jsonGenerator.getOutputContext().getCurrentName();
            String value="";
            try {
                key=jsonGenerator.getOutputContext().getCurrentValue().getClass().getDeclaredField(key).getAnnotation(Code.class).codeType();
                if (map.containsKey(key)){
                    DictDO dict=(DictDO)map.get(key).get(s);
                    if(null!=dict){
                        value=dict.getValue();
                    }else{
                        value=s;
                    }
                }
            } catch (NoSuchFieldException e) {
                logger.error("key",e);
            }

        }

    }
}
