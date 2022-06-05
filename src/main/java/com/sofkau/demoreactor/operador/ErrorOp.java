package com.sofkau.demoreactor.operador;

import com.sofkau.demoreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class ErrorOp {

    private static final Logger log = LoggerFactory.getLogger(Creacion.class);

    public void retrying() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Uno", 11));
        persons.add(new Person(2, "Dos", 12));
        persons.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("ERROR")))
                .retry(1)
                .doOnNext(x -> log.info(x.toString()))
                .subscribe();

    }

    public void errorReturn() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Uno", 11));
        persons.add(new Person(2, "Dos", 12));
        persons.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("ERROR")))
                .onErrorReturn(new Person(0,"XXX", 99))
                .subscribe(x -> log.info(x.toString()));
    }

    public void errorResume() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Uno", 11));
        persons.add(new Person(2, "Dos", 12));
        persons.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("ERROR")))
                .onErrorResume(e -> Mono.just(new Person(0,"XXX", 99)))
                .subscribe(x -> log.info(x.toString()));
    }

    public void errorMap() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Uno", 11));
        persons.add(new Person(2, "Dos", 12));
        persons.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("ERROR")))
                .onErrorMap(e -> new InterruptedException(e.getMessage()))
                .subscribe(x -> log.info(x.toString()));
    }

}
