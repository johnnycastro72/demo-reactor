package com.sofkau.demoreactor.operador;

import com.sofkau.demoreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Transformacion {

    private static final Logger log = LoggerFactory.getLogger(Transformacion.class);

    public void map() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Uno", 11));
        persons.add(new Person(2, "Dos", 12));
        persons.add(new Person(3, "Tres", 13));

/*        Flux.fromIterable(persons)
                .map(p -> {
                    p.setAge(p.getAge() + 10);
                    return p;
                })
                .subscribe(p -> log.info("[Reactor] Persona: " + p));*/

        Flux<Integer> fx = Flux.range(0,10);
        Flux<Integer> fx2 = fx.map(x -> x+10);
        fx2.subscribe(x -> log.info("x : " + x));
    }

    public void flatMap() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Uno", 11));
        persons.add(new Person(2, "Dos", 12));
        persons.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons)
                .flatMap(p -> {
                    p.setAge(p.getAge() + 10);
                    return Mono.just(p);
                })
                .subscribe(p -> log.info(p.toString()));

    }

    public void groupBy() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Uno", 11));
        persons.add(new Person(1, "Dos", 12));
        persons.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons)
                .groupBy(Person::getIdPersona)
                .flatMap(idFlux -> idFlux.collectList())
                .subscribe(x -> log.info(x.toString()));
    }
}
