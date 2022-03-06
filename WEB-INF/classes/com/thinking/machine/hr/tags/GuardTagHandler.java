package com.thinking.machine.hr.tags;
import javax.servlet.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.io.*;
public class GuardTagHandler extends TagSupport
{
	public GuardTagHandler()
	{
		
	}
	private void reset()
	{
		
	}
	public int doStartTag()
	{
		HttpSession httpSession = (HttpSession)pageContext.getSession();
		String username=(String)pageContext.getAttribute("username",PageContext.SESSION_SCOPE);
        if(username==null)
		{
        return super.EVAL_BODY_INCLUDE;		
		}
		return super.SKIP_BODY;
	}
	public int doEndTag()
	{
		reset();
		return EVAL_PAGE;
	}
}