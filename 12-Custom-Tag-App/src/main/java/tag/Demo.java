package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Demo extends TagSupport {

	public int side;

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	@Override
	public int doStartTag() throws JspException {

		try {

			JspWriter out = pageContext.getOut();

			out.print("<h1>Square Area is: " + side * side + "</h1>");

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
//			out.print("<h1>Demo Page</h1>");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return SKIP_BODY;
//	}

}
