package tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class testtag extends SimpleTagSupport {
	private String str;
	private int num;

	@Override
    public void doTag() 
            throws JspException, IOException
        {
    	JspContext page =  getJspContext();
    	JspWriter out = page.getOut();
    	if(num<1){
    		num=1;
    	}
    	while(num>0){
    		out.write(str);
    		out.write("<br/>");
    		num--;
    	}
        }

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}


}
