package br.com.marketdata.olimpiadas.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TagName {
	String nome();
}
