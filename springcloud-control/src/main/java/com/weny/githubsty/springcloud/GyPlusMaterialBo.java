package com.weny.githubsty.springcloud;

import java.io.Serializable;

/**
 * @Author: Weny
 * @Date:2020/9/10
 * 面料
 */
public class GyPlusMaterialBo implements Serializable {
    /**
     * 材料编号 					--非空，若重复则根据此字段更新
     */
    private String materialCode;

    /**
     * 材料名称
     */
    private String materialName;

    /**
     * 图片地址						--传空
     */
    private String imageAddress;

    /**
     * 材料大类
     */
    private String materialBig;

    /**
     * 材料小类
     */
    private String materialSmall;

    /**
     * 门幅
     */
    private String menFu;

    /**
     * 规格单位
     */
    private String specificationUnit;

    /**
     * 经向缩率
     */
    private String jxsl;

    /**
     * 纬向缩率
     */
    private String wxsl;

    /**
     * 克重
     */
    private String kz;

    /**
     * 克损米数
     */
    private Double lossNum;

    /**
     * 染方式
     */
    private String dyeWay;

    /**
     * 设计师
     */
    private String designer;

    /**
     * 开发员
     */
    private String developer;

    /**
     * 材料颜色
     */
    private String materialColor;

    /**
     * 产品供应商
     */
    private String productProvider;

    /**
     * 供应商货号
     */
    private String providerArtNo;

    /**
     * 状态（0-未启用，1-已启用）  	--传1
     */
    private Integer useCondition;

    /**
     * 价格
     */
    private Double price;

    /**
     * 成分
     */
    private String composition;

    /**
     * 季节
     */
    private String season;

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public String getMaterialBig() {
        return materialBig;
    }

    public void setMaterialBig(String materialBig) {
        this.materialBig = materialBig;
    }

    public String getMaterialSmall() {
        return materialSmall;
    }

    public void setMaterialSmall(String materialSmall) {
        this.materialSmall = materialSmall;
    }

    public String getMenFu() {
        return menFu;
    }

    public void setMenFu(String menFu) {
        this.menFu = menFu;
    }

    public String getSpecificationUnit() {
        return specificationUnit;
    }

    public void setSpecificationUnit(String specificationUnit) {
        this.specificationUnit = specificationUnit;
    }

    public String getJxsl() {
        return jxsl;
    }

    public void setJxsl(String jxsl) {
        this.jxsl = jxsl;
    }

    public String getWxsl() {
        return wxsl;
    }

    public void setWxsl(String wxsl) {
        this.wxsl = wxsl;
    }

    public String getKz() {
        return kz;
    }

    public void setKz(String kz) {
        this.kz = kz;
    }

    public Double getLossNum() {
        return lossNum;
    }

    public void setLossNum(Double lossNum) {
        this.lossNum = lossNum;
    }

    public String getDyeWay() {
        return dyeWay;
    }

    public void setDyeWay(String dyeWay) {
        this.dyeWay = dyeWay;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getMaterialColor() {
        return materialColor;
    }

    public void setMaterialColor(String materialColor) {
        this.materialColor = materialColor;
    }

    public String getProductProvider() {
        return productProvider;
    }

    public void setProductProvider(String productProvider) {
        this.productProvider = productProvider;
    }

    public String getProviderArtNo() {
        return providerArtNo;
    }

    public void setProviderArtNo(String providerArtNo) {
        this.providerArtNo = providerArtNo;
    }

    public Integer getUseCondition() {
        return useCondition;
    }

    public void setUseCondition(Integer useCondition) {
        this.useCondition = useCondition;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "GyPlusMaterialBo{" +
                "materialCode='" + materialCode + '\'' +
                ", materialName='" + materialName + '\'' +
                ", imageAddress='" + imageAddress + '\'' +
                ", materialBig='" + materialBig + '\'' +
                ", materialSmall='" + materialSmall + '\'' +
                ", menFu='" + menFu + '\'' +
                ", specificationUnit='" + specificationUnit + '\'' +
                ", jxsl='" + jxsl + '\'' +
                ", wxsl='" + wxsl + '\'' +
                ", kz='" + kz + '\'' +
                ", lossNum=" + lossNum +
                ", dyeWay='" + dyeWay + '\'' +
                ", designer='" + designer + '\'' +
                ", developer='" + developer + '\'' +
                ", materialColor='" + materialColor + '\'' +
                ", productProvider='" + productProvider + '\'' +
                ", providerArtNo='" + providerArtNo + '\'' +
                ", useCondition=" + useCondition +
                ", price=" + price +
                ", composition='" + composition + '\'' +
                ", season='" + season + '\'' +
                '}';
    }
}
