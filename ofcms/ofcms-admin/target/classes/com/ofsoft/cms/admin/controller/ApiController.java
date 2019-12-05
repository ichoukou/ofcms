package com.ofsoft.cms.admin.controller;

import com.alibaba.fastjson.JSON;
import com.jfinal.aop.Clear;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.SqlPara;
import com.jfinal.upload.UploadFile;
import com.ofsoft.cms.admin.controller.system.SystemUtile;
import com.ofsoft.cms.admin.service.meesage.MsgServerPool;
import com.ofsoft.cms.core.annotation.Action;
import com.ofsoft.cms.core.config.ErrorCode;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 首页接口
 * 
 * @author OF
 * @date 2019年11月08日
 */
@Action(path = "/api/cms")
public class ApiController extends BaseController {

	/**
	 * 首页轮播图
	 */
	public void banner() {
		Map<String, Object> params = getParamsMap();
		params.put("site_id","1");
		params.put("sqlid","cms.ad.query");
		SqlPara sql = Db.getSqlPara(params.get("sqlid").toString(), params);
		setPageOrderByParams(sql, getPara("field"), getPara("sort"));
		Page<Record> page = Db.paginate(getPageNum(), getPageSize(), sql);
		rendSuccessJson(page.getList(), page.getTotalRow(),
				page.getPageNumber());
	}
	/**
	 * 通知公告
	 */
	public void announce() {
		Map<String, Object> params = getParamsMap();
		params.put("site_id","1");
		params.put("sqlid","cms.content.query");
		params.put("column_id","24");//通知公告ID
		SqlPara sql = Db.getSqlPara(params.get("sqlid").toString(), params);
		setPageOrderByParams(sql, getPara("field"), getPara("sort"));
		Page<Record> page = Db.paginate(getPageNum(), getPageSize(), sql);
		rendSuccessJson(page.getList(), page.getTotalRow(),
				page.getPageNumber());
	}

	/**
	 *交流园地
	 */
	public void news() {
		Map<String, Object> params = getParamsMap();
		params.put("site_id","1");
		params.put("sqlid","cms.content.query");
		params.put("column_id","13");//通知公告ID
		SqlPara sql = Db.getSqlPara(params.get("sqlid").toString(), params);
		setPageOrderByParams(sql, getPara("field"), getPara("sort"));
		Page<Record> page = Db.paginate(getPageNum(), getPageSize(), sql);
		rendSuccessJson(page.getList(), page.getTotalRow(),
				page.getPageNumber());
	}
	public void detail() {
		Map<String, Object> params = getParamsMap();
		try {
			SqlPara sql = Db.getSqlPara(params.get("sqlid").toString(), params);
			Record record = Db.findFirst(sql);
			rendSuccessJson(record);
		} catch (Exception e) {
			e.printStackTrace();
			rendFailedJson(ErrorCode.get("9999"));
		}
	}




}
