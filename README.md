Building:
```
mvn package
```        

Run:
```
java -jar target/serialization-*.jar
...
```

Average result for 20Mb pojo over JSON REST vs KRYO REST:
```
Benchmark                                               Mode   Cnt    Score    Error   Units
PojoTestIT.testPojo1                                   thrpt    10    0,009 ±  0,001  ops/ms
PojoTestIT.testPojoWithKryo                            thrpt    10    0,017 ±  0,002  ops/ms
PojoTestIT.testPojo1                                    avgt    10  116,177 ± 14,960   ms/op
PojoTestIT.testPojoWithKryo                             avgt    10   56,281 ±  1,909   ms/op
PojoTestIT.testPojo1                                  sample   890  112,772 ±  1,754   ms/op
PojoTestIT.testPojo1:testPojo1·p0.00                  sample         98,042            ms/op
PojoTestIT.testPojo1:testPojo1·p0.50                  sample        108,134            ms/op
PojoTestIT.testPojo1:testPojo1·p0.90                  sample        125,567            ms/op
PojoTestIT.testPojo1:testPojo1·p0.95                  sample        136,289            ms/op
PojoTestIT.testPojo1:testPojo1·p0.99                  sample        188,529            ms/op
PojoTestIT.testPojo1:testPojo1·p0.999                 sample        227,803            ms/op
PojoTestIT.testPojo1:testPojo1·p0.9999                sample        227,803            ms/op
PojoTestIT.testPojo1:testPojo1·p1.00                  sample        227,803            ms/op
PojoTestIT.testPojoWithKryo                           sample  1696   59,078 ±  0,891   ms/op
PojoTestIT.testPojoWithKryo:testPojoWithKryo·p0.00    sample         45,548            ms/op
PojoTestIT.testPojoWithKryo:testPojoWithKryo·p0.50    sample         55,640            ms/op
PojoTestIT.testPojoWithKryo:testPojoWithKryo·p0.90    sample         73,177            ms/op
PojoTestIT.testPojoWithKryo:testPojoWithKryo·p0.95    sample         85,629            ms/op
PojoTestIT.testPojoWithKryo:testPojoWithKryo·p0.99    sample         98,832            ms/op
PojoTestIT.testPojoWithKryo:testPojoWithKryo·p0.999   sample        117,563            ms/op
PojoTestIT.testPojoWithKryo:testPojoWithKryo·p0.9999  sample        127,795            ms/op
PojoTestIT.testPojoWithKryo:testPojoWithKryo·p1.00    sample        127,795            ms/op
PojoTestIT.testPojo1                                      ss    10  118,201 ± 17,981   ms/op
PojoTestIT.testPojoWithKryo                               ss    10   61,729 ± 10,776   ms/op
```

Average result for small pojo over JSON REST vs KRYO REST:
```
Benchmark                                                    Mode     Cnt    Score   Error   Units
SmallPojoTestIT.testPojoWithJson                            thrpt      10    2,371 ± 0,911  ops/ms
SmallPojoTestIT.testPojoWithKryo                            thrpt      10    3,170 ± 0,457  ops/ms
SmallPojoTestIT.testPojoWithJson                             avgt      10    0,348 ± 0,061   ms/op
SmallPojoTestIT.testPojoWithKryo                             avgt      10    0,319 ± 0,057   ms/op
SmallPojoTestIT.testPojoWithJson                           sample  287382    0,347 ± 0,003   ms/op
SmallPojoTestIT.testPojoWithJson:testPojoWithJson·p0.00    sample            0,201           ms/op
SmallPojoTestIT.testPojoWithJson:testPojoWithJson·p0.50    sample            0,323           ms/op
SmallPojoTestIT.testPojoWithJson:testPojoWithJson·p0.90    sample            0,423           ms/op
SmallPojoTestIT.testPojoWithJson:testPojoWithJson·p0.95    sample            0,473           ms/op
SmallPojoTestIT.testPojoWithJson:testPojoWithJson·p0.99    sample            0,870           ms/op
SmallPojoTestIT.testPojoWithJson:testPojoWithJson·p0.999   sample            2,224           ms/op
SmallPojoTestIT.testPojoWithJson:testPojoWithJson·p0.9999  sample            9,516           ms/op
SmallPojoTestIT.testPojoWithJson:testPojoWithJson·p1.00    sample          232,522           ms/op
SmallPojoTestIT.testPojoWithKryo                           sample  314444    0,317 ± 0,001   ms/op
SmallPojoTestIT.testPojoWithKryo:testPojoWithKryo·p0.00    sample            0,187           ms/op
SmallPojoTestIT.testPojoWithKryo:testPojoWithKryo·p0.50    sample            0,295           ms/op
SmallPojoTestIT.testPojoWithKryo:testPojoWithKryo·p0.90    sample            0,393           ms/op
SmallPojoTestIT.testPojoWithKryo:testPojoWithKryo·p0.95    sample            0,437           ms/op
SmallPojoTestIT.testPojoWithKryo:testPojoWithKryo·p0.99    sample            0,750           ms/op
SmallPojoTestIT.testPojoWithKryo:testPojoWithKryo·p0.999   sample            1,929           ms/op
SmallPojoTestIT.testPojoWithKryo:testPojoWithKryo·p0.9999  sample            9,201           ms/op
SmallPojoTestIT.testPojoWithKryo:testPojoWithKryo·p1.00    sample           41,812           ms/op
SmallPojoTestIT.testPojoWithJson                               ss      10    2,356 ± 0,291   ms/op
SmallPojoTestIT.testPojoWithKryo                               ss      10    2,040 ± 0,306   ms/op
```
