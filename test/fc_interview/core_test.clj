(ns fc-interview.core-test
  (:require [clojure.test :refer :all]
            [fc-interview.core :refer :all]))

(deftest multiplication-table-test
  (testing "return a multiplication table"
    (is (= "x 0
0 0"
           (multiplication-table (range 1))))
    (is (= "x 0 1
0 0 0
1 0 1"
           (multiplication-table (range 2))))))
