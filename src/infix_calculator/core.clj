(ns infix-calculator.core
  (:require [infix-calculator.parse :refer [parse]]))

(defn infix
  [infixed]
  (parse infixed))
