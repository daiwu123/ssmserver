package com.wu.util.po;

import com.wu.util.canno.ExcelMark;

import java.io.Serializable;

public class LenovoFRUBOMFilePo  implements Serializable {
    @ExcelMark(excelColName = "Lenovo EC/Doc Number")
    private String lenovoECDOCNumber;
    @ExcelMark(excelColName = "Lenovo EC/Doc Name")
    private String lenovoECDocName;
    @ExcelMark(excelColName = "MTM/Part")
    private String mtmPart;
    @ExcelMark(excelColName = "Child Part")
    private String childPart;
    @ExcelMark(excelColName = "Qty")
    private String qty;
    @ExcelMark(excelColName = "Change Type")
    private String changeType;
    @ExcelMark(excelColName = "Substitute Relationship")
    private String substituteRelationship;
    @ExcelMark(excelColName = "Version")
    private String version;
    @ExcelMark(excelColName = "EC Purpose")
    private String ecPurpose;
    @ExcelMark(excelColName = "EC Description")
    private String ecDescription;
    @ExcelMark(excelColName = "Name")
    private String name;
    @ExcelMark(excelColName = "basic_name")
    private String basicName;
    @ExcelMark(excelColName = "bac_code")
    private String bacCode;
    @ExcelMark(excelColName = "ec_number")
    private String ecNumber;
    @ExcelMark(excelColName = "bom_description")
    private String bomDescription;
    @ExcelMark(excelColName = "ComponentDescription")
    private String componentDescription;
    @ExcelMark(excelColName = "bom_comments")
    private String bomComments;
    @ExcelMark(excelColName = "Producthierarchy")
    private String producthierarchy;
    @ExcelMark(excelColName = "Is SBB")
    private String isSBB;
    @ExcelMark(excelColName = "Default Unit")
    private String defaultUnit;
    @ExcelMark(excelColName = "upc_ean_jan_code")
    private String upcEanJanCode;
    @ExcelMark(excelColName = "upc_ean_jan_type")
    private String upcEanJanType;
    @ExcelMark(excelColName = "BaseWarranty")
    private String baseWarranty;
    @ExcelMark(excelColName = "BaseWarrantyDescription")
    private String baseWarrantyDescription;
    @ExcelMark(excelColName = "CustomModelFlag")
    private String customModelFlag;
    @ExcelMark(excelColName = "item_comments")
    private String itemComments;
    @ExcelMark(excelColName = "comment_text")
    private String commentText;
    @ExcelMark(excelColName = "planning_material")
    private String planningMaterial;
    @ExcelMark(excelColName = "Type")
    private String type;
    @ExcelMark(excelColName = "Location code")
    private String locationCode;
    @ExcelMark(excelColName = "Usage code")
    private String usageCode;
    @ExcelMark(excelColName = "unspsc_code")
    private String unspscCode;
    @ExcelMark(excelColName = "disposition")
    private String disposition;
    @ExcelMark(excelColName = "State")
    private String state;
    @ExcelMark(excelColName = "status")
    private String status;
    @ExcelMark(excelColName = "Created")
    private String created;
    @ExcelMark(excelColName = "CreatedBy")
    private String createdBy;
    @ExcelMark(excelColName = "LastModified")
    private String lastModified;
    @ExcelMark(excelColName = "marketing_description")
    private String marketingDescription;
    @ExcelMark(excelColName = "ModifiedBy")
    private String modifiedBy;
    @ExcelMark(excelColName = "item_type")
    private String itemType;
    @ExcelMark(excelColName = "ESPCode")
    private String espCode;
    @ExcelMark(excelColName = "PRIOR Version")
    private String priorVersion;
    @ExcelMark(excelColName = "PRIOR ec_number")
    private String priorEcNumber;
    @ExcelMark(excelColName = "EOW Date")
    private String eowDate;
    @ExcelMark(excelColName = "GA Date")
    private String gaDate;
    @ExcelMark(excelColName = "AnnoucementDate")
    private String annoucementDate;
    @ExcelMark(excelColName = "Withdrawal Date")
    private String withdrawalDate;
    @ExcelMark(excelColName = "Qualification Date")
    private String qualificationDate;
    @ExcelMark(excelColName = "Old Material Number")
    private String oldMaterialNumber;
    @ExcelMark(excelColName = "descriptionCN")
    private String descriptionCN;

    public String getLenovoECDOCNumber() {
        return lenovoECDOCNumber;
    }

    public void setLenovoECDOCNumber(String lenovoECDOCNumber) {
        this.lenovoECDOCNumber = lenovoECDOCNumber;
    }

    public String getMtmPart() {
        return mtmPart;
    }

    public void setMtmPart(String mtmPart) {
        this.mtmPart = mtmPart;
    }

    public String getChildPart() {
        return childPart;
    }

    public void setChildPart(String childPart) {
        this.childPart = childPart;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getSubstituteRelationship() {
        return substituteRelationship;
    }

    public void setSubstituteRelationship(String substituteRelationship) {
        this.substituteRelationship = substituteRelationship;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEcPurpose() {
        return ecPurpose;
    }

    public void setEcPurpose(String ecPurpose) {
        this.ecPurpose = ecPurpose;
    }

    public String getEcDescription() {
        return ecDescription;
    }

    public void setEcDescription(String ecDescription) {
        this.ecDescription = ecDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBasicName() {
        return basicName;
    }

    public void setBasicName(String basicName) {
        this.basicName = basicName;
    }

    public String getBacCode() {
        return bacCode;
    }

    public void setBacCode(String bacCode) {
        this.bacCode = bacCode;
    }

    public String getEcNumber() {
        return ecNumber;
    }

    public void setEcNumber(String ecNumber) {
        this.ecNumber = ecNumber;
    }

    public String getBomDescription() {
        return bomDescription;
    }

    public void setBomDescription(String bomDescription) {
        this.bomDescription = bomDescription;
    }

    public String getComponentDescription() {
        return componentDescription;
    }

    public void setComponentDescription(String componentDescription) {
        this.componentDescription = componentDescription;
    }

    public String getLenovoECDocName() {
        return lenovoECDocName;
    }

    public void setLenovoECDocName(String lenovoECDocName) {
        this.lenovoECDocName = lenovoECDocName;
    }

    public String getBomComments() {
        return bomComments;
    }

    public void setBomComments(String bomComments) {
        this.bomComments = bomComments;
    }

    public String getProducthierarchy() {
        return producthierarchy;
    }

    public void setProducthierarchy(String producthierarchy) {
        this.producthierarchy = producthierarchy;
    }

    public String getIsSBB() {
        return isSBB;
    }

    public void setIsSBB(String isSBB) {
        this.isSBB = isSBB;
    }

    public String getDefaultUnit() {
        return defaultUnit;
    }

    public void setDefaultUnit(String defaultUnit) {
        this.defaultUnit = defaultUnit;
    }

    public String getUpcEanJanCode() {
        return upcEanJanCode;
    }

    public void setUpcEanJanCode(String upcEanJanCode) {
        this.upcEanJanCode = upcEanJanCode;
    }

    public String getUpcEanJanType() {
        return upcEanJanType;
    }

    public void setUpcEanJanType(String upcEanJanType) {
        this.upcEanJanType = upcEanJanType;
    }

    public String getBaseWarranty() {
        return baseWarranty;
    }

    public void setBaseWarranty(String baseWarranty) {
        this.baseWarranty = baseWarranty;
    }

    public String getBaseWarrantyDescription() {
        return baseWarrantyDescription;
    }

    public void setBaseWarrantyDescription(String baseWarrantyDescription) {
        this.baseWarrantyDescription = baseWarrantyDescription;
    }

    public String getCustomModelFlag() {
        return customModelFlag;
    }

    public void setCustomModelFlag(String customModelFlag) {
        this.customModelFlag = customModelFlag;
    }

    public String getItemComments() {
        return itemComments;
    }

    public void setItemComments(String itemComments) {
        this.itemComments = itemComments;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getPlanningMaterial() {
        return planningMaterial;
    }

    public void setPlanningMaterial(String planningMaterial) {
        this.planningMaterial = planningMaterial;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getUsageCode() {
        return usageCode;
    }

    public void setUsageCode(String usageCode) {
        this.usageCode = usageCode;
    }

    public String getUnspscCode() {
        return unspscCode;
    }

    public void setUnspscCode(String unspscCode) {
        this.unspscCode = unspscCode;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getMarketingDescription() {
        return marketingDescription;
    }

    public void setMarketingDescription(String marketingDescription) {
        this.marketingDescription = marketingDescription;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getEspCode() {
        return espCode;
    }

    public void setEspCode(String espCode) {
        this.espCode = espCode;
    }

    public String getPriorVersion() {
        return priorVersion;
    }

    public void setPriorVersion(String priorVersion) {
        this.priorVersion = priorVersion;
    }

    public String getPriorEcNumber() {
        return priorEcNumber;
    }

    public void setPriorEcNumber(String priorEcNumber) {
        this.priorEcNumber = priorEcNumber;
    }

    public String getEowDate() {
        return eowDate;
    }

    public void setEowDate(String eowDate) {
        this.eowDate = eowDate;
    }

    public String getGaDate() {
        return gaDate;
    }

    public void setGaDate(String gaDate) {
        this.gaDate = gaDate;
    }

    public String getAnnoucementDate() {
        return annoucementDate;
    }

    public void setAnnoucementDate(String annoucementDate) {
        this.annoucementDate = annoucementDate;
    }

    public String getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(String withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public String getQualificationDate() {
        return qualificationDate;
    }

    public void setQualificationDate(String qualificationDate) {
        this.qualificationDate = qualificationDate;
    }

    public String getOldMaterialNumber() {
        return oldMaterialNumber;
    }

    public void setOldMaterialNumber(String oldMaterialNumber) {
        this.oldMaterialNumber = oldMaterialNumber;
    }

    public String getDescriptionCN() {
        return descriptionCN;
    }

    public void setDescriptionCN(String descriptionCN) {
        this.descriptionCN = descriptionCN;
    }

    @Override
    public String toString() {
        return "LenovoFRUBOMFilePo{" +
                "lenovoECDOCNumber='" + lenovoECDOCNumber + '\'' +
                ", lenovoECDocName='" + lenovoECDocName + '\'' +
                ", mtmPart='" + mtmPart + '\'' +
                ", childPart='" + childPart + '\'' +
                ", qty='" + qty + '\'' +
                ", changeType='" + changeType + '\'' +
                ", substituteRelationship='" + substituteRelationship + '\'' +
                ", version='" + version + '\'' +
                ", ecPurpose='" + ecPurpose + '\'' +
                ", ecDescription='" + ecDescription + '\'' +
                ", name='" + name + '\'' +
                ", basicName='" + basicName + '\'' +
                ", bacCode='" + bacCode + '\'' +
                ", ecNumber='" + ecNumber + '\'' +
                ", bomDescription='" + bomDescription + '\'' +
                ", componentDescription='" + componentDescription + '\'' +
                ", bomComments='" + bomComments + '\'' +
                ", producthierarchy='" + producthierarchy + '\'' +
                ", isSBB='" + isSBB + '\'' +
                ", defaultUnit='" + defaultUnit + '\'' +
                ", upcEanJanCode='" + upcEanJanCode + '\'' +
                ", upcEanJanType='" + upcEanJanType + '\'' +
                ", baseWarranty='" + baseWarranty + '\'' +
                ", baseWarrantyDescription='" + baseWarrantyDescription + '\'' +
                ", customModelFlag='" + customModelFlag + '\'' +
                ", itemComments='" + itemComments + '\'' +
                ", commentText='" + commentText + '\'' +
                ", planningMaterial='" + planningMaterial + '\'' +
                ", type='" + type + '\'' +
                ", locationCode='" + locationCode + '\'' +
                ", usageCode='" + usageCode + '\'' +
                ", unspscCode='" + unspscCode + '\'' +
                ", disposition='" + disposition + '\'' +
                ", state='" + state + '\'' +
                ", status='" + status + '\'' +
                ", created='" + created + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", lastModified='" + lastModified + '\'' +
                ", marketingDescription='" + marketingDescription + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", itemType='" + itemType + '\'' +
                ", espCode='" + espCode + '\'' +
                ", priorVersion='" + priorVersion + '\'' +
                ", priorEcNumber='" + priorEcNumber + '\'' +
                ", eowDate='" + eowDate + '\'' +
                ", gaDate='" + gaDate + '\'' +
                ", annoucementDate='" + annoucementDate + '\'' +
                ", withdrawalDate='" + withdrawalDate + '\'' +
                ", qualificationDate='" + qualificationDate + '\'' +
                ", oldMaterialNumber='" + oldMaterialNumber + '\'' +
                ", descriptionCN='" + descriptionCN + '\'' +
                '}';
    }
}
