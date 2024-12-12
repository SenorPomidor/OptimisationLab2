Benchmark                                   Mode  Cnt    Score   Error  Units
SerializationBenchmark.jsonDeserialize      avgt    5  227,931 ± 4,350  ns/op
SerializationBenchmark.jsonSerialize        avgt    5  189,905 ± 4,063  ns/op
SerializationBenchmark.protobufDeserialize  avgt    5   42,978 ± 1,667  ns/op
SerializationBenchmark.protobufSerialize    avgt    5   29,539 ± 0,807  ns/op

Protobuf рекомендуется использовать в системах, где важна высокая производительность сериализации и десериализации, 
а также низкие накладные расходы на передачу данных (т.к. бинарный формат занимает меньше места)
JSON лучше подходит для приложений, где нужно присутствие читаемости данных (например человеком) + он широко где применим + гибок

Protobuf требует заранее заготовленный файл proto, что является минусом в статической типизации и контроля версий
JSON более динамичен и не требует явных схем