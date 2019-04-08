package com.syun.webfluxdemo.component;

import org.testng.annotations.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Optional;

/**
 * @description:
 * @program: webflux-demo
 * @author: syun
 * @create: 2018-12-28 15:43
 */
public class ApiTest {

    /**
     * 创建
     */
    @Test
    public void test01() {

//        静态生成
//        Flux.just("hello ", "world").subscribe(p -> {
//            System.out.println(p);
//            System.out.println(p);
//        });
//        Flux.fromArray(new Integer[]{1, 2, 3, 4}).subscribe(System.out::println);
//        Flux.empty().subscribe(System.out::println);
//        Flux.range(1, 10).subscribe(System.out::println);
//        Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(p-> {
//            System.out.println("time");
//            System.out.println(p);
//        });

//        使用复杂序列产生时使用

        Flux.generate(sink -> {
            sink.next("hello");
//            sink.next("world");  不能多个产生
            sink.complete();  //  需要产生完成，不然产生一个无限序列
        }).subscribe(System.out::println);

        Flux.create(sink -> {
            for (int i = 0; i < 10; i++) {
                sink.next(i);
            }
        }).subscribe(System.out::println);  //进行逐次的调用


//        mono


        Mono.fromSupplier(() -> "hello").subscribe(System.out::println);
        Mono.justOrEmpty(Optional.of("hello ")).subscribe(System.out::println);
        Mono.create(sink -> sink.success("hello")).subscribe(System.out::println);


    }

    /**
     * 操作符的使用
     */
    @Test
    public void test02() {
//        每获取20就推送到订阅者
//        Flux.range(1, 100).buffer(20).subscribe(p->{
//            System.out.println(p);
//            System.out.println("----------------------");
//        });
//
//
//        Flux.interval(Duration.ofMillis(100)).bufferTimeout(5,Duration.ofMillis(100))
//                .take(5).toStream().forEach(p->{
//            System.out.println(p);
//            System.out.println("---------------------");
//        });

//        当每个集合结合中的元素满足 Predicate 对象时推送
//        Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);

//        当集合收集的数据为 predicate 中为true 时才会收集，一旦为 false，会立即开始下一次收集，即 过滤掉错误的数据
//        Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);


//        Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(p -> System.out.println(p));
//
//        过滤器的使用
//        Flux.create(sink -> {
//            sink.next("syun");
//            sink.next("hayashihuu");
//            sink.next("time");
//        }).filter(p -> {
//            if(!"syun".equals(p.toString())){
//                return true;
//            }
//            return false;
//        }).subscribe(System.out::println);

//        take 的使用测试
//        Flux.range(1, 100).take(10).subscribe(System.out::println);

//        Flux.range(1, 100).takeWhile(i -> i < 10).subscribe(System.out::println);
//        Flux.range(1, 100).takeUntil(i -> i == 10).subscribe(System.out::println);

//        Flux.range(1, 100).reduce((x, y) -> x + y).subscribe(System.out::println);
//        Flux.range(1, 100).reduceWith(() -> 100, (x, y) -> x + y).subscribe(System.out::println);

//        Flux的合并，按照时间交织
//        Flux.merge(Flux.interval(Duration.ofMillis(100)).take(5), Flux.interval(Duration.ofMillis(50), Duration.ofMillis(50)).take(5))
//                .toStream().forEach(System.out::println);
//        按照被订阅的顺序
//        Flux.mergeSequential(Flux.interval(Duration.ofMillis(100)).take(5), Flux.interval(Duration.ofMillis(50), Duration.ofMillis(100)).take(5))
//                .toStream().forEach(System.out::println);

//        将流中每个元素转换成一个流，再把所有流中元素进行合并
//        Flux.just(5, 10)
//                .flatMap(x -> Flux.just(x + x))
//                .subscribe(System.out::println);
//        Flux.just(5, 10)
//                .flatMap(x -> Flux.interval(Duration.ofMillis(100)).take(x))
//                .toStream()
//                .forEach(System.out::println);
//        Flux.just(5, 10)
//                .flatMapSequential(x -> Flux.interval(Duration.ofMillis(100)).take(x))
//                .toStream()
//                .forEach(System.out::println);

//        concatMap 对转换之后的流的订阅是动态进行的，而 flatMapSequential 在合并之前就已经订阅了所有的流。
        Flux.just(5, 10)
                .concatMap(x -> Flux.interval(Duration.ofMillis(100)).take(x))
                .toStream()
                .forEach(System.out::println);


    }


    @Test
    public void test03() {
//        消费信息和异常处理
//        Mono.error(new IllegalAccessException())
//                .subscribe(System.out::println, System.err::println);
//        Flux.just(1, 2)
//                .subscribe(System.out::println, System.err::println);

//      异常处理返回
//        Flux.just(1, 2)
//                .concatWith(Mono.error(new IllegalAccessException()))
//                .onErrorReturn(0)
//                .subscribe(System.out::println,System.err::println);

///////////////////////////////////////////////////////////////////
//        Flux.just(1, 2)
//                .concatWith(Mono.error(new IllegalArgumentException()))
//                .onErrorResume(e -> {
//                    if (e instanceof IllegalStateException) {
//                        return Mono.just(0);
//                    } else if (e instanceof IllegalArgumentException) {
//                        return Mono.just(-1);
//                    }
//                    return Mono.empty();
//                })
//                .subscribe(System.out::println);
////////////////////////////////////////////////////////////////////

        Flux.just(1, 2)
                .concatWith(Mono.error(new IllegalAccessException()))
                .retry(1)
                .subscribe(System.out::println);


    }


    /**
     * 调度器
     */
    @Test
    public void test04() {

        Flux.create(sink -> {
            sink.next("sink:" + Thread.currentThread().getName());
            sink.complete();
        }).publishOn(Schedulers.single())
                .map(x -> x + " map: " + Thread.currentThread().getName())
                .publishOn(Schedulers.parallel())
                .toStream()
                .forEach(System.out::println);

    }
}
