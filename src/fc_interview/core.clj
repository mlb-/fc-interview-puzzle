(ns fc-interview.core
  (:gen-class))

(defn space-count
  "Determine how many spaces are necessary to pretty print a
  multiplication table."
  [multiplicands]
  (let [largest (reduce max
                        multiplicands)]
    (count (str (* largest largest)))))

(defn multiplication-table
  "Return a multiplication table given a list of multiplicands."
  [multiplicands]
  (reduce (fn [acc row]
            (reduce (fn [acc column]
                      ;; Note: I am duplicating multiplication calls,
                      ;; except when `(= row column)`. However, I
                      ;; foresee prime generation as the culprit which
                      ;; will need optimization.
                      (str acc " " (* row column)))
                    (str acc "\n" row)
                    multiplicands))
          (str "x " (clojure.string/join " "
                                         multiplicands))
          multiplicands))

(defn -main
  "Print out a multiplication table."
  [& args]
  (println (multiplication-table (range 1))))
