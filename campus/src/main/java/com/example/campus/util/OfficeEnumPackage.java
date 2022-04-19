package com.example.campus.util;

public enum OfficeEnumPackage {
    BANZHANG("banzhang"),
    FUBANZHANG("fubanzhang"),
    XUEXIWEIYUAN("xuexiweiyuan"),
    TIYUWEIYUAN("tiyuweiyuan"),
    WENYUWEIYUAN("wenyuweiyuan"),
    SHENGHUOWEIYUAN("shenghuoweiyuan"),
    ZUZHIWEIYUAN("zuzhiweiyuan"),
    WU("wu");
    private String office;
    private OfficeEnumPackage(String office){this.office=office;}

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public static boolean isInclude(String key){
        boolean include = false;
        for (OfficeEnumPackage e: OfficeEnumPackage.values()){
            if(e.getOffice().equals(key)){
                include = true;
                break;
            }
        }
        return include;
    }
}
