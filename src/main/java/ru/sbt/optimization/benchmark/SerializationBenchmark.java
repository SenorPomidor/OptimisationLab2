package ru.sbt.optimization.benchmark;

import com.example.serialization.protobuf.UserProto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openjdk.jmh.annotations.*;

import ru.sbt.optimization.dto.UserDto;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class SerializationBenchmark {

    private UserDto user;
    private UserProto.User protoUser;
    private ObjectMapper objectMapper;
    private byte[] jsonData;
    private byte[] protoData;

    @Setup(Level.Trial)
    public void setUp() throws JsonProcessingException {
        user = new UserDto("Andrey", 23, "andrey@gmail.com");

        protoUser = UserProto.User.newBuilder()
                .setName(user.name())
                .setAge(user.age())
                .setEmail(user.email())
                .build();

        objectMapper = new ObjectMapper();

        jsonData = objectMapper.writeValueAsBytes(user);
        protoData = protoUser.toByteArray();
    }

    @Benchmark
    public byte[] jsonSerialize() throws JsonProcessingException {
        return objectMapper.writeValueAsBytes(user);
    }

    @Benchmark
    public byte[] protobufSerialize() {
        return protoUser.toByteArray();
    }

    @Benchmark
    public UserDto jsonDeserialize() throws IOException {
        return objectMapper.readValue(jsonData, UserDto.class);
    }

    @Benchmark
    public UserProto.User protobufDeserialize() throws IOException {
        return UserProto.User.parseFrom(protoData);
    }
}

