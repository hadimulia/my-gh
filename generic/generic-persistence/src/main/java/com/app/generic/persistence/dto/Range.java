package com.app.generic.persistence.dto;

/**
 * This class using for GenericDao get with between filter.
 * <br>Using for range between start & end. FieldName is required, u must set
 * fieldName if using this class.
 * 
 * @see com.app.generic.persistence.dao.GenericDao
 * @author M Lukmanul Hakim (m.hakim &copy;Jan 17, 2019) <br>
 *         for further info contact: <i>vickyhakimm@gmail.com</i>
 * @param <T>  Type Data for field start & end.
 */
public class Range<T extends Comparable<? super T>> {
	private T start;
	private T end;
	private String name;
	
	/**
	 * name: fieldName for start & end.
	 * 
	 * @author M Lukmanul Hakim (m.hakim &copy;Jan 17, 2019) 
	 * <br>for further info contact: <i>vickyhakimm@gmail.com</i>
	 * @param name
	 */
	public Range(String name) {
		super();
		this.name = name;
	}
	
	public T getStart() {
		return start;
	}
	public void setStart(T start) {
		this.start = start;
	}
	public T getEnd() {
		return end;
	}
	public void setEnd(T end) {
		this.end = end;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
