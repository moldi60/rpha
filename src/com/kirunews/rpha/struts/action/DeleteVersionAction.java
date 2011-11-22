/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.kirunews.rpha.struts.action;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kirunews.rpha.model.XmlIndexer;
import com.kirunews.rpha.struts.form.DeleteVersionForm;
import com.kirunews.rpha.util.Logging;

/** 
 * MyEclipse Struts
 * Creation date: 12-11-2007
 * 
 * XDoclet definition:
 * @struts.action path="/deleteVersion" name="deleteVersionForm" input="/form/deleteVersion.jsp" scope="request" validate="true"
 */
public class DeleteVersionAction extends Action {

	private static Logger logger = Logging.getLogger();

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) {
		DeleteVersionForm form = (DeleteVersionForm) actionForm;

		logger.info("poem: " + form.getPoem());
		logger.info("source: " + form.getSource());
		try {
			XmlIndexer indexer = new XmlIndexer();
			indexer.deleteDocs(form.getPoem(), form.getSource());
		} catch(FileNotFoundException e) {
			logger.error(e.getMessage());
			form.setError(e.getMessage());
		} catch(IOException e) {
			logger.error(e.getMessage());
			form.setError(e.getMessage());
		}
		logger.info(request.getContextPath() + "/id/" + form.getPoem());

		if(form.getError() == null) {
			response.addHeader("Location", 
					request.getContextPath() + "/id/" + form.getPoem());
			return mapping.getInputForward();
		} else {
			return mapping.getInputForward();
		}
	}
}