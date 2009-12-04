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
 *  保存用户个人信息（图片用绝对路径,用squid加速）
 *  @author 姜志强 
 *  2009-11-30
 */
public class SettingsInfo extends ActionSupport implements ModelDriven<UserBean>, SessionAware, ServletRequestAware {
	private UserService userService;
	UserBean userBean = new UserBean();
	Map<String, Object> session;
	HttpServletRequest request;
	private String title;
	private File upload;	//上传页面的file的name
	private String uploadFileName;
	private String uploadContentType;
	private String savePath;	//图片的保存路径,要先用绝对路径

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

	/**
	 * @return 可以换另一个取路径的方法  
	 * @throws Exception
	 */
	public String getSavePath() throws Exception {
		//return ServletActionContext.getRequest().getRealPath("/") + savePath;
		return  savePath;
	}

	public String execute() throws Exception {
		if(uploadFileName!=null){
			String path = getSavePath() + "\\" + uploadFileName;
			FileOutputStream fos = new FileOutputStream(path);			
			
			//System.out.println("path："+path);		//图片保存位置：path：D:\workspace\bird\WebRoot\/photo\3ab_d7a47830_b232_4936_8847_0d50fefcb5c9_0.jpg
			FileInputStream fis = new FileInputStream(getUpload());
			//System.out.println("File大小："+fis.available());		//File大小：4594,4.48 KB
			
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			String photoPath = savePath + "/" + uploadFileName;
			userBean.setPhotoPath(photoPath);
		}
		UserBean usrBean = (UserBean) session.get(ConstantUtil.USER);
		Long userId = usrBean.getUserId();
		userBean.setUserId(userId);
		int result = userService.updateSettingsInfo(userBean);
		if(result>0){
			//更新session里的用户信息,因为用户信息已经修改
			userBean = userService.getUserById(userBean);
			session.put(ConstantUtil.USER, userBean);
			
			return SUCCESS;
		}else{
			return LOGIN;
			//return ERROR;		//service occurent exception
		}
		
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
