package com.thinking.machine.hr.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
public class ResubmitPageTagHandler extends TagSupport
{
	
	private void reset()
	{
	    //do nothing
	}
	public ResubmitPageTagHandler()
	{
		reset();
	}
	
	
	public int doStartTag()
	{
       HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		String UId = request.getParameter("UId");
System.out.println(UId);
		if(UId==null)
		{
			return super.EVAL_BODY_INCLUDE;
		}
		String UIdInSession = (String)pageContext.getAttribute(UId,PageContext.SESSION_SCOPE);
		System.out.println(UIdInSession);		
		if(UIdInSession==null)
		{
			return super.EVAL_BODY_INCLUDE;
		}
		pageContext.removeAttribute(UId,PageContext.SESSION_SCOPE);
		
		if(UId.equals(UIdInSession))
		{
        return super.SKIP_BODY;
		}
		else
		{
				
		return super.EVAL_BODY_INCLUDE;
		}
		}
	public int doEndTag()
	{
		this.reset();
		return super.EVAL_PAGE;
	}
}