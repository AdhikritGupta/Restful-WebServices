package com.adhikrit.rest.webservices.restful_web_services.filtering;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
				filterOutAllExcept("field1", "field2");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}
	
	@GetMapping("filtering-list")
	public MappingJacksonValue filteringList(){
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		SomeBean someBean2 = new SomeBean("value4", "value5", "value6 ");
		List<SomeBean> list = Arrays.asList(someBean, someBean2);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
//		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
//				filterOutAllExcept("field2", "field3");
//		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
//		
		mappingJacksonValue.setFilters(getFilterProvider("SomeBeanFilter", "field1", "field2"));
		
		return mappingJacksonValue;
		
	}
	
	public SimpleBeanPropertyFilter getPropertyFilter(String... fields) {
		
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
				filterOutAllExcept(fields);
        
        return filter;       
	}
	
	public FilterProvider getFilterProvider(String filter, String... fields) {
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter(filter, getPropertyFilter(fields));
		return filterProvider;
	}
}
