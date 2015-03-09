/*
 * AngularBeans, CDI-AngularJS bridge 
 *
 * Copyright (c) 2014, Bessem Hmidi. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 */

/**
 @author Bessem Hmidi
 */
package angularBeans.extentions;


@NGExtention
public class TemplatesDirectives implements Extention {

	public String render() {

		return ("\n"
				+ "app.directive('uiTemplate', [function() {"
				+ " return {"
				+ "compile: function(tElem,attrs) {"
				+ " return function(scope,elem,attrs) {"
				+ "sessionStorage.setItem(\"URL\",document.URL);"
				+ "window.location = attrs.uiTemplate;"
				+ "};}};}]);"

				+ "app.directive('uiInsert', [function($compile) {"
				+ "return {compile: function(tElem,attrs) {"
				+ "return function(scope,elem,attrs) {"
				+ "elem.html(\"\");"
				+ "window.history.pushState(\"\", \"\", sessionStorage.getItem(\"URL\"));"
				+ "sessionStorage.setItem(\"URL\",'');"
				
				+ "var addon=sessionStorage.getItem(attrs.uiInsert);"
				+ "elem.append($compile(addon)(scope));"
				+ "};}};}])"
				
				+ ".directive('uiDefine', [function() {"
				+ "	  return {" + "   compile: function(tElem,attrs) {"
				+ "tElem.attr('hidden', 'true');"
				+ "   return function(scope,elem,attrs) {"
				+ "sessionStorage.setItem(attrs.uiDefine,elem.html());"
				+ "};}};}]);");
	}

}
