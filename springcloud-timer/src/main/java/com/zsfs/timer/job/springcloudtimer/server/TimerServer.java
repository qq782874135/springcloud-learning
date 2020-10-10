package com.zsfs.timer.job.springcloudtimer.server;

import com.zsfs.timer.job.springcloudtimer.entity.SaleDetail;
import com.zsfs.timer.job.springcloudtimer.mapper.mysql.ExportDataMapper;
import com.zsfs.timer.job.springcloudtimer.mapper.sqlserver.ImportDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class TimerServer {
    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    /*每天凌晨2点执行一次："0 0 2 * * ?"*/
    @Scheduled(cron="0 0 2 * * ?")
//    @Scheduled(cron="0 */1 * * * ?")
    @Transactional(rollbackFor = Exception.class)
    public void exportFunc(){
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterdayDate  = calendar.getTime();
        String dateString = sdf.format(yesterdayDate);
        try{
            List<SaleDetail> dataList = exportDataMapper.getDataList(dateString+"%");
            if(CollectionUtils.isEmpty(dataList)){
                log.warn(dateString+" ==============没有可导出数据==========");
                return;
            }
            if(dataList.size()>100){
                List<List<SaleDetail>> lists = splitList(dataList, 100);
                lists.forEach(list->{
                    int a=importDataMapper.batchInsert(list);
                    log.warn(dateString+" ==============成功导入"+a+"条数据==========");
                });
                return;
            }else {
                int b=importDataMapper.batchInsert(dataList);
                log.warn(dateString+" ==============成功导入"+b+"条数据==========");
            }
        }catch (Exception e){
            e.printStackTrace();
            log.warn(dateString+" ==============数据导入失败==========");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    @Autowired
    ExportDataMapper exportDataMapper;
    @Autowired
    ImportDataMapper importDataMapper;

    public  String forceFuncByDate(String startDate,String endDate){

        if(StringUtils.isEmpty(startDate)|| StringUtils.isEmpty(endDate)){
            return "起始时间和结束时间不能为空";
        }
        List<SaleDetail> dataList = exportDataMapper.getDataListByDate(startDate, endDate);
        if(CollectionUtils.isEmpty(dataList)){
            log.warn("强制导出 ==============没有可导出数据==========");
            return "强制导出 ==============没有可导出数据==========";
        }
        //删除该段时间数据
        int n = importDataMapper.deleteByDate(startDate, endDate);
        if(dataList.size()>100){
            List<List<SaleDetail>> lists = splitList(dataList, 100);
            lists.forEach(list->{
                int a=importDataMapper.batchInsert(list);
                log.warn("强制导出 ==============成功导入"+a+"条数据==========");
            });
        }else{
            int b =importDataMapper.batchInsert(dataList);
            log.warn("强制导出 ==============成功导入"+b+"条数据==========");
        }
        return "导出成功:"+dataList.size()+"条数据";
    }

    private   <T> List<List<T>> splitList(List<T> list, int splitSize) {
        //判断集合是否为空
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        //计算分割后的大小
        int maxSize = (list.size() + splitSize - 1) / splitSize;
        //开始分割
        return Stream.iterate(0, n -> n + 1)
                .limit(maxSize)
                .parallel()
                .map(a -> list.parallelStream().skip(a * splitSize).limit(splitSize).collect(Collectors.toList()))
                .filter(b -> !b.isEmpty())
                .collect(Collectors.toList());
    }

}
