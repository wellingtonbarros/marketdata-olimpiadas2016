package br.com.marketdata.olimpiadas.serialization;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;

import br.com.marketdata.olimpiadas.annotation.TagName;
import br.com.marketdata.olimpiadas.enuns.TagsXml;

public class Xml {

	public String headFromString(Object st) {
		StringBuilder xml = new StringBuilder();
		xml.append(TagsXml.INI).append(st).append(TagsXml.END);
		xml.append("\n");
		return xml.toString();
	}

	public String head(Class<?> cl) {
		StringBuilder xml = new StringBuilder();
		if (cl.isAnnotationPresent(TagName.class)) {
			Annotation anotacao = cl.getAnnotation(TagName.class);
			TagName tagName = (TagName) anotacao;
			xml.append(TagsXml.INI).append(tagName.nome()).append(TagsXml.END);
		} else {
			xml.append(TagsXml.INI).append(cl.getSimpleName()).append(TagsXml.END);
		}
		xml.append("\n");
		return xml.toString();
	}

	public String body(Object obj, String tagName) {
		StringBuilder xml = new StringBuilder();
		xml.append(TagsXml.INI).append(tagName).append(TagsXml.END);
		xml.append(obj);
		xml.append(TagsXml.INIBAR).append(tagName).append(TagsXml.END);
		return xml.toString();
	}

	public String footer(Class<?> cl) {
		StringBuilder xml = new StringBuilder();
		if (cl.isAnnotationPresent(TagName.class)) {
			Annotation anotacao = cl.getAnnotation(TagName.class);
			TagName tagName = (TagName) anotacao;
			xml.append(TagsXml.INIBAR).append(tagName.nome()).append(TagsXml.END);
		} else {
			xml.append(TagsXml.INIBAR).append(cl.getSimpleName()).append(TagsXml.END);
		}
		xml.append("\n");
		return xml.toString();
	}
	
	public String footerFromString(Object st){
		StringBuilder xml = new StringBuilder();
		xml.append(TagsXml.INIBAR).append(st).append(TagsXml.END);
		xml.append("\n");
		return xml.toString();
	}

	public String toXml(Object ts) {
		Class<?> cls = ts.getClass();
		StringBuilder xml = new StringBuilder();
		for (Field field : ts.getClass().getDeclaredFields()) {
			Field fieldObj;
			try {
				fieldObj = cls.getDeclaredField(field.getName());
				fieldObj.setAccessible(true);
				Object obj = fieldObj.get(ts);
				if (!(obj instanceof Collection<?> || obj.getClass().isArray())) {
					if (field.isAnnotationPresent(TagName.class)) {
						Annotation anotacao = field.getAnnotation(TagName.class);
						TagName tagName = (TagName) anotacao;
						xml.append(this.body(obj, tagName.nome())).append("\n");
					} else {
						xml.append(this.body(obj, field.getName())).append("\n");
					}
				}
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return xml.toString();
	}

}
