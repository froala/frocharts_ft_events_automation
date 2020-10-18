package com.froalacharts.util;

import java.util.Map;

public class EventsBO {
	private long eventID;
	private String eventType;
	private boolean cancelled;
	private Map<String, Object> preventDefault;
	private boolean defaultPrevented;
	private boolean detached;
	private Map<String, Object> detachHandler;
	private String chartType;
	
	private String startDateTimeNav;
	private String endDateTimeNav;
	
	
	public String getStartDateTimeNav() {
		return startDateTimeNav;
	}

	public void setStartDateTimeNav(String startDateTimeNav) {
		this.startDateTimeNav = startDateTimeNav;
	}

	public String getEndDateTimeNav() {
		return endDateTimeNav;
	}

	public void setEndDateTimeNav(String endDateTimeNav) {
		this.endDateTimeNav = endDateTimeNav;
	}

	public String getChartType() {
		return chartType;
	}

	public void setChartType(String chartType) {
		this.chartType = chartType;
	}

	public Map<String, Object> getDetachHandler() {
		return detachHandler;
	}

	public void setDetachHandler(Map<String, Object> detachHandler) {
		this.detachHandler = detachHandler;
	}

	public boolean getDetached() {
		return detached;
	}

	public void setDetached(boolean detached) {
		this.detached = detached;
	}

	public boolean getDefaultPrevented() {
		return defaultPrevented;
	}

	public void setDefaultPrevented(boolean defaultPrevented) {
		this.defaultPrevented = defaultPrevented;
	}

	private Map<String, Object> stopPropagation;

	public Map<String, Object> getStopPropagation() {
		return stopPropagation;
	}

	public void setStopPropagation(Map<String, Object> stopPropagation) {
		this.stopPropagation = stopPropagation;
	}

	public Map<String, Object> getPreventDefault() {
		return preventDefault;
	}

	public void setPreventDefault(Map<String, Object> map) {
		this.preventDefault = map;
	}

	public boolean getCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public long getEventID() {
		return eventID;
	}

	public void setEventID(long eventID) {
		this.eventID = eventID;
	}

}
