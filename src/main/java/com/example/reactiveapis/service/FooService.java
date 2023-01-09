package com.example.reactiveapis.service;

import com.example.reactiveapis.domain.Foo;
import reactor.core.publisher.Flux;

public interface FooService
{
	Flux<Foo> getFoo();
}
