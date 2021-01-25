package com.shj.mpms.code.generate;

/**
 * 
 * <B>系统名称：VMS系统</B><BR>
 * <B>模块名称：VMS-SERVICE</B><BR>
 * <B>中文类名：数据库封装字段</B><BR>
 * <B>概要说明：</B><BR>
 * <B>@version：v1.0</B><BR>
 * <B>版本		修改人		备注</B><BR>
 * @author : Administrator
 * @date   : 2018年5月12日
 */
public class ColumnClass {

    /** 数据库字段名称 **/
    private String columnName;
    /** 数据库字段类型 **/
    private String columnType;
    /** 数据库字段首字母小写且去掉下划线字符串 **/
    private String changeColumnName;
    /** 数据库字段注释 **/
    private String columnComment;
    private Integer columnSize;
    private String nullAble = "true";
    /** 小数点位数 **/
    private Integer decimalDigits = 0;

    public Integer getDecimalDigits() {
        return decimalDigits;
    }

    public void setDecimalDigits(Integer decimalDigits) {
        this.decimalDigits = decimalDigits;
    }

    public String getNullAble() {
        return nullAble;
    }

    public void setNullAble(String nullAble) {
        this.nullAble = nullAble;
    }

    public Integer getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(Integer columnSize) {
        this.columnSize = columnSize;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getChangeColumnName() {
        return changeColumnName;
    }

    public void setChangeColumnName(String changeColumnName) {
        this.changeColumnName = changeColumnName;
    }
}