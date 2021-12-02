(ns day2)

(def input (with-open [rdr (clojure.java.io/reader "input-day2.txt")]
  (doseq [line (line-seq rdr)]
    line)))

(def input-slurp (slurp "input-day2.txt"))

(clojure.repl/find-doc "import")
(int "2")
(java.lang.Integer/parseInt "2")


;; part one
(defn coordinates
  [[x y] [direction distance]]
  (let [pdistance (java.lang.Integer/parseInt distance)]
    (case direction
      "forward" [(+ x pdistance) y]
      "down"    [x (+ y pdistance)]
      "up"      [x (- y pdistance)])))

(->> (clojure.string/split input-slurp #"\n")
     (map #(clojure.string/split % #" "))
     (reduce coordinates [0 0])
     (reduce *))

;; part two

(defn coordinates-2
  [[x y aim] [cmd distance]]
  (let [pdistance (java.lang.Integer/parseInt distance)]
    (case cmd 
      "forward" [(+ x pdistance) (+ y (* aim pdistance)) aim]
      "down"    [x y (+ aim pdistance)]
      "up"      [x y (- aim pdistance)])))

(->> (clojure.string/split input-slurp #"\n")
     (map #(clojure.string/split % #" "))
     (reduce coordinates-2 [0 0 0])
     (take 2)
     (reduce *))
