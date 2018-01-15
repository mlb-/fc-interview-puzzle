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
