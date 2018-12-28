(ns infix-calculator.parse)

(def operators-order [{:operator '+ :order 1}
                      {:operator '- :order 1}
                      {:operator '* :order 2}
                      {:operator '/ :order 2}])

(def priorities (map :operator (filter #(= (:order %) 2) operators-order)))
(def normals (map :operator (filter #(= (:order %) 1) operators-order)))

(defn calc?
  [ops values]
  (and (not (nil? (first ops)))
       (not (nil? (first values)))))

(defn calc
  [operator operand1 operand2]
  (eval (list operator
              operand1
              operand2)))

(defn calc-order
  [operator]
  (:order (first (filter #(= (:operator %) operator) operators-order))))

(defn parse
  [infixed]
  (loop [tokens infixed
         ops '()
         numbers '()]
    (let [token (first tokens)
          remains (rest tokens)]
      (cond
        (nil? token) (calc (first ops)  (second numbers) (first numbers))
        (list? token) (parse token)
        (number? token) (recur (rest tokens)
                               ops
                               (cons token numbers))
        (ifn? token) (cond
                       (empty? ops) (recur remains
                                           (cons token ops)
                                           numbers)
                       (and (calc? ops numbers)
                            (some #(= token %) priorities)
                            (> (calc-order token)
                               (calc-order (first ops))))
                       (recur (rest remains)
                              ops
                              (cons (calc token
                                          (first numbers)
                                          (first remains))
                                    (rest numbers)))
                       (and (calc? ops numbers)
                            (= (calc-order token)
                               (calc-order (first ops))))
                       (recur remains
                              (cons token (rest ops))
                              (cons (calc (first ops)
                                          (second numbers)
                                          (first numbers))
                                    (rest (rest numbers))))
                       :else
                       (recur remains
                              (cons token ops)
                              numbers))))))
