package ru.sbt.optimization;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class ApplicationLab2 {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(".*SerializationBenchmark.*")
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
