(ns fc-interview.core
  (:gen-class))

(defn space-count
  "Determine how many spaces are necessary to pretty print a
  multiplication table."
  [multiplicands]
  (let [largest (reduce max
                        multiplicands)]
    (count (str (* largest largest)))))

(defn- format-helper
  [spaces digit]
  (format (str "%" (inc spaces) "d")
          digit))

(defn multiplication-table
  "Return a multiplication table given a list of multiplicands."
  [multiplicands]
  (let [spaces (space-count multiplicands)]
    (reduce (fn [row-acc row]
              (reduce (fn [column-acc column]
                        (str column-acc
                             ;; Note: I am duplicating multiplication
                             ;; calls, except when `(= row
                             ;; column)`. However, I foresee prime
                             ;; generation as the culprit which will
                             ;; need optimization.
                             (format-helper spaces (* row column))))
                      (str row-acc
                           "\n"
                           ;; Left align the column value.
                           (format (str "%-"
                                        (max 1 (dec spaces))
                                        "d")
                                   row))
                      multiplicands))
            (reduce (fn [acc x]
                      (str acc (format-helper spaces x)))
                    (format (str "%-"
                                 (max 1 (dec spaces))
                                 "s")
                            "x")
                    multiplicands)
            multiplicands)))

(defn primes
  [n]
  (take n [2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53]))

(defn -main
  "Print out a multiplication table of prime numbers."
  [& args]
  (println (multiplication-table (primes 10))))
