package com.zsfs.timer.job.springcloudtimer.mapper.mysql;

import com.zsfs.timer.job.springcloudtimer.entity.SaleDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExportDataMapper {
    @Select("SELECT\n" +
            "\ta.ChangeBillNo as ChangeBill,\n" +
            "\ta.ChangeTime,\n" +
            "\ta.ChangeName,\n" +
            "\ta.DetailId,\n" +
            "\tb.ItemId,\n" +
            "\tb.GoodsId,\n" +
            "\tb.ItemCode,\n" +
            "\td.GoodsId as GoodsId1,\n" +
            "\td.GoodsCode,\n" +
            "\td.GoodsName \n" +
            "FROM\n" +
            "\tsam_in_itemchangelog a,\n" +
            "\tsam_ba_item b,\n" +
            "\tsam_ba_goods d \n" +
            "WHERE\n" +
            "\t( a.ChangeName = \"内部销售\" OR a.ChangeName = \"其他出库\" ) \n" +
            "\tAND a.ItemId = b.ItemId \n" +
            "\tAND d.GoodsId = b.GoodsId and a.ChangeTime like #{changeTime};\n" +
            "\t")
    public List<SaleDetail> getDataList(String changeTime);
}
