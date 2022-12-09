(ns day6
  (:require [clojure.string :as st]))

(def input (slurp "day6-input.txt"))

(defn first-unique-4
  [coll i]
  (if (empty? coll)
    nil
    (let [unique? (= 4 (-> (take 4 coll) set count))
;;          _ (prn :current-four (set (take 4 coll)))
          ]
      (if unique?
        (+ i 4)
        (recur (rest coll) (+ i 1))))))

(defn find-marker
  [coll i marker-count]
  (if (empty? coll)
    nil
    (let [unique? (= marker-count (-> (take marker-count coll) set count))]
      (if unique?
        (+ i marker-count)
        (recur (rest coll) (+ i 1) marker-count)))))

(find-marker (seq input) 0 14)

(let [coll [2]]
  (cond (empty? coll) nil)
  "moinke")
