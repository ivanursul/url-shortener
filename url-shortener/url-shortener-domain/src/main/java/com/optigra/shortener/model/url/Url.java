package com.optigra.shortener.model.url;

import java.io.Serializable;

import com.optigra.shortener.model.Entity;

public class Url implements Serializable, Entity<String> {
	private static final long serialVersionUID = 1L;
	
	private String url;

	@Override
	public String getKey() {
		return getUrl();
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(final String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Url other = (Url) obj;
		if (url == null) {
			if (other.url != null) {
				return false;
			}
		} else if (!url.equals(other.url)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Url [url=" + url + "]";
	}

}
