package com.optigra.shortener.facade.resource.url;

public class ShortUrlResource extends UrlResource {

	private String shortUrl;

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(final String shortUrl) {
		this.shortUrl = shortUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((shortUrl == null) ? 0 : shortUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ShortUrlResource other = (ShortUrlResource) obj;
		if (shortUrl == null) {
			if (other.shortUrl != null) {
				return false;
			}
		} else if (!shortUrl.equals(other.shortUrl)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ShortUrlResource [shortUrl=" + shortUrl + "]";
	}
	
}
