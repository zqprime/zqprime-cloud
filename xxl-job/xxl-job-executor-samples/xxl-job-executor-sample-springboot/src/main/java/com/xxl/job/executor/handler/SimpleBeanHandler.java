package com.xxl.job.executor.handler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleBeanHandler extends IJobHandler {

    private static transient Logger logger = LoggerFactory.getLogger(SimpleBeanHandler.class);

    @XxlJob(value = "simpleBeanHandler")
    public ReturnT execute(String param) throws Exception {
        logger.info("================start================");
        return ReturnT.SUCCESS;
    }
}
