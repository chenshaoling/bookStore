
package book.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 瀛楃缂栫爜杩囨护鍣�
 */
public class CharacterEncodingFilter implements Filter {

	private FilterConfig filterConfig;
	private String encoding = "UTF-8";// 
	private boolean forceEncoding = false;//

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		String tempE = filterConfig.getInitParameter("encoding");
		String tempFE = filterConfig.getInitParameter("forceEncoding");
		if (tempE != null) {
			encoding = tempE;
		}
		if ("true".equals(tempFE)) {
			forceEncoding = true;
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		if (this.encoding != null
				&& (this.forceEncoding || request.getCharacterEncoding() == null)) {
			request.setCharacterEncoding(this.encoding);
			if (this.forceEncoding) {
				response.setCharacterEncoding(this.encoding);// 
			}
		}

		filterChain.doFilter(request, response);
	}

	public void destroy() {
	}

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public boolean isForceEncoding() {
		return forceEncoding;
	}

	public void setForceEncoding(boolean forceEncoding) {
		this.forceEncoding = forceEncoding;
	}

}
