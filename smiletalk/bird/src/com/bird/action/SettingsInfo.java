package com.bird.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bird.domain.UserBean;
import com.bird.service.UserService;
import com.bird.util.ConstantUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *  保存用户个人信息
 *  @author 姜志强 
 *  2009-11-30
 */
public class SettingsInfo extends ActionSupport implements ModelDriven<UserBean>, SessionAware, ServletRequestAware {
	private UserService userService;
	UserBean userBean = new UserBean();
	Map<String, Object> session;
	HttpServletRequest request;
	private String title;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String savePath;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setSavePath(String value) {
		this.savePath = value;
	}

	public String getSavePath() throws Exception {
		return ServletActionContext.getRequest().getRealPath("/") + savePath;
	}

	public String execute() throws Exception {
		String path = getSavePath() + "\\" + getUploadFileName();
		FileOutputStream fos = new FileOutputStream(path);			//保存位置: D:\workspace\bird\WebRoot\/photo
		System.out.println("path："+path);
		FileInputStream fis = new FileInputStream(getUpload());
		System.out.println("File大小："+fis.available());
		
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);
		}
		
		Long userId = (Long) session.get(ConstantUtil.USERID);
		userBean.setUserId(userId);
		String photoPath = savePath + "/" + getUploadFileName();
		userBean.setPhotoPath(photoPath);
		String birthday = userBean.getBirthday();
		birthday = birthday==null?"":birthday;
		userBean.setBirthday(birthday);
		String sex = userBean.getSex();
		sex = sex==null?"":sex;
		userBean.setSex(sex);
		String region = userBean.getRegion();
		region = region==null?"":region;
		userBean.setRegion(region);
		int result = userService.updateSettingsInfo(userBean);
		
		return SUCCESS;

	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserBean getModel() {
		return userBean;
	}

}
