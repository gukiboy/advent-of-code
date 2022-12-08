(ns day5
  (:require [clojure.string :as st]))

(def input (slurp "day5-input.txt"))

(defn is-num? [number]
  (try (Integer/parseInt number)
       (catch Exception _ nil)))

(defn str-to-input [str]
  (->> (st/split str #" ")
       (filter is-num?)
       (map #(Integer/parseInt %))))

(defn move-from-to
  "In cargos, moves amount $moves from stack $from to $to"
  [cargos move from to]
  (let [actual-from (- from 1)
        actual-to (- from 1)
        ]
    (if (= 0 move)
      cargos
      (recur (pop )))
    ))

(pop ([["1" "2" "3"]] 0))

(peek [1 2 3])

(conj )

(defn apop [stacks i]
  (assoc stacks i (pop (stacks i))))



(let [stacks [[1 2 3]
              [4 5]]]
  (apop stacks 0))


(let [stacks [["W" "M" "L" "F"]
              ["B" "Z" "V" "M" "F"]
              ["H" "V" "R" "S" "L" "Q"]
              ["F" "S" "V" "Q" "P" "M" "T" "J"]
              ["K" "S" "W"]
              ["F" "V" "P" "M" "R" "J" "W"]
              ["J" "Q" "C" "P" "N" "R" "F"]
              ["V" "H" "P" "S" "Z" "W" "R" "B"]
              ["B" "M" "J" "C" "G" "H" "Z" "W"]]]
  (->> (st/split input #"\n")
       (take 10)
       (map str-to-input)
 #_      (reduce #(apply (partial move-from-to %1) %2) stacks)))

(let [stacks [["W" "M" "L" "F"]
              ["B" "Z" "V" "M" "F"]
              ["H" "V" "R" "S" "L" "Q"]
              ["F" "S" "V" "Q" "P" "M" "T" "J"]
              ["K" "S" "W"]
              ["F" "V" "P" "M" "R" "J" "W"]
              ["J" "Q" "C" "P" "N" "R" "F"]
              ["V" "H" "P" "S" "Z" "W" "R" "B"]
              ["B" "M" "J" "C" "G" "H" "Z" "W"]]]
  (move-from-to stacks 3 5 7))


((partial move-from-to 12 10) 1 3)
