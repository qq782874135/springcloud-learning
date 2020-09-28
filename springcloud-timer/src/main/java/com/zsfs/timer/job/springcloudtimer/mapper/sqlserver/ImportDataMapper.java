package com.zsfs.timer.job.springcloudtimer.mapper.sqlserver;

import com.zsfs.timer.job.springcloudtimer.entity.SaleDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImportDataMapper {

    public int batchInsert(List<SaleDetail> saleDetails);

    int deleteByDate(String startDate,String endDate);
}
