/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.kirunews.rpha.struts.form;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 07-18-2009
 * 
 * XDoclet definition:
 * @struts.form name="multifieldSearchForm"
 */
public class MultifieldSearchForm extends ActionForm {

	private static final long serialVersionUID = -5147867213126437639L;
	
	private String rpha;
	private String chans;
	private String signe;
	private String inte; // originaly int
	private String lon;
	private String pre;
	private String refren;
	private String metr;
	private String relse1;
	private String relse1Type;
	private String relse2;
	private String relse2Type;
	private String relse3;
	private String relse3Type;

	/** aut1 property */
	private String aut1;

	/** aut2 property */
	private String aut2;

	/** incipit property */
	private String inc;

	/** titre property */
	private String titre;

	/** acr property */
	private String acr;

	/** acrost property */
	private String acrost;

	/** colo property */
	private String colo;

	/** doncolo property */
	private String doncolo;

	/** rime property */
	private String rime;

	/** syll property */
	private String syll;

	/** typme property */
	private String typme;

	/** genre1 property */
	private String genre1;

	/** genre2 property */
	private String genre2;

	/** an property */
	private String an;

	/** prec property */
	private Boolean prec;

	/** comment property */
	private String comment;

	/** ordering_field property */
	private String ordering_field;

	/** ordering_type property */
	private String ordering_type;
	
	private String formState;
	private String queryString;
	private String resultList;
	private int offset = 1;
	private String links;
	
	private Map<String, String> acrValues;
	private Map<String, String> coloValues;
	private Map<String, String> typmeValues;
	private Map<String, String> chansValues;
	private Map<String, String> signeValues;
	private Map<String, String> intValues;
	private Map<String, String> preValues;
	private Map<String, String> refrenValues;
	private Map<String, String> relseValues;
		
	private Map<String, String> ordering_types = new HashMap<String, String>();
	
	{
		// ORDERING TYPES
		ordering_types.put("DESC", "Csökkenő");
		ordering_types.put("ASC", "Növekvő");
	}

	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch(UnsupportedEncodingException e) {
			;
		}
	}

	/** 
	 * Returns the author_familyname.
	 * @return String
	 */
	public String getAut1() {
		return aut1;
	}

	/** 
	 * Set the author_familyname.
	 * @param author_familyname The author_familyname to set
	 */
	public void setAut1(String aut1) {
		this.aut1 = aut1;
	}

	/** 
	 * Returns the titre.
	 * @return String
	 */
	public String getTitre() {
		return titre;
	}

	/** 
	 * Set the titre.
	 * @param titre The titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/** 
	 * Returns the typme.
	 * @return String
	 */
	public String getTypme() {
		return typme;
	}

	/** 
	 * Set the typme.
	 * @param metrumtype The typme to set
	 */
	public void setTypme(String typme) {
		this.typme = typme;
	}

	/** 
	 * Returns the syll.
	 * @return String
	 */
	public String getSyll() {
		return syll;
	}

	/** 
	 * Set the syll.
	 * @param syll The syll to set
	 */
	public void setSyll(String syll) {
		this.syll = syll;
	}

	/** 
	 * Returns the ordering_field.
	 * @return String
	 */
	public String getOrdering_field() {
		return ordering_field;
	}

	/** 
	 * Set the ordering_field.
	 * @param ordering_field The ordering_field to set
	 */
	public void setOrdering_field(String ordering_field) {
		this.ordering_field = ordering_field;
	}

	/** 
	 * Returns the genre1.
	 * @return String
	 */
	public String getGenre1() {
		return genre1;
	}

	/** 
	 * Set the genre1.
	 * @param genre1 The genre1 to set
	 */
	public void setGenre1(String genre1) {
		this.genre1 = genre1;
	}

	/** 
	 * Returns the genre2.
	 * @return String
	 */
	public String getGenre2() {
		return genre2;
	}

	/** 
	 * Set the genre2.
	 * @param genre2 The genre2 to set
	 */
	public void setGenre2(String genre2) {
		this.genre2 = genre2;
	}

	/** 
	 * Returns the incipit.
	 * @return String
	 */
	public String getInc() {
		return inc;
	}

	/** 
	 * Set the incipit.
	 * @param incipit The incipit to set
	 */
	public void setInc(String inc) {
		this.inc = inc;
	}
	
	public String getAcr() {
		return acr;
	}

	public void setAcr(String acr) {
		this.acr = acr;
	}

	public String getAcrost() {
		return acrost;
	}

	public void setAcrost(String acrost) {
		this.acrost = acrost;
	}
	
	public String getColo() {
		return colo;
	}

	public void setColo(String colo) {
		this.colo = colo;
	}

	public String getDoncolo() {
		return doncolo;
	}

	public void setDoncolo(String doncolo) {
		this.doncolo = doncolo;
	}

	public void setRime(String rime) {
		this.rime = rime;
	}

	public String getRime() {
		return rime;
	}

	/** 
	 * Returns the ordering_type.
	 * @return String
	 */
	public String getOrdering_type() {
		return ordering_type;
	}

	/** 
	 * Set the ordering_type.
	 * @param ordering_type The ordering_type to set
	 */
	public void setOrdering_type(String ordering_type) {
		this.ordering_type = ordering_type;
	}

	/** 
	 * Returns the author_surname.
	 * @return String
	 */
	public String getAut2() {
		return aut2;
	}

	/** 
	 * Set the author_surname.
	 * @param author_surname The author_surname to set
	 */
	public void setAut2(String aut2) {
		this.aut2 = aut2;
	}
	
	public Map<String, String> getOrdering_types() {
		return ordering_types;
	}

	public void setOrdering_types(Map<String, String> ordering_types) {
		this.ordering_types = ordering_types;
	}

	public Map<String, String> getTypmeValues() {
		return typmeValues;
	}

	public void setTypmeValues(Map<String, String> typmeValues) {
		this.typmeValues = typmeValues;
	}

	public String getFormState() {
		return formState;
	}

	public void setFormState(String formState) {
		this.formState = formState;
	}

	public Map<String, String> getAcrValues() {
		return acrValues;
	}

	public void setAcrValues(Map<String, String> acrValues) {
		this.acrValues = acrValues;
	}

	public void setColoValues(Map<String, String> coloValues) {
		this.coloValues = coloValues;
	}

	public Map<String, String> getColoValues() {
		return coloValues;
	}

	public void setAn(String an) {
		this.an = an;
	}

	public String getAn() {
		return an;
	}

	public void setPrec(Boolean prec) {
		this.prec = prec;
	}

	public Boolean getPrec() {
		return prec;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setResultList(String resultList) {
		this.resultList = resultList;
	}

	public String getResultList() {
		return resultList;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getOffset() {
		return offset;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public String getLinks() {
		return links;
	}

	public void setRpha(String rpha) {
		this.rpha = rpha;
	}

	public String getRpha() {
		return rpha;
	}

	public void setChans(String chans) {
		this.chans = chans;
	}

	public String getChans() {
		return chans;
	}

	public void setChansValues(Map<String, String> chansValues) {
		this.chansValues = chansValues;
	}

	public Map<String, String> getChansValues() {
		return chansValues;
	}

	public void setSigneValues(Map<String, String> signeValues) {
		this.signeValues = signeValues;
	}

	public Map<String, String> getSigneValues() {
		return signeValues;
	}

	public void setSigne(String signe) {
		this.signe = signe;
	}

	public String getSigne() {
		return signe;
	}

	public void setInte(String inte) {
		this.inte = inte;
	}

	public String getInte() {
		return inte;
	}

	public void setIntValues(Map<String, String> intValues) {
		this.intValues = intValues;
	}

	public Map<String, String> getIntValues() {
		return intValues;
	}

	public void setPreValues(Map<String, String> preValues) {
		this.preValues = preValues;
	}

	public Map<String, String> getPreValues() {
		return preValues;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLon() {
		return lon;
	}

	public void setPre(String pre) {
		this.pre = pre;
	}

	public String getPre() {
		return pre;
	}

	public void setRefren(String refren) {
		this.refren = refren;
	}

	public String getRefren() {
		return refren;
	}

	public void setRefrenValues(Map<String, String> refrenValues) {
		this.refrenValues = refrenValues;
	}

	public Map<String, String> getRefrenValues() {
		return refrenValues;
	}

	public void setMetr(String metr) {
		this.metr = metr;
	}

	public String getMetr() {
		return metr;
	}

	public void setRelse1(String relse1) {
		this.relse1 = relse1;
	}

	public String getRelse1() {
		return relse1;
	}

	public void setRelse1Type(String relse1Type) {
		this.relse1Type = relse1Type;
	}

	public String getRelse1Type() {
		return relse1Type;
	}

	public void setRelse2(String relse2) {
		this.relse2 = relse2;
	}

	public String getRelse2() {
		return relse2;
	}

	public void setRelse2Type(String relse2Type) {
		this.relse2Type = relse2Type;
	}

	public String getRelse2Type() {
		return relse2Type;
	}

	public void setRelse3(String relse3) {
		this.relse3 = relse3;
	}

	public String getRelse3() {
		return relse3;
	}

	public void setRelse3Type(String relse3Type) {
		this.relse3Type = relse3Type;
	}

	public String getRelse3Type() {
		return relse3Type;
	}

	public void setRelseValues(Map<String, String> relseValues) {
		this.relseValues = relseValues;
	}

	public Map<String, String> getRelseValues() {
		return relseValues;
	}
	
	
	
}