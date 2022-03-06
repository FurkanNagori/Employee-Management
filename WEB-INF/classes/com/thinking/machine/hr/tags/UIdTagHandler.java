package com.thinking.machine.hr.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
public class UIdTagHandler extends TagSupport
{
	
	private void reset()
	{
	    //do nothing
	}
	public UIdTagHandler()
	{
		reset();
	}
	
	
	public int doStartTag()
	{
        String UId = UUID.randomUUID().toString();
		pageContext.setAttribute(UId,UId,PageContext.SESSION_SCOPE);
		JspWriter jw = pageContext.getOut();
		try{
		jw.print("<input type='hidden' id='UId' name='UId' value='"+UId+"'>");
		}catch(IOException ioe){}
		return super.SKIP_BODY;
	}
	public int doEndTag()
	{
		this.reset();
		return super.EVAL_PAGE;
	}
}