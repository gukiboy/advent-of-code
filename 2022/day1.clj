(ns day1
  (:require [clojure.string :as s]))

(def input (slurp "day1-input.txt"))

(->> (s/split input #"\n")
     (partition-by #(not (s/blank? %)))
     (filter #(not= % '("")))
     (map (fn [c] (reduce + (map #(Integer/valueOf %) c))))
     (sort >)
     (take 3)
     (apply +))


