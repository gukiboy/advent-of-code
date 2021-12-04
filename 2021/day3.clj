(ns day3)

(def input (slurp "input-day3.txt"))


;; part 1
(defn count-bin
  [bin number]
  (if (= number 0)
    {0 (inc (get bin 0)) 1 (get bin 1)}
    {0 (get bin 0) 1 (inc (get bin 1))}))


(->> input
    (clojure.string/split-lines)
    (map vec)
    (map (fn [v] (mapv #(Character/digit % 10) v)))
    (apply mapv vector)
    (map #(reduce count-bin {0 0 1 0} %))
    (map #(vector (key (apply max-key val %)) (key (apply min-key val %))))
    (apply mapv vector)
    (map #(apply str %))
    (map #(Integer/parseInt % 2))
    (apply *))

; part 2


(->> input
    (clojure.string/split-lines)
    (take 4)
    (map vec)
    (map (fn [v] (mapv #(Character/digit % 10) v))))

(->> input
    (clojure.string/split-lines)
    (take 4)
    (map vec)
    (map (fn [v] (mapv #(Character/digit % 10) v)))
    (apply mapv vector)
#_    (map #(reduce count-bin {0 0 1 0} %)))

