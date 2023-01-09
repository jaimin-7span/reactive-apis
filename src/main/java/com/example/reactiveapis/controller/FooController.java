package com.example.reactiveapis.controller;

import com.example.reactiveapis.domain.Foo;
import com.example.reactiveapis.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/")
public class FooController
{
	@Autowired
	FooService testService;

	@GetMapping(value = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Foo> getFoo()
	{
		return testService.getFoo();
	}
}
