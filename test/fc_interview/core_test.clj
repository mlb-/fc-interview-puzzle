(ns fc-interview.core-test
  (:require [clojure.test :refer :all]
            [fc-interview.core :refer :all]))

(deftest multiplication-table-test
  (testing "return a multiplication table"
    (is (= "x 0
0 0"
           (multiplication-table (range 1))))))
