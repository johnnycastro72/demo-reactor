package com.sofkau.demoreactor.operador;

import com.sofkau.demoreactor.model.Person;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Creacion {

    private static final Logger log = LoggerFactory.getLogger(Creacion.class);

    public void justFrom() {
        Mono.just(new Person(1, "Mito", 29));
        // Flux.fromIterable(coleccion);
        //Observable.just(item);
    }

    public void empty() {
        Mono.empty();
        Flux.empty();
        Observable.empty();
    }

    public void range() {
        Flux.range(0,3)
                .doOnNext(i -> log.info("i: " + i))
                .subscribe();
    }

    public void repeat() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Uno", 11));
        persons.add(new Person(2, "Dos", 12));
        persons.add(new Person(3, "Tres", 13));

//        Flux.fromIterable(persons)
//                .repeat(3)
//                .subscribe(p -> log.info(p.toString()));

        Mono.just(new Person(2, "Hola", 20))
                .repeat(3)
                .subscribe(p -> log.info("[Reactor] Persona: " + p));


    }
}
