package com.sensegrid.filter;

import com.alibaba.druid.support.http.WebStatFilter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;
 
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
    initParams={
        @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")//ºöÂÔ×ÊÔ´
   })

public class DruidStatFilter extends WebStatFilter {

}
