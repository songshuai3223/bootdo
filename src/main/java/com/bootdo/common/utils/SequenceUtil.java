package com.bootdo.common.utils;



import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by gcb on 2018-3-13.
 */
public class SequenceUtil {
    private  static Logger logger= LoggerFactory.getLogger(SequenceUtil.class);

    public static String getSequence(String tableName){
        if(StringUtils.isEmpty(tableName)){
            System.out.println("前缀不能为空");
        }
        String redisKey="plm_"+tableName;
        String id=null;
        try {
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
            id=simpleDateFormat.format(new Date())+String.valueOf((int)(Math.random()*90000+9999));
        }catch (Exception e){
            logger.error("生成主键失败，使用UUID,key="+redisKey);
            id= UUID.randomUUID().toString();
            logger.error("生成主键失败，使用UUID,key="+redisKey+"id="+id);
        }
        return id;
    }

}
