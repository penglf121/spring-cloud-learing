package com.sensegrid.servlet;


import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
 
import com.alibaba.druid.support.http.StatViewServlet;

@WebServlet(urlPatterns="/druid/*",
    initParams={
         @WebInitParam(name="allow",value="127.0.0.1,192.168.163.1"),// IP������(û�����û���Ϊ�գ����������з���)
         @WebInitParam(name="deny",value="192.168.1.73"),// IP������ (���ڹ�ͬʱ��deny������allow)
         @WebInitParam(name="loginUsername",value="admin"),// �û���
         @WebInitParam(name="loginPassword",value="123456"),// ����
         @WebInitParam(name="resetEnable",value="false")// ����HTMLҳ���ϵġ�Reset All������
})
public class DruidStatViewServlet extends StatViewServlet {
	private static final long serialVersionUID = -2688872071445249539L;
}
