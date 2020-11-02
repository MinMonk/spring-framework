package com.monk.study.service;

import com.monk.study.bean.User;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * @ClassName StringToUserPropertyEditor
 * @Description: TODO
 * @Author Monk
 * @Date 2020/10/28
 * @Version V1.0
 **/
public class StringToUserPropertyEditor extends PropertyEditorSupport implements PropertyEditor {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		User user = new User();
		user.setUserName(text);
		this.setValue(user);
	}
}
