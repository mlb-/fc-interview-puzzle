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
           (multiplication-table (range 2))))))
