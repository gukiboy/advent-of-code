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

(defn apop [stacks i]
  (assoc stacks i (pop (stacks i))))

(defn apeek [stacks i]
  (peek (stacks i)))

(defn aconj [stacks i item]
  (assoc stacks i (conj (stacks i) item)))

(defn move-from-to
  "In cargos, moves amount $moves from stack $from to $to. CrateMover 9000"
  [cargos move from to]
  (if (= 0 move)
    cargos
    (let [actual-from (- from 1)
          actual-to (- to 1)
          moved-item (apeek cargos actual-from)
          new-cargos (-> cargos (apop actual-from) (aconj actual-to moved-item))]
      (recur new-cargos (- move 1) from to))))


(defn asubvec
  [stacks i amount]
  (let [stack-i (stacks i)
        size (count stack-i)]
    (subvec stack-i (- size amount) size)))

(defn asubvec-remain
  [stacks i amount]
    (let [stack-i (stacks i)]
      (assoc stacks i (subvec stack-i 0 (- (count stack-i) amount)))))

(defn ajoin
  [stacks i moved-ar]
  (assoc stacks i (into [] (concat (stacks i) moved-ar))))

(defn move-from-to-2
  "In cargos, moves amount $moves from stack $from to $to. CrateMover 9001. "
  [cargos move from to]
  (let [actual-from (- from 1)
        actual-to (- to 1)
        moved-item (asubvec cargos actual-from move)
        new-cargos (asubvec-remain cargos actual-from move)]
    (ajoin new-cargos actual-to moved-item)))



;; Just change from move-from-to-2 to move-from-to for each solution

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
       (map str-to-input)
       (reduce #(apply move-from-to-2 %1 %2) stacks)
       (map last)
       concat))

