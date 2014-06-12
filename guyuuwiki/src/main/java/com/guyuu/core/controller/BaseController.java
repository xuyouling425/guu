package com.guyuu.core.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.guyuu.core.mappers.BaseExample;
import com.guyuu.core.service.BaseService;


/**
 * 基础控制器
 * @Author xurz
 * @CreateTime 2013-5-30 下午10:22:50
 * @Description
 */
public class BaseController {
	
	/**
	 * 总记录数
	 */
	public static int totalsize;
	

	/**
	 * 开始的记录数
	 */
	public static int start;
	
	/**
	 * 日志服务层
	 */
//	@Resource(name="sysLogServiceImpl")
//	private BaseService logService;
	
	/**
	 * map集合，用于存放一些缓存数据
	 */
	public final static Map<String, Object> MAP = new HashMap<String, Object>();
	
//	/**
//	 * 写入系统日志
//	 * @Authod xurz
//	 * @param level 操作级别 0：登录；1：新增；2：修改；3：删除
//	 * @param module 模块名
//	 * @param content 详细内容
//	 * @throws SQLException 
//	 */
//	protected void setLog(HttpSession session,int level, String module,String content) throws SQLException{
//		SysLog log = new SysLog();
//		log.setLogId(getUUID());
//		UserSessionBean userSession = this.getUserSession(session);
//		if(userSession != null)
//			log.setUserName(userSession.getUserName());
//		log.setCreateTime(new Date());
//		log.setLevel(level);
//		log.setModule(module);
//		log.setContent(content);
//		logService.addSelective(log);
//	}
	/**
	 * 当前记录数
	 */
	//public static int curpage;
	
	protected static final String getUUID(){
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}
	
	/**
	 * 获取需要删除的主键ID
	 * @Authod xurz
	 * @param request
	 * @return 主键ID集合
	 */
	protected List<String> getDeleteIds(HttpServletRequest request) {
		//获取前台请求的用户ID（删除一条数据）
		String delId_str = request.getParameter("delId");
		//获取前台请求的用户ID（批量删除）
		String[] delId_strs  = request.getParameterValues("check_primary");

		//创建存放用户ID的集合
		List<String> values = null;
		if(delId_strs!=null && delId_strs.length>0){
			values = new ArrayList<String>();
			for(String st : delId_strs){			
				values.add(st.trim());
			}

		}

		values = new ArrayList<String>();
		values.add(delId_str.trim());
		return values;
	}
	
	/**
	 *  判断表单是否重复提交：
	 * 	如果session没有设置token令牌，或者表单没有设置token令牌,则返回true（让提交数据通过拦截）；
	 *  如果session和表单中的token值不相等，则说明此表单是重复提交的数据，则返回false（让提交数据通过拦截）。反之
	 * @Authod xurz
	 * @param session
	 * @param form_token
	 * @return
	 */
	protected static boolean checkForm(HttpSession session,String form_token){
		//获取session中的token令牌
		String token = (String) session.getAttribute("token");
		if(form_token == null || token == null){
			return true;
		}
		if(token.equals(form_token)){
			session.setAttribute("token", "");
			return true;
		}
		return false;
	}
	
	/**
	 * 对查询数据进行分页
	 * 
	 * @Authod xurz
	 * @param request
	 * @param example 查询条件
	 * @throws SQLException
	 */
	protected List<?> startPage(HttpServletRequest request, int pagesize, BaseExample example,BaseService service) throws SQLException {
		List<?> listdata = null;
		//获取当前页数
		String curpage_str = request.getParameter("curpage");
		//当前页
		int curpage = 1;
		//获取记录总数
		totalsize = service.selectCount(example);
		if(totalsize>0){
			curpage = Integer.parseInt(curpage_str);
			//计算开始查询游标
			start = (curpage - 1) * pagesize;
			listdata =service.selectPageByExample(example, start, pagesize);
		}
		//把 “数据集合” 返回给当前请求
		request.setAttribute("listdata", listdata);
		//把 “记录总数” 返回给当前请求
		request.setAttribute("totalsize", totalsize);
		//把 “当前页数” 返回给当前请求
		request.setAttribute("curpage",curpage);
		//把 “每页显示记录数” 返回给当前请求
		request.setAttribute("pagesize", pagesize);
		return listdata;
	}
	
	/**
	 * 获取登录者信息
	 * @Authod xurz
	 * @param session
	 * @return
	 */
/*	public UserSessionBean getUserSession(HttpSession session){
		UserSessionBean userSession = null;
		if(session.getAttribute(ICommKey.KH_USER_SESSION_BEAN) !=null){
			userSession = (UserSessionBean) session.getAttribute(ICommKey.KH_USER_SESSION_BEAN);
		}
		return userSession;
	}*/
	/**
	 * 获取商城会员登陆信息
	 * @Authod xurz
	 * @param session
	 * @return
	 */
/*	public WebShopMember getMemberSession(HttpSession session){
		WebShopMember memberSession = null;
		if(session.getAttribute(ICommKey.KH_WEB_MEMBER_SESSION) !=null){
			memberSession = (WebShopMember) session.getAttribute(ICommKey.KH_WEB_MEMBER_SESSION);
		}
		return memberSession;
	}*/
	
	/**
	 * 分页插件：获取新的“当前页”
	 * @Authod xurz
	 * @param curpage 当前页
	 * @param totalsize 记录总数
	 * @param pagesize 每页记录数
	 * @return
	 */
	protected static Integer newCurPage(int curpage, int totalsize, int pagesize){
		//新的“当前页”
		int new_currpage = 1;
		if(curpage==0){
			return new_currpage;
		}
		new_currpage = curpage;
		//计算新的“当前页”
		//“记录总数” 除于 “每页记录数”，如果能整除，则新的 “当前页” = “记录数” / “每页记录数”；
		//反之， “当前页” = “记录数” / “每页记录数” + 1；
		int pagecount = totalsize % pagesize ==0 ? totalsize / pagesize : (totalsize / pagesize + 1);
		//当前页不能小于1
		if(new_currpage<1) {
			new_currpage = 1;
		}
		if(new_currpage>pagecount) {
			new_currpage = pagecount;
		}
		return new_currpage;
	}

}
