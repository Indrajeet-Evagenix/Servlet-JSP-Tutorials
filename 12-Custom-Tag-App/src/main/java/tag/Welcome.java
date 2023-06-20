package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Welcome extends TagSupport {

	public String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public int doStartTag() throws JspException {

		try {

			JspWriter out = pageContext.getOut();

			out.print("<h1>" + msg + "</h1>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
//	@Override
//	public int doStartTag() throws JspException {
//
//		try {
//
//			JspWriter out = pageContext.getOut();
//
//			out.print("<h1>Good Morning</h1>");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return SKIP_BODY;
//	}

}
