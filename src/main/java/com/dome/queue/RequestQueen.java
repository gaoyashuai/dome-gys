package com.dome.queue;



import org.apache.log4j.Logger;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


public class RequestQueen {

    private static Logger logger = Logger.getLogger(RequestQueen.class);

    private static Queue<RequestStatesReportVo> queue = new LinkedBlockingQueue<RequestStatesReportVo>(100);
    /**
     * 0、 需等待执行 1 、可以执行
     */
    private static String isExcute = "1";
    /**
     * 当前任务对象
     */
    private static RequestStatesReportVo taskVo;

    public static RequestStatesReportVo getTaskVo() {
        return taskVo;
    }


    public static void setTaskVo(RequestStatesReportVo taskVo) {
        RequestQueen.taskVo = taskVo;
    }


    public static String getIsExcute() {
        return isExcute;
    }


    public static void setIsExcute(String isExcute) {
        RequestQueen.isExcute = isExcute;
    }


    public static void addVo(RequestStatesReportVo vo) {
        try {
            queue.add(vo);
        } catch (IllegalStateException e) {
            logger.error("数据超过最大值了", e);
        }
    }

    public static RequestStatesReportVo getOne() {
        return queue.poll();
    }
}