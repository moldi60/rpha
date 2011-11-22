/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.kirunews.rpha.struts.action;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.log4j.Logger;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.queryParser.QueryParser.Operator;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kirunews.rpha.model.PoemSearcher;
import com.kirunews.rpha.model.SearchBook;
import com.kirunews.rpha.struts.form.FieldSearchForm;
import com.kirunews.rpha.struts.form.Item;
import com.kirunews.rpha.util.Logging;
import com.kirunews.rpha.util.XsltTransformator;

/** 
 * MyEclipse Struts
 * Creation date: 09-14-2009
 * 
 * XDoclet definition:
 * @struts.action path="/fieldSearch" name="fieldSearchForm" input="/form/fieldSearch.jsp" scope="request" validate="true"
 */
public class FieldSearchAction extends Action {
	/*
	 * Generated Methods
	 */
	private static Logger logger = Logging.getLogger();
	private SearchBook bookSearcher;
	private Map<String, String> bookTitles = new HashMap<String, String>();

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse response) {
		FieldSearchForm form = (FieldSearchForm) _form;
		
		String xsltDir = servlet.getServletContext().getRealPath("/xslt");
		String queryString = request.getQueryString();
		if(queryString != null) {
			queryString = queryString.replaceAll("&offset=.*?&", "&");
			queryString = queryString.replaceAll("&offset=.*?$", "");
		}

		String[] fields    = form.getFields();
		String[] operators = form.getOperators();
		String[] values    = form.getValues();
		
		StringBuffer sb = new StringBuffer();
		if(fields != null) {
			for(int i=0; i<fields.length; i++) {
				if(values[i].trim().equals("")) {
					continue;
				}
				if(sb.length() > 0) {
					sb.append(' ' + operators[i-1] + ' ');
				}
				sb.append(fields[i] + ':' + values[i]);
			}
		}
		String rawQuery = sb.toString();
		
		if(rawQuery.length() > 0) {
			//form.setMessage(rawQuery);
		QueryParser parser = new QueryParser("v1", new StandardAnalyzer());
		parser.setDefaultOperator(Operator.AND);
		int offset = (int)form.getOffset(); //form.getStartIndex();
		int limit  = 20; //form.getCount();
		try {
			Query rphaQuery = parser.parse(rawQuery + " AND (v91:0 OR v91:5)");
			PoemSearcher searcher = new PoemSearcher();
			
			Map<String, Object> results = searcher.searchByQuery(
					rphaQuery, false, limit, offset, new Sort("id"));
			List<Item> items = (List<Item>)results.get("items");
			int totalResults = Integer.parseInt(results.get("totalResults").toString());
			form.setMessage("<em>" + rawQuery + "</em>: " + results.get("totalResults") + " tal&aacute;lat");
			sb = new StringBuffer();
			int k = offset;
			for(Item item : items) {
				sb.append("<h3>" + k++ + ".) ");
				if(item.getDoctype().equals("0")) {
					sb.append("<a href='/rpha/id/" + item.getTitle() 
						+ "'>RPHA " + item.getTitle() + "</a></h3>");
				}
				else if(item.getDoctype().equals("5")) {
					String bookTitle = getBookTitle(item.getBookId());
					if(bookTitle == "") {
						bookTitle = item.getBookId();
					}
					sb.append("<a href='/rpha/id/" + item.getSyntId() 
							+ "'>RPHA " + item.getSyntId() 
							+ " (" + bookTitle + ")</a></h3>");
				}
				sb.append(transform(item.getDescription(), 
					xsltDir + "/resultList.xsl", request.getContextPath())
				);
			}
			form.setResultList(sb.toString());
			form.setFormState("keresőkérdés: " + rawQuery 
					+ ", találatok száma: " + totalResults
					+ ", megjelenített rekordok: " + offset + "-" 
					+ (totalResults < (offset+limit) ? totalResults : (offset+limit)-1)
					+ "."
			);
			
			StringBuffer links = new StringBuffer();
			if(totalResults > limit) {
				int j = 1;
				for(int i=1; i<offset; i = ((++j-1)*limit)+1){
					if(links.length() > 0) links.append(" &nbsp;");
					links.append("<a href=\"?" + queryString 
							+ "&offset=" + i + "\">" + j + "</a>");
				}
				if(links.length() > 0) links.append(" &nbsp;");
				links.append(j++);
				for(int i=((j-1)*limit)+1; i<=totalResults; i = ((++j-1)*limit)+1){
					if(links.length() > 0) links.append(" &nbsp;");
					links.append("<a href=\"?" + queryString 
							+ "&offset=" + i + "\">" + j + "</a>");
				}
			}
			form.setLinks(links.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}

		return mapping.getInputForward(); //findForward("search-rpha5");
	}
	
	private String transform(String xmlSource, String xsltFileName,
			String contextPath) {
		// logger.info(xmlSource);
		String fileNameToShow = xsltFileName.substring(xsltFileName
				.lastIndexOf("/") + 1);
		try {
			XsltTransformator t = new XsltTransformator();
			String output = t.transform(xmlSource, xsltFileName);
			return output.replaceAll("BASE_PATH", contextPath);
		} catch (FileNotFoundException e) {
			logger.error(fileNameToShow + " [File not found error] "
					+ e.getMessage());
			// searchForm.setError(fileNameToShow + " [File not found error] " +
			// e.getMessage());
		} catch (TransformerConfigurationException e) {
			logger.error(fileNameToShow + " [Transformer configuration error] "
					+ e.getMessageAndLocation());
		} catch (TransformerException e) {
			// logger.error(xmlSource);
			logger.error(fileNameToShow + " [Transformer error] "
					+ e.getMessageAndLocation() + xmlSource);
		}
		return "";
	}

	private String getBookTitle(String id) {
		if(bookTitles.containsKey(id)) {
			return bookTitles.get(id);
		}
		try {
			if(bookSearcher == null) {
				bookSearcher = new SearchBook();
			}
			ArrayList<Document> books = bookSearcher.execute("id", id);
			String title = books.get(0).get("v122") + " - " 
				+ books.get(0).get("v101") + " " + books.get(0).get("v111");
			bookTitles.put(id, title);
			return title;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}