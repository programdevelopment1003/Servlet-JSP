package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class FilterEX implements Filter, com.sun.org.apache.xalan.internal.xsltc.dom.Filter {
	private String encoding="UTF-8";
	public FilterEX() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public boolean test(int node) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public void destroy() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		arg0.setCharacterEncoding(encoding);
		arg1.setContentType("text/html;charset="+encoding);

		arg2.doFilter(arg0, arg1);
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO 自動生成されたメソッド・スタブ

	}

}
