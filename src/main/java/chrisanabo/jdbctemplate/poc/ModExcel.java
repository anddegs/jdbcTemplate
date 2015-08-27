package chrisanabo.jdbctemplate.poc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.poi.xssf.usermodel.XSSFPivotTable;


public class ModExcel implements java.lang.reflect.InvocationHandler {

	private XSSFPivotTable target;
	
	private ModExcel(XSSFPivotTable target) {
		if (target == null) throw new IllegalArgumentException("'target' can't be null.");
		this.target = target;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		 
		try {
			Object result = method.invoke(target, args);
			execute(method, args);
			return result;
		} catch (InvocationTargetException e) {
			Throwable cause = e.getTargetException();
			throw cause;
		}
	}  
	
	private void execute(Method method, Object[] args) {
		// All the interesting set<Something> methods have the signature: (int index, Something value [, ...])
		if (method.getName().startsWith("addColumnLabel") ){
			
		}
	}
	
	public static XSSFPivotTable createProxy(XSSFPivotTable target) {
		return (XSSFPivotTable) Proxy.newProxyInstance(
				XSSFPivotTable.class.getClassLoader(),
				new Class[] { XSSFPivotTable.class },
				new ModExcel(target));
	};
 
}
