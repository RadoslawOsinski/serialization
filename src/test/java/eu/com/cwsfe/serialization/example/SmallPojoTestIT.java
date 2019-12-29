package eu.com.cwsfe.serialization.example;

import eu.com.cwsfe.serialization.conf.KryoHttpMessageConverter;
import org.openjdk.jmh.annotations.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmallPojoTestIT {

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @State(Scope.Thread)
    public static class RestState {

        @Setup(Level.Trial)
        public void doSetup() {
            restTemplate = new RestTemplate();
            kryoRestTemplate = new RestTemplate();

            kryoRestTemplate.setMessageConverters(Collections.singletonList(new KryoHttpMessageConverter()));
        }

        @TearDown(Level.Trial)
        public void doTearDown() {
        }

        public RestTemplate restTemplate;
        public RestTemplate kryoRestTemplate;
    }

    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime, Mode.SampleTime, Mode.SingleShotTime})
    @Fork(value = 1)
    @Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public PojoData testPojoWithJson(RestState restState) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<PojoData> response = restState.restTemplate.exchange("http://localhost:8080/smallPojo", HttpMethod.GET, entity, PojoData.class);
        PojoData resource = response.getBody();

        assertNotNull(resource);
        return resource;
    }

    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime, Mode.SampleTime, Mode.SingleShotTime})
    @Fork(value = 1)
    @Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 10)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public PojoData testPojoWithKryo(RestState restState) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(KryoHttpMessageConverter.KRYO));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<PojoData> response = restState.kryoRestTemplate.exchange("http://localhost:8080/smallPojo", HttpMethod.GET, entity, PojoData.class);
        PojoData resource = response.getBody();

        assertNotNull(resource);
        return resource;
    }
}
