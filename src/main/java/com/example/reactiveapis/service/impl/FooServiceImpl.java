package com.example.reactiveapis.service.impl;

import com.example.reactiveapis.domain.Foo;
import com.example.reactiveapis.service.FooService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class FooServiceImpl implements FooService
{
	public Flux<Foo> getFoo()
	{
		List<Foo> list = new ArrayList<>();
		list.add(new Foo(1l, "A"));
		list.add(new Foo(2l, "B"));
		list.add(new Foo(3l, "C"));
		list.add(new Foo(4l, "D"));
		list.add(new Foo(5l, "E"));
		list.add(new Foo(6l, "F"));
		list.add(new Foo(7l, "G"));
		list.add(new Foo(8l, "H"));


		return Flux.interval(Duration.ofSeconds(1)).map(seq -> {
			return list.get(Math.toIntExact(seq));
		}).take(Duration.ofSeconds(list.size()+1));
	}
}
