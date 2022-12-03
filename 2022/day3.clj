(ns day3
  (:require [clojure.string :as s]
            [clojure.set :as se]))

(def input (slurp "day3-input.txt"))

(defn shared-item [bag]
  (let [first-half (subs bag (/ (.length bag) 2))
        second-half (subs bag 0 (/ (.length bag) 2))]
    (first (apply se/intersection [(set first-half) (set second-half)]))))

(defn elves-shared-item [bags]
  (first (apply se/intersection (map set bags))))

(defn item-value [c]
  (let [digit-val (int c)]
    (if (<= 97 digit-val)
      (- digit-val 96)
      (- digit-val 38))))

;; first solution
(->> (s/split input #"\n")
     (map (comp item-value shared-item))
     (reduce +))

;;second solution
(->> (s/split input #"\n")
     (partition 3)
     (map (comp item-value elves-shared-item))
     (reduce +))
(comment

  (let [input "bAnaNA"
        first-half (subs input (/ (.length input) 2))
        second-half (subs input 0 (/ (.length input) 2))]
    (apply se/intersection [(set first-half) (set second-half)])))
