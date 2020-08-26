package com.gzeinnumer.cureencyedittext.helper;

import java.text.DecimalFormat;

public class FunctionGlobal {

    public static String formatangka(String param) {
        String format="";
        DecimalFormat decimalFormat=new DecimalFormat("#,###,###,###,###,###,###");
        if(param==null || param.equals("")){
            return "";
        }else {
            Long paramdbl=Long.valueOf(param);
            int param_int=Math.round(paramdbl);
            format=decimalFormat.format(param_int);
        }
        return format;
    }
}
