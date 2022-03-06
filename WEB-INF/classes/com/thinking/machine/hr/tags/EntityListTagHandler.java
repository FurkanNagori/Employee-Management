package com.thinking.machine.hr.tags;
import com.thinking.machine.hr.bl.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.lang.reflect.*;
import java.util.*;
public class EntityListTagHandler extends BodyTagSupport
{
	private List list;
	private int index;
	private String populatorClass;
	private String populatorMethod;
	private String name;
	public EntityListTagHandler()
	{
		reset();
	}
	private void reset()
	{
		this.list=null;
		this.index=0;
		this.populatorClass=null;
		this.populatorMethod=null;
		this.name=null;
	}
	public void setPopulatorClass(String populatorClass)
	{
		this.populatorClass=populatorClass;
	}
	public void setPopulatorMethod(String populatorMethod)
	{
		this.populatorMethod=populatorMethod;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getPopulatorClass()
	{
		return this.populatorClass;
	}
    public String getPopulatorMethod()
	{
		return this.populatorMethod;
	}
    public String getName()
	{
		return this.name;
	}
	public int doStartTag()
	{
		try 
		{
		if(name==null || name.trim().length()==0) return super.SKIP_BODY;
		Class c = Class.forName(populatorClass);
		Object obj = c.newInstance();
		Class parameter[] = new Class[0];
		Method m = c.getMethod(populatorMethod,parameter);
		list = (List)m.invoke(obj);
		if(list.size()==0) return super.SKIP_BODY;
		if(list==null) return super.SKIP_BODY;
		Object bean = list.get(index);
		pageContext.setAttribute("SerialNumber",index+1,PageContext.REQUEST_SCOPE);
		pageContext.setAttribute(name,bean,PageContext.REQUEST_SCOPE);
		index++;
		return super.EVAL_BODY_INCLUDE;
		}catch(Throwable t)
		{
			return super.SKIP_BODY;
		}
	}
	public int doAfterBody()
	{
		if(index==list.size()) return super.SKIP_BODY;
		Object bean = list.get(index);
		pageContext.setAttribute("SerialNumber",index+1,PageContext.REQUEST_SCOPE);
	    pageContext.setAttribute(name,bean,PageContext.REQUEST_SCOPE);
		index++;
		return super.EVAL_BODY_AGAIN;
	}
	public int doEndTag()
	{
		reset();
		return EVAL_PAGE;
	}

}