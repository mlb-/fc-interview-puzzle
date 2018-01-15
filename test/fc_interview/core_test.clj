(ns fc-interview.core-test
  (:require [clojure.test :refer :all]
            [fc-interview.core :refer :all]))

(deftest space-count-test
  (testing "A log base 10 of the squared value of the largest input in
  a collection"
    (is (= 1 (space-count [1])))
    (is (= 2 (space-count [1 5 1])))
    (is (= 3 (space-count [1 5 10 5 1])))))

(deftest multiplication-table-test
  (testing "return a multiplication table"
    (is (= "x 0
0 0"
           (multiplication-table (range 1))))
    (is (= "x 0 1
0 0 0
1 0 1"
           (multiplication-table (range 2))))
    (is (= "x  0  1  2  3  4
0  0  0  0  0  0
1  0  1  2  3  4
2  0  2  4  6  8
3  0  3  6  9 12
4  0  4  8 12 16"
           (multiplication-table (range 5))))
    (is (= "9    0   9  18  27  36  45  54  63  72  81  90
10   0  10  20  30  40  50  60  70  80  90 100"
           (-> (range 11)
               multiplication-table
               (.split "\n")
               (->> (drop 10)
                    (clojure.string/join "\n")))))))

(deftest prime-test
  (is (= [2 3 5 7 11 13 17 19 23 29 31]
         (primes 11))))

(deftest prime-multiplication-table-test
  (is (= "x    2   3   5   7  11  13  17  19  23  29
2    4   6  10  14  22  26  34  38  46  58
3    6   9  15  21  33  39  51  57  69  87
5   10  15  25  35  55  65  85  95 115 145
7   14  21  35  49  77  91 119 133 161 203
11  22  33  55  77 121 143 187 209 253 319
13  26  39  65  91 143 169 221 247 299 377
17  34  51  85 119 187 221 289 323 391 493
19  38  57  95 133 209 247 323 361 437 551
23  46  69 115 161 253 299 391 437 529 667
29  58  87 145 203 319 377 493 551 667 841"
         (multiplication-table (primes 10)))))

(deftest erastothenes-test
  (is (= [2]
         (take 1 (lazy-eratosthenes))))
  (is (= [2 3]
         (take 2 (lazy-eratosthenes)))))
