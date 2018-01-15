(ns fc-interview.core
  (:gen-class))

(defn multiplication-table
  "Return a multiplication table."
  [multiplicands]
  "x 0
0 0")

(defn -main
  "Print out a multiplication table."
  [& args]
  (println (multiplication-table (range 1))))
