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

(key (apply max-key val {0 1 1 23}))


(->> input
    (clojure.string/split-lines)
    (take 4)
    (map vec)
    (map (fn [v] (mapv #(Character/digit % 10) v))))

(defn f-frequent-bin [f input]
  (loop [i 0
         filtered-in input]
    (if (= 1 (count filtered-in))
      (first filtered-in)
      (let [bin-count (->> filtered-in
                           (apply mapv vector)
                           (map #(reduce count-bin {0 0 1 0} %)))
            new-filtered-in (filter #(= (nth % i) (key (apply f val (nth bin-count i))))
                                    filtered-in)]
        (recur (inc i)
               new-filtered-in)))))

(defn bin-array-to-dec [b]
  (let [dec-val (->> b
                     (apply str)
                     (#(Integer/parseInt % 2)))]
    dec-val))

(comment 


  (def input-corrected
    (->> input
         (clojure.string/split-lines)
         (map vec)
         (map (fn [v] (mapv #(Character/digit % 10) v)))))

  (* (->> input-corrected (f-frequent-bin max-key) bin-array-to-dec)
     (->> input-corrected (f-frequent-bin min-key) bin-array-to-dec))

(->> input
    (clojure.string/split-lines)
    (take 3)
    (map vec)
    (map (fn [v] (mapv #(Character/digit % 10) v))))

(->> input
    (clojure.string/split-lines)
    (take 3)
    (map vec)
    (map (fn [v] (mapv #(Character/digit % 10) v)))
    (f-frequent-bin max-key)
#_    (filter #(= (nth % 0) 1))
#_#_    (apply mapv vector)
    (map #(reduce count-bin {0 0 1 0} %))))

