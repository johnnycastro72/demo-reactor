package com.sofkau.demoreactor;

import com.sofkau.demoreactor.model.Person;
import com.sofkau.demoreactor.operador.Condicional;
import com.sofkau.demoreactor.operador.Maths;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.sofkau.demoreactor.operador.ErrorOp;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public void reactor() {
        Mono.just(new Person(1, "Mito", 29))
                .doOnNext(p -> log.info("[Reactor] Persona: " + p))
                .subscribe(p -> log.info("[Reactor] Persona: " + p));
    }

    public void rxjava2() {
        Observable.just(new Person(1, "Mito", 29))
                .doOnNext(p -> log.info("[rxJava2] Persona: " + p))
                .subscribe(p -> log.info("[rxJava2] Persona: " + p));
    }

    public void mono() {
        Mono.just(new Person(2, "Hola", 20))
                .subscribe(p -> log.info("[Reactor] Persona: " + p));
    }

    public void flux() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Uno", 11));
        persons.add(new Person(2, "Dos", 12));
        persons.add(new Person(3, "Tres", 13));

        Flux.fromIterable(persons)
                .subscribe(p -> log.info(p.toString()));
    }

    public void fluxMono() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Uno", 11));
        persons.add(new Person(2, "Dos", 12));
        persons.add(new Person(3, "Tres", 13));

        Flux<Person> fx = Flux.fromIterable(persons);
        fx.collectList().subscribe(lista -> log.info(lista.toString()));
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoReactorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Maths app = new Maths();
        app.average();
    }
}
