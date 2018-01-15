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

(defn lazy-eratosthenes-helper
  "Implement a lazily evaluated version of Eratosthenes sieve."
  [sieve candidate]
  ;; See if the sieve marked `candidate` as a prime multiple.
  (if-let [prime (get sieve candidate)]
    ;; If it is, prune `candidate` from `sieve` (as `candidate` is
    ;; always increasing) and mark the next odd multiple.
    ;; Simultaneously, see if the next odd value of `candidate` is a
    ;; prime.
    (let [new-sieve (-> sieve
                        (dissoc candidate)
                        (assoc (+ candidate
                                  prime
                                  prime)
                               prime))]
      (recur new-sieve
             (+ 2 candidate)))
    ;; Otherwise, `candidate` is a prime number.
    (let [new-sieve (assoc sieve
                           ;; Skip ahead to the next odd multiple of
                           ;; this prime.
                           (* 3 candidate)
                           candidate)]
      (cons candidate
            (lazy-seq (lazy-eratosthenes-helper new-sieve
                                                (+ 2 candidate)))))))

(defn lazy-eratosthenes
  "Public interface to `lazy-eratosthenes-helper`."
  []
  ;; Hard code the only even prime to reduce the helper's logic.
  (cons 2
        (lazy-seq (lazy-eratosthenes-helper {} 3))))

(defn primes
  [n]
  (take n [2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53]))

(defn -main
  "Print out a multiplication table of prime numbers."
  [& args]
  (println (multiplication-table (primes 10))))
